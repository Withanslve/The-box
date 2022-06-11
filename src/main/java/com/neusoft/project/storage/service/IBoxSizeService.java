package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.BoxSizeEntity;

import java.util.List;

public interface IBoxSizeService {
    List<BoxSizeEntity> selectBoxSizeList(BoxSizeEntity boxSizeEntity);

    int BoxSizeAdd(BoxSizeEntity boxSizeEntity);

    int BoxSizeDelete(long[] ids);


    List<BoxSizeEntity> selectBoxStandardSelectList(BoxSizeEntity boxSizeEntity);
}
