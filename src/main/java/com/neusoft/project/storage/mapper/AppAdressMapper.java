package com.neusoft.project.storage.mapper;

import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.project.common.domain.entity.TCustomerAddress;
import com.neusoft.project.storage.domain.AddressEntity;
import com.neusoft.project.storage.domain.BoxSizeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppAdressMapper {
    TCustomerAddress select(TCustomerAddress tCustomerAddress);

    List<BoxSizeEntity> selectNotUsedList(BoxSizeEntity boxSizeEntity);

    List<AddressEntity> selectAddressList(AddressEntity addressEntity);

    int appAdress(AddressEntity addressEntity);

    int updateAdress(AddressEntity addressEntity);

    int addressDelete(long id);

    int defaultAddress(long id);

    void RestdefaultAddress(Long userId);
}
