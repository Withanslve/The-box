package com.neusoft.project.storage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neusoft.common.exception.CustomException;
import com.neusoft.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class OrdEntity extends BaseEntity {
    private Long id;
    private Long userId;
    private String nickName;
    private Integer status;
    private Long orderCode;
    private String OrderName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date emptyBoxOrderTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date heavyBoxOrderTime;
    private String emptyBoxCallName;
    private String emptyBoxCallPhone;
    private String emptyBoxCallAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date emptyBoxCallTime;
    private String emptyBoxCallInterval;
    private String heavyBoxCallName;
    private String heavyBoxCallPhone;
    private String heavyBoxCallAddress;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date heavyBoxCallTime;
    private String heavyBoxCallInterval;
    private Long boxId;
    private Long boxCode;
    private String boxStandard;
    private Long boxUnitPrice;
    private Integer leaseDuration;
    private Long totalPrice;
    private Long sortNo;
    private Integer appDelFlag;
    private Integer backendDelFlag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String emptyBoxOrderTimerStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String heavyBoxOrderTimerStart;

    private Long boxStandardId;
    private Long MaxOrderCode;
}
