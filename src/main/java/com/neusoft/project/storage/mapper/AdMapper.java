package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.AdEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdMapper {
    List<AdEntity> selectAdList(AdEntity adEntity);

    int AdAdd(AdEntity adEntity);

    int AdUpdate(AdEntity adEntity);

    int adDelete(Long a);


    int operateAdByIds(AdEntity adEntity);
}
