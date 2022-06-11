package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.OrdEntity;

import java.util.List;

public interface IAppOrdService {
    int orderAdd(OrdEntity ordEntity);

    List<OrdEntity> selectOrderList(OrdEntity ordEntity);

    OrdEntity selectList(long id);

    int ordDelete(long id);


    int ordoperate(long id, long operate, OrdEntity ordEntity);
}
