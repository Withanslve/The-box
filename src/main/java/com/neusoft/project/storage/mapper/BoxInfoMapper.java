package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.BoxInfoEntity;
import com.neusoft.project.storage.domain.BoxSizeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoxInfoMapper {


    int BoxInfoAdd(BoxInfoEntity boxInfoEntity);


    List<BoxInfoEntity> select(String format);


    BoxInfoEntity selectDateMax(String format);


    List<BoxInfoEntity> selectByBoxStandard(String boxStandard);

    List<BoxInfoEntity> selectBoxList(BoxInfoEntity boxInfoEntity);

    int BoxInfoDelete(long b);

    BoxInfoEntity SelectIsUsedFromBoxInfo(long b);

    BoxInfoEntity selectMinBox(BoxInfoEntity boxInfoEntity);

    void updateBoxInfo(BoxInfoEntity boxInfoEntity);
}
