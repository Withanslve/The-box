package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.project.storage.domain.AdEntity;
import com.neusoft.project.storage.mapper.AdMapper;
import com.neusoft.project.storage.service.IAdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AdServiceImpl implements IAdService {
    @Resource
    private AdMapper adMapper;

    @Override
    public List<AdEntity> selectAdList(AdEntity adEntity) {
        return adMapper.selectAdList(adEntity);
    }

    @Override
    public int AdAdd(AdEntity adEntity) {
        adEntity.setCreateTime(new Date());
        adEntity.setVersion(2L);
        adEntity.setDelFlag("0");
        adEntity.setCreateBy("待修改");
        adEntity.setIsEnable("0");
        return  adMapper.AdAdd(adEntity);
    }

    @Override
    public int AdUpdate(AdEntity adEntity) {
        return adMapper.AdUpdate(adEntity);
    }

    @Override
    public int adDelete(long[] ids) {
        int count=0;
        for (Long a:ids
             ) {
            count+= adMapper.adDelete(a);
        }
        return count;
    }

    @Override
    public int operateAdByIds(String operate, long[] ids) {
        int count=0;
        for (Long a:ids
             ) {
            AdEntity adEntity=new AdEntity();
            adEntity.setId(a);
            adEntity.setIsEnable(operate);
            adEntity.setUpdateBy(SecurityUtils.getUsername());
            adEntity.setUpdateTime(new Date());
            count += adMapper.operateAdByIds(adEntity);
        }
        return count;
    }

}
