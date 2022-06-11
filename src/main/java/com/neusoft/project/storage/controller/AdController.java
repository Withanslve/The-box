package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.storage.domain.AdEntity;
import com.neusoft.project.storage.service.IAdService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/advertisement")
public class AdController extends BaseController {
    @Resource
    private IAdService adService;

    @Log(title = "广告信息列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "广告信息列表（分页）",notes = "查询广告信息")
    public TableDataInfo list(AdEntity adEntity){
        startPage();
        List<AdEntity> list = adService.selectAdList(adEntity);
        return getDataTable(list);
    }

    @Log(title = "广告新增",businessType = BusinessType.INSERT)
    @PostMapping("/create")
    @ApiOperation(value = "广告新增",notes = "广告新增")
    public AjaxResult AdAdd(@RequestBody AdEntity adEntity){
        return toAjax(adService.AdAdd(adEntity));
    }

    @Log(title = "广告修改",businessType = BusinessType.UPDATE)
    @PutMapping("/update")
    @ApiOperation(value = "广告修改",notes = "广告修改")
    public AjaxResult AdUpdate(@RequestBody AdEntity adEntity){
        return toAjax(adService.AdUpdate(adEntity));
    }

    @Log(title = "广告删除（逻辑删除）",businessType = BusinessType.UPDATE)
    @DeleteMapping("/delete/{ids}")
    @ApiOperation(value = "广告删除",notes = "删除广告列表")
    public AjaxResult adDelete(@PathVariable("ids") long[] ids){
        return toAjax(adService.adDelete(ids));
    }

    @Log(title = "广告启用/停用",businessType = BusinessType.UPDATE)
    @PutMapping("/{operate}/{ids}")
    @ApiOperation(value = "广告启用/停用",notes = "广告启用/停用")
    public AjaxResult remove(@PathVariable("operate") String operate,@PathVariable("ids") long[] ids){
        return toAjax(adService.operateAdByIds(operate,ids));
    }
}
