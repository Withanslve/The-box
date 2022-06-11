package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.project.storage.domain.AdviceEntity;
import com.neusoft.project.storage.mapper.AppAdviceMapper;
import com.neusoft.project.storage.service.IAppAdviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class AppAdviceServiceImpl implements IAppAdviceService {

    @Resource
    private AppAdviceMapper appAdviceMapper;

    @Override
    public int AdviceAdd(AdviceEntity adviceEntity) {
        adviceEntity.setCreateTime(new Date());
        adviceEntity.setCreateBy(SecurityUtils.getUsername());
        adviceEntity.setVersion(2L);
        adviceEntity.setDelFlag("0");
        return appAdviceMapper.AdviceAdd(adviceEntity);
    }
}
