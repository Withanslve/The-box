package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.project.storage.domain.UserEntity;
import com.neusoft.project.storage.mapper.UserMapper;
import com.neusoft.project.storage.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserEntity> selectUserList(UserEntity userEntity) {
        userEntity.setUserType("01");
        return userMapper.selectUserList(userEntity);
    }

    @Override
    public int userAdd(UserEntity user) {
        user.setUserType("01");
        user.setPassword(SecurityUtils.encryptPassword("123456"));
        user.setStatus("0");
        user.setCreateBy(SecurityUtils.getUsername());
        Date date=new Date();
        user.setCreateTime(date);
        int count=userMapper.userAdd(user);
        return count;
    }

    @Override
    public int userUpdate(UserEntity userEntity) {
        userEntity.setUpdateBy(SecurityUtils.getUsername());
        Date date=new Date();
        userEntity.setUpdateTime(date);
        int count = userMapper.userUpdate(userEntity);
        if(0 == count) {
            log.error("修改客户信息失败");
        }
        return count;
    }

    @Override
    public int userDelete(long[] userIds) {
        try{
            for (long b:userIds
            ) {
                userMapper.userDelete(b);
            }
            return 1;
        }catch (Exception e){
            log.error("删除用户信息错误：{}",e.getLocalizedMessage());
        }
        return 0;
    }

    @Override
    public int userResetP(Long[] reset) {
        try{
            for (long b:reset) {
                UserEntity userEntity =new UserEntity();
                userEntity.setUserId(b);
                userEntity.setPassword(SecurityUtils.encryptPassword("123456"));
                userMapper.userResetP(userEntity);
            }
            return 1;
        }catch (Exception e){
            log.error("修改用户密码错误：{}",e.getLocalizedMessage());
        }
        return 0;
    }

    @Override
    public int operateUserByIds(String operate, long[] userIds) {
        try{
            int n=0;
            for (long b:userIds) {
                UserEntity userEntity =new UserEntity();
                userEntity.setUserId(b);
                userEntity.setStatus(operate);
                userEntity.setUpdateBy(SecurityUtils.getUsername());
                n += userMapper.operateUserByIds(userEntity);
            }
            return n;
        }catch (Exception e){
            log.error("修改启动错误：{}",e.getLocalizedMessage());
        }
        return 0;
    }

//    <!*-------------------------客户接口--------------------------------------*!>
    @Override
    public List<UserEntity> selectCustomerList(UserEntity userEntity) {
        return userMapper.selectCustomerList(userEntity);
    }

    @Override
    public int CustomerAdd(UserEntity customer) {
        customer.setUserType("01");
        customer.setPassword(SecurityUtils.encryptPassword("123456"));
        customer.setStatus("0");
        customer.setCreateBy(SecurityUtils.getUsername());
        customer.setCurrentPoints(10000);
        Date date = new Date();
        customer.setCreateTime(date);
        int count = userMapper.CustomerAdd(customer);
        return count;
    }

    @Override
    public int CustomerUpdate(UserEntity userEntity) {
        userEntity.setUpdateBy(SecurityUtils.getUsername());
        Date date=new Date();
        userEntity.setUpdateTime(date);
        int count = userMapper.CustomerUpdate(userEntity);
        if(0 == count) {
            log.error("修改客户信息失败");
        }
        return count;
    }

    @Override
    public int customerDelete(long[] userIds) {
        try {
            for (long b : userIds
            ) {
                userMapper.userDelete(b);
            }
            return 1;
        } catch (Exception e) {
            log.error("删除用户信息错误：{}", e.getLocalizedMessage());
        }
        return 0;
    }

    @Override
    public int customerRsetP(Long[] reset) {
        try{
            for (long b:reset) {
                UserEntity userEntity =new UserEntity();
                userEntity.setUserId(b);
                userEntity.setPassword(SecurityUtils.encryptPassword("123456"));
                userMapper.customerRsetP(userEntity);
            }
            return 1;
        }catch (Exception e){
            log.error("修改用户密码错误：{}",e.getLocalizedMessage());
        }
        return 0;
    }

    @Override
    public int operateCustomerByIds(String operate, long[] userIds) {
        try{
            int n=0;
            for (long b:userIds) {
                UserEntity userEntity =new UserEntity();
                userEntity.setUserId(b);
                userEntity.setStatus(operate);
                userEntity.setUpdateBy(SecurityUtils.getUsername());
                n += userMapper.operateUserByIds(userEntity);
            }
            return n;
        }catch (Exception e){
            log.error("修改启动错误：{}",e.getLocalizedMessage());
        }
        return 0;
    }


}


