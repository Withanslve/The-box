package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.project.storage.domain.RegistEntity;
import com.neusoft.project.storage.mapper.RegistMapper;
import com.neusoft.project.storage.mapper.UserMapper;
import com.neusoft.project.storage.service.IRegistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RegistServiceImpl implements IRegistService {
    @Resource
    private RegistMapper registMapper;

    @Override
    public int userAdd(RegistEntity registEntity) {
            int count=0;
            RegistEntity all=new RegistEntity();
            all.setUserName(registEntity.getUserName());
            all.setEmail(registEntity.getEmail());
            all.setPhonenumber(registEntity.getPhonenumber());
            List<RegistEntity> list=registMapper.selectByAll(all);
            if (list.isEmpty()){
                registEntity.setUserType("02");
                registEntity.setPassword(SecurityUtils.encryptPassword("123456"));
                registEntity.setStatus("0");
                Date date = new Date();
                registEntity.setCreateTime(date);
                count+=registMapper.userAdd(registEntity);

            }
            else{
                System.out.println("cant!");
            }
        return count;
    }
}
