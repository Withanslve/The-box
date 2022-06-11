package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.AdEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAppAdService {
    List<AdEntity> selectAdList(AdEntity adEntity);

    int pointsUpdate(AdEntity adEntity);
}
