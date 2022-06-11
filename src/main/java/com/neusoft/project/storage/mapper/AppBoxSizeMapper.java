package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.BoxSizeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppBoxSizeMapper {

    List<BoxSizeEntity> selectNotUsedList(BoxSizeEntity boxSizeEntity);
}
