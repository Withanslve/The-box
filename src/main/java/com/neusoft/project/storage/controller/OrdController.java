package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.storage.domain.OrdEntity;
import com.neusoft.project.storage.service.IOrdService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/backend/order")
public class OrdController extends BaseController {
    @Resource
    private IOrdService ordService;

    @Log(title = "订单信息列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "订单信息列表（分页）",notes = "订单信息列表")
    public TableDataInfo list(OrdEntity ordEntity){
        startPage();
        List<OrdEntity> list = ordService.selectOrderList(ordEntity);
        return getDataTable(list);
    }

    @Log(title = "订单信息列表",businessType = BusinessType.OTHER)
    @GetMapping("/info/{id}")
    @ApiOperation(value = "订单信息列表",notes = "订单信息列表")
    public OrdEntity selectList(@PathVariable("id") long id){
        return ordService.selectList(id);
    }

    @Log(title = "订单信息删除（逻辑删除）",businessType = BusinessType.UPDATE)
    @DeleteMapping("/delete/{ids}")
    @ApiOperation(value = "订单信息删除",notes = "订单信息删除")
    public AjaxResult adDelete(@PathVariable("ids") long[] ids){
        return toAjax(ordService.ordDelete(ids));
    }

//    @Log(title = "订单信息操作",businessType = BusinessType.UPDATE)
//    @PutMapping("/operate/{id}/{operate}")
//    @ApiOperation(value = "订单信息操作",notes = "订单信息操作")
//    public AjaxResult remove(@PathVariable("id") Long id,@PathVariable("operate") int operate){
//        return toAjax(ordService.operateOrdByIds(id,operate));
//    }


}
