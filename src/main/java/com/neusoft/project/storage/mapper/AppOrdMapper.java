package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.OrdEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppOrdMapper {
    int orderAdd(OrdEntity ordEntity);

    List<OrdEntity> select(String format);

    OrdEntity selectDateMax(String format);

    List<OrdEntity> selectOrderList(OrdEntity ordEntity);

    OrdEntity selectList(long id);


    int ordDelete(long id);




    void updateStatusThree(long id);

    void updateStatusFour(long id);

    void updateStatusEight(long id);

    void updateStatusNine(long id);

    void updateStatusSix(OrdEntity ordEntity);
}
