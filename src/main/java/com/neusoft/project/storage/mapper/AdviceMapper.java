package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.AdviceEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdviceMapper {
    List<AdviceEntity> selectAdviceList(AdviceEntity adviceEntity);
}
