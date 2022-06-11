package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.BoxInfoEntity;

import java.util.List;


public interface IBoxInfoService {

    List<BoxInfoEntity> selectBoxList(BoxInfoEntity boxInfoEntity);

    int BoxInfoAdd(BoxInfoEntity boxInfoEntity);

    int BoxInfoDelete(long[] ids);
}
