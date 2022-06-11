package com.neusoft.project.storage.service.impl;

import com.neusoft.project.storage.domain.BoxSizeEntity;
import com.neusoft.project.storage.mapper.AppBoxSizeMapper;
import com.neusoft.project.storage.service.IAppBoxSizeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AppBoxSizeServiceImpl implements IAppBoxSizeService {
    @Resource
    private AppBoxSizeMapper appBoxSizeMapper;


    @Override
    public List<BoxSizeEntity> selectNotUsedList(BoxSizeEntity boxSizeEntity) {
        return appBoxSizeMapper.selectNotUsedList(boxSizeEntity);
    }
}
