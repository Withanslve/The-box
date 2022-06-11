package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.PointEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITPointRecordService {

    List<PointEntity> selectPointsList(PointEntity pointRecordEntity);


    PointEntity select(PointEntity pointRecordEntity);
}
