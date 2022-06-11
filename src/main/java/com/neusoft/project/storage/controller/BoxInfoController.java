package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.storage.domain.BoxInfoEntity;
import com.neusoft.project.storage.service.IBoxInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("backend/box/info")
public class BoxInfoController extends BaseController {
    @Resource
    private IBoxInfoService boxInfoService;

    @Log(title = "箱子信息列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "用户列表（分页）",notes = "查询用户列表")
    public TableDataInfo list(BoxInfoEntity boxInfoEntity){
        startPage();
        List<BoxInfoEntity> list = boxInfoService.selectBoxList(boxInfoEntity);
        return getDataTable(list);
    }

    @Log(title = "箱子信息新增",businessType = BusinessType.INSERT)
    @PostMapping("/create")
    @ApiOperation(value = "箱子信息新增",notes = "箱子信息新增")
    public AjaxResult BoxInfoAdd(@RequestBody BoxInfoEntity boxInfoEntity){
        return toAjax(boxInfoService.BoxInfoAdd(boxInfoEntity));
    }

    @Log(title = "箱子规格列表删除",businessType = BusinessType.UPDATE)
    @DeleteMapping("/delete/{ids}")
    @ApiOperation(value = "箱子规格列表删除",notes = "箱子规格列表删除")
    public AjaxResult BoxInfoDelete(@PathVariable("ids") long[] ids){
        return toAjax(boxInfoService.BoxInfoDelete(ids));
    }

}
