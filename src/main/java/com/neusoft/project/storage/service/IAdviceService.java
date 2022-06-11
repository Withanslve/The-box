package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.AdviceEntity;

import java.util.List;

public interface IAdviceService {
    List<AdviceEntity> selectAdviceList(AdviceEntity adviceEntity);
}
