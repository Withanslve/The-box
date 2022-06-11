package com.neusoft.project.storage.service;

import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.project.storage.domain.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    List<UserEntity> selectUserList(UserEntity userEntity);

    int userAdd(UserEntity user);

    int userUpdate(UserEntity userEntity);


    int userDelete(long[] userIds);

    int userResetP(Long[] reset);

    int operateUserByIds(String operate, long[] userIds);

    List<UserEntity> selectCustomerList(UserEntity userEntity);

    int CustomerAdd(UserEntity userEntity);

    int CustomerUpdate(UserEntity userEntity);

    int customerDelete(long[] userIds);

    int customerRsetP(Long[] reset);

    int operateCustomerByIds(String operate, long[] userIds);
}
