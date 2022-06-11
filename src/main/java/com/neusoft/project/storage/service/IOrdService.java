package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.OrdEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IOrdService {
    List<OrdEntity> selectOrderList(OrdEntity ordEntity);

    OrdEntity selectList(long id);

    int ordDelete(long[] ids);

//    int operateOrdByIds(Long id, int operate);
}
