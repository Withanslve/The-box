package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.project.storage.domain.PointEntity;
import com.neusoft.project.storage.mapper.TPointRecordMapper;
import com.neusoft.project.storage.service.ITPointRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class TPointRecordServiceImpl implements ITPointRecordService {
    @Resource
    private TPointRecordMapper tPointRecordMapper;

    @Override
    public List<PointEntity> selectPointsList(PointEntity pointRecordEntity) {
        return tPointRecordMapper.selectPointsList(pointRecordEntity);
    }

    @Override
    public PointEntity select(PointEntity pointRecordEntity) {
        pointRecordEntity.setUserId(SecurityUtils.getUserId());
        return tPointRecordMapper.select(pointRecordEntity);
    }


}
