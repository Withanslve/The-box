package com.neusoft.project.storage.service;

import com.neusoft.project.common.domain.entity.TCustomerAddress;
import com.neusoft.project.storage.domain.AddressEntity;
import com.neusoft.project.storage.domain.BoxSizeEntity;

import java.util.List;

public interface IAppAdressService {


    TCustomerAddress select(TCustomerAddress tCustomerAddress);

    List<BoxSizeEntity> selectNotUsedList(BoxSizeEntity boxSizeEntity);

    List<AddressEntity> selectAddressList(AddressEntity addressEntity);

    int appAdress(AddressEntity addressEntity);

    int updateAdress(AddressEntity addressEntity);

    int addressDelete(long id);

    int defaultAddress(long id);
}
