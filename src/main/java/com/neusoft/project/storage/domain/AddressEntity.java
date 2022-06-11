package com.neusoft.project.storage.domain;

import com.neusoft.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 客户地址表(TCustomerAddress)实体类
 *
 * @author makejava
 * @since 2021-11-23 14:27:59
 */

@Data
public class AddressEntity extends BaseEntity {
    private static final long serialVersionUID = -72409422858606114L;
    /**
     * id
     */
    private Long id;
    /**
     * 手机端用户id
     */
    private Long userId;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 联系人电话
     */
    private String contactsPhone;
    /**
     * 省编号
     */
    private String province;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市编号
     */
    private String city;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区编号
     */
    private String area;
    /**
     * 区名称
     */
    private String areaName;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 是否是默认地址（0：是；1：否）
     */
    private Integer isDefault;
    /**
     * 序号
     */
    private Long sortNo;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 版本号
     */
    private Long version;
    /**
     * 删除标记（0：未删除；2：已删除）
     */
    private String delFlag;



}

