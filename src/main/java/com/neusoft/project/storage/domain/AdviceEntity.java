package com.neusoft.project.storage.domain;

import com.neusoft.framework.web.domain.BaseEntity;
import lombok.Data;

//BaseEntity中存在{createTime，createBy，updateBy，updateTime，version，delFlag
// remark，}

@Data
public class AdviceEntity extends BaseEntity {
    private long id;
    private long userId;
    private String title;
    private String content;
    private long sortNo;
    private String nickName;
}
