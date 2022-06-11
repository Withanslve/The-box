package com.neusoft.project.storage.controller;

import com.neusoft.framework.aspectj.lang.annotation.Log;
import com.neusoft.framework.aspectj.lang.enums.BusinessType;
import com.neusoft.framework.web.controller.BaseController;
import com.neusoft.framework.web.domain.AjaxResult;
import com.neusoft.framework.web.page.TableDataInfo;
import com.neusoft.project.common.domain.entity.TCustomerAddress;
import com.neusoft.project.storage.domain.BoxSizeEntity;
import com.neusoft.project.storage.domain.OrdEntity;
import com.neusoft.project.storage.service.IAppAdressService;
import com.neusoft.project.storage.service.IAppBoxSizeService;
import com.neusoft.project.storage.service.IAppOrdService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/box")
public class AppBoxSizeController extends BaseController {
    @Resource
    private IAppBoxSizeService appBoxSizeService;
    @Resource
    private IAppAdressService appAdressService;
    @Resource
    private IAppOrdService appOrdService;


    @Log(title = "地址信息查询（id）",businessType = BusinessType.OTHER)
    @GetMapping("/defaultAddress")
    @ApiOperation(value = "地址信息查询（id）",notes = "查询地址信息")
    public TCustomerAddress select(TCustomerAddress tCustomerAddress){
        return appAdressService.select(tCustomerAddress);
    }

    @Log(title = "有效箱子规格查询",businessType = BusinessType.OTHER)
    @GetMapping("/standard/select")
    @ApiOperation(value = "有效箱子规格查询（分页）",notes = "有效箱子规格查询")
    public TableDataInfo list(BoxSizeEntity boxSizeEntity){
        startPage();
        List<BoxSizeEntity> list = appBoxSizeService.selectNotUsedList(boxSizeEntity);
        return getDataTable(list);
    }

    @Log(title = "预约",businessType = BusinessType.OTHER)
    @PostMapping("/order")
    @ApiOperation(value = "预约",notes = "预约")
    public AjaxResult orderAdd(@RequestBody OrdEntity ordEntity){
        return toAjax(appOrdService.orderAdd(ordEntity));
    }
}
