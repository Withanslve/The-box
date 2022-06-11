package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.project.storage.domain.BoxInfoEntity;
import com.neusoft.project.storage.domain.OrdEntity;
import com.neusoft.project.storage.domain.PointEntity;
import com.neusoft.project.storage.domain.UserEntity;
import com.neusoft.project.storage.mapper.AppOrdMapper;
import com.neusoft.project.storage.mapper.BoxInfoMapper;
import com.neusoft.project.storage.mapper.TPointRecordMapper;
import com.neusoft.project.storage.mapper.UserMapper;
import com.neusoft.project.storage.service.IAppOrdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AppOrdServiceImpl implements IAppOrdService {
    @Resource
    private AppOrdMapper appOrdMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private TPointRecordMapper tPointRecordMapper;
    @Resource
    private BoxInfoMapper boxInfoMapper;

    @Override
    public int orderAdd(OrdEntity ordEntity) {
        int count=0;
        //根据传入信息查出使用的箱子

        //订单生成
        ordEntity.setUserId(SecurityUtils.getUserId());
        ordEntity.setStatus(0);
        ordEntity.setCreateTime(new Date());
        ordEntity.setCreateBy(SecurityUtils.getUsername());
        ordEntity.setDelFlag("0");
        ordEntity.setAppDelFlag(0);
        ordEntity.setBackendDelFlag(0);


        Date date=new Date();
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sc=new SimpleDateFormat("yyyyMMdd");
        List<OrdEntity> list = appOrdMapper.select(sm.format(date));
        System.out.println(list);
        if(list.size()>0){
            OrdEntity max=appOrdMapper.selectDateMax(sm.format(date));
            ordEntity.setOrderCode(max.getMaxOrderCode()+1);

        }else{
            ordEntity.setOrderCode(Long.valueOf(sc.format(date)+"000001"));
        }
        //根据小类箱子的箱子规格查询当前boxcode最小可使用的箱子
        BoxInfoEntity boxInfoEntity=new BoxInfoEntity();
        boxInfoEntity.setBoxStandard(ordEntity.getBoxStandard());
        BoxInfoEntity minbox=boxInfoMapper.selectMinBox(boxInfoEntity);

        ordEntity.setBoxCode(minbox.getBoxCode());
        ordEntity.setBoxId(minbox.getId());

        boxInfoMapper.updateBoxInfo(minbox);



        //用户表积分情况更新
        UserEntity userEntity=new UserEntity();
        userEntity.setUserId(SecurityUtils.getUserId());
        Long a=ordEntity.getTotalPrice();
        Long b=userMapper.selectPointById(userEntity);
        if(b>=a){
            userEntity.setCurrentPoints(b-a);
            userMapper.pointAdd(userEntity);
        }else {
            System.out.println("积分不足");
        }

        PointEntity points=new PointEntity();
        points.setUserId(SecurityUtils.getUserId());

        //生成积分记录表信息
        points.setWay(2);
        points.setOrderId(minbox.getId());
        Long num=ordEntity.getTotalPrice();
        Long number=-num;
        points.setPoints(number);
        points.setCreateTime(new Date());
        points.setCreateBy(SecurityUtils.getUsername());
        points.setVersion(2L);
        points.setDelFlag("0");
        tPointRecordMapper.insert(points);

        count+=appOrdMapper.orderAdd(ordEntity);



        return count;
    }

    @Override
    public List<OrdEntity> selectOrderList(OrdEntity ordEntity) {
        return appOrdMapper.selectOrderList(ordEntity);
    }

    @Override
    public OrdEntity selectList(long id) {
        return appOrdMapper.selectList(id);
    }

    @Override
    public int ordDelete(long id) {
        return appOrdMapper.ordDelete(id);
    }

    @Override
    public int ordoperate(long id, long operate, OrdEntity ordEntity) {
        if(operate==3){
            appOrdMapper.updateStatusThree(id);
        }
        else if (operate==4){
            appOrdMapper.updateStatusFour(id);
        }
        else if (operate==6){
            ordEntity.setId(id);
            appOrdMapper.updateStatusSix(ordEntity);
        }
        else if (operate==8){
            appOrdMapper.updateStatusEight(id);
        }
        else if (operate==9){
            appOrdMapper.updateStatusNine(id);
        }

        return 1;
    }


}
