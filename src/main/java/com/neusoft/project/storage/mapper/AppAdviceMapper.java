package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.AdviceEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AppAdviceMapper {
    int AdviceAdd(AdviceEntity adviceEntity);
}
