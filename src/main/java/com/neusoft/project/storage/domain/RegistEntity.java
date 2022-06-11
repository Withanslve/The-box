package com.neusoft.project.storage.domain;

import com.neusoft.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class RegistEntity extends BaseEntity {
    private long userId;
    private long deptId;
    private String userName;
    private String nickName;
    private String userType;
    private String email;
    private String phonenumber;
    private char sex;
    private String avatar;
    private String password;
    private String status;
    //    private char delFlag;
    private String loginIp;
    private Date loginDate;
    //    private String createBy;
//    private String createTime;
//    private String updateBy;
//    private Date updateTime;
    private String remark;
    private long currentPoints;
//    private long version;
//    private long points;
}
