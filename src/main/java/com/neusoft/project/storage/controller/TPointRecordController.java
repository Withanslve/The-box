package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.storage.domain.PointEntity;
import com.neusoft.project.storage.service.ITPointRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/point/")
public class TPointRecordController extends BaseController {
    @Resource
    private ITPointRecordService itPointRecordService;

    @Log(title = "积分列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "积分列表（分页）",notes = "查询积分列表")
    public TableDataInfo list(PointEntity pointRecordEntity){
        startPage();
        List<PointEntity> list = itPointRecordService.selectPointsList(pointRecordEntity);
        return getDataTable(list);
    }

    @Log(title = "积分列表（id）",businessType = BusinessType.OTHER)
    @GetMapping("/select")
    @ApiOperation(value = "积分列表（分页）",notes = "查询积分列表")
    public PointEntity select(PointEntity pointRecordEntity){
        return itPointRecordService.select(pointRecordEntity);
    }


}
