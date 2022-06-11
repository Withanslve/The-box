package com.neusoft.project.storage.service;

import com.neusoft.project.storage.domain.BoxSizeEntity;

import java.util.List;

public interface IAppBoxSizeService {

    List<BoxSizeEntity> selectNotUsedList(BoxSizeEntity boxSizeEntity);
}
