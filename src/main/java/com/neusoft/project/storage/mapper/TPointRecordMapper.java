package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.PointEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TPointRecordMapper {
    int insert(PointEntity points);

    List<PointEntity> selectPointsList(PointEntity pointRecordEntity);

    PointEntity select(PointEntity pointRecordEntity);
}
