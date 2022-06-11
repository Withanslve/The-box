package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.RegistEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistMapper {
    int userAdd(RegistEntity registEntity);
    List<RegistEntity> selectByAll(RegistEntity all);
}
