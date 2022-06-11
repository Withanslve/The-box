package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.AdEntity;

import java.util.List;

public interface IAdService {
    List<AdEntity> selectAdList(AdEntity adEntity);

    int AdAdd(AdEntity adEntity);

    int AdUpdate(AdEntity adEntity);

    int adDelete(long[] ids);

    int operateAdByIds(String operate, long[] ids);
}
