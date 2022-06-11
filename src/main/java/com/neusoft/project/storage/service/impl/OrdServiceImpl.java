package com.neusoft.project.storage.service.impl;

import com.neusoft.project.storage.domain.OrdEntity;
import com.neusoft.project.storage.mapper.OrdMapper;
import com.neusoft.project.storage.mapper.UserMapper;
import com.neusoft.project.storage.service.IOrdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class OrdServiceImpl implements IOrdService {
    @Resource
    private OrdMapper ordMapper;
    private UserMapper userMapper;

    @Override
    public List<OrdEntity> selectOrderList(OrdEntity ordEntity) {
        return ordMapper.selectOrderList(ordEntity);
    }

    @Override
    public OrdEntity selectList(long id) {
        return ordMapper.selectList(id);
    }


    @Override
    public int ordDelete(long[] ids) {
        int count=0;
        for (Long a:ids
        ) {
            count+= ordMapper.ordDelete(a);
        }
        return count;
    }

//    @Override
//    public int operateOrdByIds(Long id, int operate) {
//        OrdEntity ordEntity=new OrdEntity();
//        ordEntity.setId(id);
//        ordEntity.setStatus(operate);
//        return ordMapper.operateOrdByIds(ordEntity);
//    }
}
