package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.storage.domain.AdviceEntity;
import com.neusoft.project.storage.service.IAdviceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/backend/advice")
public class AdviceController extends BaseController {
    @Resource
    private IAdviceService adviceService;

    @Log(title = "意见信息列表（分页）",businessType = BusinessType.OTHER)
    @GetMapping("/list")
    @ApiOperation(value = "意见信息列表（分页）",notes = "查询意见信息列表")
    public TableDataInfo list(AdviceEntity adviceEntity){
        startPage();
        List<AdviceEntity> list = adviceService.selectAdviceList(adviceEntity);
        return getDataTable(list);
    }
}
