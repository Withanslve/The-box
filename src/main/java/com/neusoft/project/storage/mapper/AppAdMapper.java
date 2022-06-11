package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.AdEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppAdMapper {
    List<AdEntity> selectAdList(AdEntity adEntity);

    int pointsUpdate(AdEntity adEntity);
}
