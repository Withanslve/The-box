package com.neusoft.project.storage.mapper;

import com.neusoft.project.storage.domain.AdEntity;
import com.neusoft.project.storage.domain.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<UserEntity> selectUserList(UserEntity userEntity);


    int userAdd(UserEntity user);

    int userUpdate(UserEntity userEntity);

    int userDelete(long b);


    void userResetP(UserEntity userEntity);

    int operateUserByIds(UserEntity userEntity);

    List<UserEntity> selectCustomerList(UserEntity userEntity);

    int CustomerAdd(UserEntity customer);

    int CustomerUpdate(UserEntity userEntity);

    void customerRsetP(UserEntity userEntity);




    //积分增加时用户积分进行变更
    Long selectPointById(UserEntity userEntity);

    int pointAdd(UserEntity userEntity);

//    int customerDelete(long b);
}
