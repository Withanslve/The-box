package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.project.common.domain.entity.TCustomerAddress;
import com.neusoft.project.storage.domain.AddressEntity;
import com.neusoft.project.storage.domain.BoxSizeEntity;
import com.neusoft.project.storage.mapper.AppAdressMapper;
import com.neusoft.project.storage.service.IAppAdressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AppAdressServiceImpl implements IAppAdressService {
    @Resource
    private AppAdressMapper adressMapper;

    @Override
    public TCustomerAddress select(TCustomerAddress tCustomerAddress) {
        tCustomerAddress.setUserId(SecurityUtils.getUserId());
        return adressMapper.select(tCustomerAddress);
    }

    @Override
    public List<BoxSizeEntity> selectNotUsedList(BoxSizeEntity boxSizeEntity) {
        return adressMapper.selectNotUsedList(boxSizeEntity);
    }

    @Override
    public List<AddressEntity> selectAddressList(AddressEntity addressEntity) {
        return adressMapper.selectAddressList(addressEntity);
    }

    @Override
    public int appAdress(AddressEntity addressEntity) {
        addressEntity.setCreateTime(new Date());
        addressEntity.setCreateBy(SecurityUtils.getUsername());
        addressEntity.setUserId(SecurityUtils.getUserId());
        addressEntity.setVersion(2L);
        addressEntity.setDelFlag("0");
        return adressMapper.appAdress(addressEntity);
    }

    @Override
    public int updateAdress(AddressEntity addressEntity) {
        return adressMapper.updateAdress(addressEntity);
    }

    @Override
    public int addressDelete(long id) {
        return adressMapper.addressDelete(id);
    }

    @Override
    public int defaultAddress(long id) {
        adressMapper.RestdefaultAddress(SecurityUtils.getUserId());
        return adressMapper.defaultAddress(id);
    }


}
