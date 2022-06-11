package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.storage.domain.AdEntity;
import com.neusoft.project.storage.domain.UserEntity;
import com.neusoft.project.storage.service.IAppAdService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("app/advertisement")
public class AppAdController extends BaseController {
    @Resource
    private IAppAdService appAdService;

    @Log(title = "app广告列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "广告列表（分页）",notes = "广告列表")
    public TableDataInfo list(AdEntity adEntity){
//        startPage();
        List<AdEntity> list = appAdService.selectAdList(adEntity);
        return getDataTable(list);
    }

    @Log(title = "app广告积分获取",businessType = BusinessType.UPDATE)
    @PutMapping("/points")
    @ApiOperation(value = "app广告积分获取",notes = "app广告积分获取")
    public AjaxResult pointsUpdate(@RequestBody AdEntity adEntity){
        if(appAdService.pointsUpdate(adEntity)>0){
            return new AjaxResult(200, "积分获取成功");
        }else{
            return new AjaxResult(500, "获取积分失败");
        }
    }

}
