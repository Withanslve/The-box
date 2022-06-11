package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.project.storage.domain.RegistEntity;
import com.neusoft.project.storage.domain.UserEntity;
import com.neusoft.project.storage.service.IRegistService;
import com.neusoft.project.storage.service.impl.RegistServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/app")
public class RegistController extends BaseController {
    @Resource
    private IRegistService registService;

    @Log(title = "用户新增",businessType = BusinessType.INSERT)
    @PostMapping("/regist")
    @ApiOperation(value = "注册",notes = "注册用户列表")
    public AjaxResult userAdd(@RequestBody RegistEntity registEntity){
        return toAjax(registService.userAdd(registEntity));
    }
}
