package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.project.storage.domain.BoxInfoEntity;
import com.neusoft.project.storage.mapper.BoxInfoMapper;
import com.neusoft.project.storage.service.IBoxInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BoxInfoServiceImpl implements IBoxInfoService {
    @Resource
    private BoxInfoMapper boxInfoMapper;


    @Override
    public int BoxInfoAdd(BoxInfoEntity boxInfoEntity) {
        Date date = new Date();
        BoxInfoEntity boxInfo =new BoxInfoEntity();
        //判断并加入code

        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sc=new SimpleDateFormat("yyyyMMdd");
        List<BoxInfoEntity> list = boxInfoMapper.select(sm.format(date));
        System.out.println(list);
        if(list.size()>0){
            BoxInfoEntity max=boxInfoMapper.selectDateMax(sm.format(date));
            boxInfoEntity.setBoxCode(max.getMaxBoxCode()+1);

        }else{
            boxInfoEntity.setBoxCode(Long.valueOf(sc.format(date)+"000001"));
        }

        //插入用户状态
        boxInfoEntity.setIsUsed("0");
        //插入当前操作用户
        boxInfoEntity.setCreateBy(SecurityUtils.getUsername());
        //插入默认状态
        boxInfoEntity.setDelFlag("0");
        //插入版本号
        boxInfoEntity.setVersion(2L);

        boxInfoEntity.setCreateTime(date);
        return boxInfoMapper.BoxInfoAdd(boxInfoEntity);
    }

    @Override
    public int BoxInfoDelete(long[] ids) {
        int a=0;
        for (long b:ids) {
            BoxInfoEntity boxInfoEntity=boxInfoMapper.SelectIsUsedFromBoxInfo(b);

            if (boxInfoEntity.getIsUsed().equals("0")) {
                a += boxInfoMapper.BoxInfoDelete(b);
            }
            else{
                System.out.println("删除失败");
            }
//
        }
        return a;
    }

    @Override
    public List<BoxInfoEntity> selectBoxList(BoxInfoEntity boxInfoEntity) {
        return boxInfoMapper.selectBoxList(boxInfoEntity);
    }
}
