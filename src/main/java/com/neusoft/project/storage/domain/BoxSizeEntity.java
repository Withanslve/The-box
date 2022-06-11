package com.neusoft.project.storage.domain;

import com.neusoft.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

//BaseEntity中存在{createBy，updateBy，updateTime，version，delFlag
// remark,createTime}

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "箱子规格",description = "箱子规格")
public class BoxSizeEntity extends BaseEntity {
    private Long id;
    private String boxStandard;
    private Long boxUnitPrice;
    private Long sortNo;
    private Long totalNumber;
    private Long usedNumber;
    private Long inventoryNumber;
    private String useRatio;

    private String isUsed;

}
