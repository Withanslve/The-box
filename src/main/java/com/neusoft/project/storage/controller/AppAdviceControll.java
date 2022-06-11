package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.project.storage.domain.AdviceEntity;
import com.neusoft.project.storage.service.IAppAdviceService;
import com.neusoft.project.storage.service.impl.AppAdviceServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/app/personal")
public class AppAdviceControll extends BaseController {
    @Resource
    private IAppAdviceService appAdviceService;

    @Log(title = "广告新增",businessType = BusinessType.INSERT)
    @PostMapping("/advice")
    @ApiOperation(value = "广告新增",notes = "广告新增")
    public AjaxResult AdviceAdd(@RequestBody AdviceEntity adviceEntity){
        if (appAdviceService.AdviceAdd(adviceEntity)>0) {
            return new AjaxResult(200,"新增成功");
        }else {
            return new AjaxResult(500,"新增失败");
        }
    }
}
