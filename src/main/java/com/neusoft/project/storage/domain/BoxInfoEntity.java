package com.neusoft.project.storage.domain;

import com.neusoft.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

//BaseEntity中存在{createTime，createBy，updateBy，updateTime，version，delFlag
// remark，}


@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "箱子信息",description = "箱子信息")

public class BoxInfoEntity extends BaseEntity {
    private long id;
    private long boxCode;
    private String boxStandard;
    private long boxUnitPrice;
    private long usedBy;
    private String isUsed;
    private long sortNo;
    private String usedByName;
    private long MaxBoxCode;
    private long MinBoxCode;
//    private String delFlag;
}
