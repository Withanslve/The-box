package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.framework.web.domain.BaseEntity;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.storage.domain.UserEntity;
import com.neusoft.project.storage.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("backend/customer")
//@Api(tags = {""},description = "")
public class CustomerController extends BaseController {
    @Resource
    private IUserService userService;

    @Log(title = "客户列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "客户列表（分页）",notes = "查询客户列表")
    public TableDataInfo list(UserEntity userEntity){
        startPage();
        //查询后台用户列表
        List<UserEntity> list = userService.selectCustomerList(userEntity);
        return getDataTable(list);
    }

    @Log(title = "客户新增",businessType = BusinessType.INSERT)
    @PostMapping("/create")
    @ApiOperation(value = "用户新增",notes = "新增用户列表")
    public AjaxResult CustomerAdd(@RequestBody UserEntity userEntity){
        return toAjax(userService.CustomerAdd(userEntity));
    }

    @Log(title = "客户修改",businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ApiOperation(value = "客户新增",notes = "客户用户列表")
    public AjaxResult CustomerUpdate(@RequestBody UserEntity userEntity){
        return toAjax(userService.CustomerUpdate(userEntity));
    }

    @Log(title = "用户删除（逻辑删除）",businessType = BusinessType.UPDATE)
    @DeleteMapping("/delete/{userIds}")
    @ApiOperation(value = "用户删除",notes = "删除用户列表")
    public AjaxResult customerDelete(@PathVariable("userIds") long[] userIds){
        return toAjax(userService.customerDelete(userIds));
    }

    @Log(title = "修改密码",businessType = BusinessType.UPDATE)
    @PutMapping("/reset/{userIds}")
    @ApiOperation(value = "修改密码",notes = "修改用户密码")
    public AjaxResult customerRsetP(@PathVariable("userIds")Long[] reset) {
        return toAjax(userService.customerRsetP(reset));
    }

    @Log(title = "客户启用/停用",businessType = BusinessType.UPDATE)
    @PutMapping("/{operate}/{userIds}")
    @ApiOperation(value = "客户启用/停用",notes = "客户启用/停用")
    public AjaxResult remove(@PathVariable("operate") String operate,@PathVariable("userIds") long[] userIds){
        return toAjax(userService.operateCustomerByIds(operate,userIds));
    }
}
