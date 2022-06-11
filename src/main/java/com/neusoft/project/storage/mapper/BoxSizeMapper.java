package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.BoxInfoEntity;
import com.neusoft.project.storage.domain.BoxSizeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoxSizeMapper {
    List<BoxSizeEntity> selectBoxSizeList(BoxSizeEntity boxSizeEntity);

    int BoxSizeAdd(BoxSizeEntity boxSizeEntity);


    List<BoxSizeEntity> selectbyc(String boxStandard);


    BoxSizeEntity selectByPrice(String boxStandard);


    BoxSizeEntity selectByid(long b);

    int BoxSizeDelete(long b);

    List<BoxSizeEntity> selectBoxStandardSelectList(BoxSizeEntity boxSizeEntity);
}
