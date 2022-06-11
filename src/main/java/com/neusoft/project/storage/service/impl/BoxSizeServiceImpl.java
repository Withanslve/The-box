package com.neusoft.project.storage.service.impl;

import com.neusoft.common.utils.SecurityUtils;
import com.neusoft.project.storage.domain.BoxInfoEntity;
import com.neusoft.project.storage.domain.BoxSizeEntity;
import com.neusoft.project.storage.mapper.BoxInfoMapper;
import com.neusoft.project.storage.mapper.BoxSizeMapper;
import com.neusoft.project.storage.service.IBoxSizeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BoxSizeServiceImpl implements IBoxSizeService {
    @Resource
    private BoxSizeMapper boxSizeMapper;
    @Resource
    private BoxInfoMapper boxInfoMapper;

    @Override
    public List<BoxSizeEntity> selectBoxSizeList(BoxSizeEntity boxSizeEntity) {
        return boxSizeMapper.selectBoxSizeList(boxSizeEntity);
    }

    //新增接口
    @Override
    public int BoxSizeAdd(BoxSizeEntity boxSizeEntity) {
        List<BoxSizeEntity> a = boxSizeMapper.selectbyc(boxSizeEntity.getBoxStandard());

        if (a.isEmpty()){
            Date date = new Date();
            boxSizeEntity.setCreateBy(SecurityUtils.getUsername());
            boxSizeEntity.setCreateTime(date);
            boxSizeEntity.setDelFlag("0");
            boxSizeEntity.setVersion(2L);
//            如果不存在大类则直接在信息内生成对应数量的小类
            for (int i=0;i< boxSizeEntity.getInventoryNumber();i++){
                BoxInfoEntity boxInfo =new BoxInfoEntity();
                //判断并加入code

                SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sc=new SimpleDateFormat("yyyyMMdd");
                List<BoxInfoEntity> list = boxInfoMapper.select(sm.format(date));
                System.out.println(list);
                if(list.size()>0){
                    BoxInfoEntity max=boxInfoMapper.selectDateMax(sm.format(date));
                    boxInfo.setBoxCode(max.getMaxBoxCode()+1);

                }else{
                    boxInfo.setBoxCode(Long.valueOf(sc.format(date)+"000001"));
                }

                boxInfo.setBoxStandard(boxSizeEntity.getBoxStandard());
                boxInfo.setBoxUnitPrice(boxSizeEntity.getBoxUnitPrice());
                boxInfo.setCreateBy(SecurityUtils.getUsername());

                Date dates=new Date();
                boxInfo.setCreateTime(dates);
                boxInfo.setDelFlag("0");
                boxInfo.setVersion(2L);
                boxInfo.setIsUsed("0");
                boxInfo.setDelFlag("0");
                boxInfo.setRemark("随大类自动生成");
                boxInfoMapper.BoxInfoAdd(boxInfo);
            }

            return boxSizeMapper.BoxSizeAdd(boxSizeEntity);

        }
        else{
            BoxSizeEntity record=boxSizeMapper.selectByPrice(boxSizeEntity.getBoxStandard());
            if (record.getBoxUnitPrice().equals(boxSizeEntity.getBoxUnitPrice())){
                Date date = new Date();

//            如果不存在大类则直接在信息内生成对应数量的小类
                for (int i=0;i< boxSizeEntity.getInventoryNumber();i++){
                    BoxInfoEntity boxInfo =new BoxInfoEntity();
                    //判断并加入code

                    SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat sc=new SimpleDateFormat("yyyyMMdd");
                    List<BoxInfoEntity> list = boxInfoMapper.select(sm.format(date));
                    System.out.println(list);
                    if(list.size()>0){
                        BoxInfoEntity max=boxInfoMapper.selectDateMax(sm.format(date));
                        boxInfo.setBoxCode(max.getMaxBoxCode()+1);

                    }else{
                        boxInfo.setBoxCode(Long.valueOf(sc.format(date)+"000001"));
                    }

                    boxInfo.setBoxStandard(boxSizeEntity.getBoxStandard());
                    boxInfo.setBoxUnitPrice(boxSizeEntity.getBoxUnitPrice());
                    boxInfo.setCreateBy(SecurityUtils.getUsername());

                    Date dates=new Date();
                    boxInfo.setCreateTime(dates);
                    boxInfo.setDelFlag("0");
                    boxInfo.setVersion(2L);
                    boxInfo.setIsUsed("0");
                    boxInfo.setDelFlag("0");
                    boxInfo.setRemark("随大类自动生成");
                    boxInfoMapper.BoxInfoAdd(boxInfo);
                }

                return 1;
            }
            else{
                System.out.println("not");
            }
            return 0;
        }
    }

    //删除接口
    @Override
    public int BoxSizeDelete(long[] ids) {
        for (long b:ids) {
            BoxInfoEntity a=new BoxInfoEntity();
            a.setId(b);
            BoxSizeEntity c=boxSizeMapper.selectByid(b);
//            System.out.println(c);
            List<BoxInfoEntity> boxInfo = boxInfoMapper.selectByBoxStandard(c.getBoxStandard());
//            System.out.println(boxInfo);
            if(boxInfo.isEmpty()){
                 boxSizeMapper.BoxSizeDelete(b);
            }else{
                System.out.println(boxInfo.get(0).getBoxStandard()+"存在小类数据，无法删除");
            }

        }
        return 1;
    }

    @Override
    public List<BoxSizeEntity> selectBoxStandardSelectList(BoxSizeEntity boxSizeEntity) {
        return boxSizeMapper.selectBoxStandardSelectList(boxSizeEntity);
    }


}