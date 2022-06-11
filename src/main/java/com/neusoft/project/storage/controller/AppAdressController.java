package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.common.domain.entity.TCustomerAddress;
import com.neusoft.project.storage.domain.AdEntity;
import com.neusoft.project.storage.domain.AddressEntity;
import com.neusoft.project.storage.domain.BoxSizeEntity;
import com.neusoft.project.storage.domain.UserEntity;
import com.neusoft.project.storage.service.IAppAdressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/adress")
public class AppAdressController extends BaseController {
    @Resource
    private IAppAdressService appAdressService;

    @Log(title = "地址信息列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "地址信息列表（分页）",notes = "查询地址信息")
    public TableDataInfo list(AddressEntity addressEntity){
        startPage();
        List<AddressEntity> list = appAdressService.selectAddressList(addressEntity);
        return getDataTable(list);
    }

    @Log(title = "地址信息新增",businessType = BusinessType.INSERT)
    @PostMapping("/create")
    @ApiOperation(value = "地址新增",notes = "地址新增")
    public AjaxResult CustomerAdd(@RequestBody AddressEntity addressEntity){
        return toAjax(appAdressService.appAdress(addressEntity));
    }

    @Log(title = "客户修改",businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ApiOperation(value = "客户新增",notes = "客户用户列表")
    public AjaxResult CustomerUpdate(@RequestBody AddressEntity addressEntity){
        return toAjax(appAdressService.updateAdress(addressEntity));
    }

    @Log(title = "订单信息删除",businessType = BusinessType.UPDATE)
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "订单信息删除",notes = "订单信息删除")
    public AjaxResult addressDelete(@PathVariable("id") long id){
        return toAjax(appAdressService.addressDelete(id));
    }

    @Log(title = "设置默认地址",businessType = BusinessType.UPDATE)
    @PutMapping("/default/{id}")
    @ApiOperation(value = "默认地址",notes = "默认地址")
    public AjaxResult defaultAddress(@PathVariable("id") long id){
        return toAjax(appAdressService.defaultAddress(id));
    }
}
