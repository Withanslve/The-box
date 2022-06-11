package com.neusoft.project.storage.domain;

import com.neusoft.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

//BaseEntity中存在{createTime，createBy，updateBy，updateTime，version，delFlag
// remark，}

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "广告信息",description = "广告信息")
public class AdEntity extends BaseEntity {
    private Long id;
    private String title;
    private String content;
    private String imgUrl;
    private long points;
    private String isEnable;
    private Long sortNo;

    //app
    private Long advertisementId;
}
