package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.project.storage.domain.AdEntity;
import com.neusoft.project.storage.domain.PointEntity;
import com.neusoft.project.storage.domain.UserEntity;
import com.neusoft.project.storage.mapper.AppAdMapper;
import com.neusoft.project.storage.mapper.TPointRecordMapper;
import com.neusoft.project.storage.mapper.UserMapper;
import com.neusoft.project.storage.service.IAppAdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AppAdServiceImpl implements IAppAdService {

    @Resource
    private AppAdMapper appAdMapper;
    @Resource
    private UserMapper userMapper;

    @Resource
    private TPointRecordMapper tPointRecordMapper;

    @Override
    public List<AdEntity> selectAdList(AdEntity adEntity) {
        return appAdMapper.selectAdList(adEntity);
    }

    @Override
    public int pointsUpdate(AdEntity adEntity) {

        int count=0;
        UserEntity userEntity=new UserEntity();
        //获得当前用户id
        userEntity.setUserId(SecurityUtils.getUserId());
        //获得前端传入广告积分值
        Long a=adEntity.getPoints();
        //定义b获取出当前状态下user积分
        Long b=userMapper.selectPointById(userEntity);
        //对user积分进行传入操作
        userEntity.setCurrentPoints(a+b);
        //更新用户表积分情况
        userMapper.pointAdd(userEntity);


        PointEntity points=new PointEntity();
        points.setUserId(SecurityUtils.getUserId());
        points.setAdvertisementId(adEntity.getAdvertisementId());
        points.setWay(2);
        points.setPoints(adEntity.getPoints());
        points.setCreateTime(new Date());
        points.setCreateBy(SecurityUtils.getUsername());
        points.setVersion(2L);
        points.setDelFlag("0");
        count += tPointRecordMapper.insert(points);
        return count;
    }
}
