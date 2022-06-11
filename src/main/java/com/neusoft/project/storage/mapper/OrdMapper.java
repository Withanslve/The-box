package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.OrdEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdMapper {



    List<OrdEntity> selectOrderList(OrdEntity ordEntity);


    OrdEntity selectList(long id);

    int ordDelete(Long a);

    int operateOrdByIds(OrdEntity ordEntity);
}
