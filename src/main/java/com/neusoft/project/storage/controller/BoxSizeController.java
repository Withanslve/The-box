package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.storage.domain.BoxSizeEntity;
import com.neusoft.project.storage.service.IBoxSizeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("backend/box/standard")
public class BoxSizeController extends BaseController {
    @Resource
    private IBoxSizeService boxSizeService;

    @Log(title = "箱子规格列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "箱子规格列表（分页）",notes = "查询箱子规格列表")
    public TableDataInfo list(BoxSizeEntity boxSizeEntity){
        startPage();
        List<BoxSizeEntity> list = boxSizeService.selectBoxSizeList(boxSizeEntity);
        return getDataTable(list);
    }



    @Log(title = "箱子规格列表删除",businessType = BusinessType.UPDATE)
    @DeleteMapping("/delete/{ids}")
    @ApiOperation(value = "箱子规格列表删除",notes = "箱子规格列表删除")
    public AjaxResult BoxSizeDelete(@PathVariable("ids") long[] ids){
        return toAjax(boxSizeService.BoxSizeDelete(ids));
    }


    @Log(title = "箱子下拉列表",businessType = BusinessType.OTHER)
    @GetMapping("/select")
    @ApiOperation(value = "箱子下拉列表",notes = "箱子下拉列表")
    @ResponseBody
    public AjaxResult BoxSizeSelect(BoxSizeEntity boxSizeEntity){
//        return toAjax(boxSizeService.BoxSizeAdd(boxSizeEntity));
        List<BoxSizeEntity> list=boxSizeService.selectBoxStandardSelectList(boxSizeEntity);
        return AjaxResult.success(list);
    }

}
