package com.neusoft.project.storage.service.impl;

import com.neusoft.project.storage.domain.AdviceEntity;
import com.neusoft.project.storage.mapper.AdviceMapper;
import com.neusoft.project.storage.service.IAdviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AdviceServiceImpl implements IAdviceService {
    @Resource
    private AdviceMapper adviceMapper;

    @Override
    public List<AdviceEntity> selectAdviceList(AdviceEntity adviceEntity) {
        return adviceMapper.selectAdviceList(adviceEntity);
    }
}
