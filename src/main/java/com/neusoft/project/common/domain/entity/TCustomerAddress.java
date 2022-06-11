package com.neusoft.project.common.domain.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 客户地址表(TCustomerAddress)实体类
 *
 * @author makejava
 * @since 2021-11-23 14:27:26
 */
public class TCustomerAddress implements Serializable {
    private static final long serialVersionUID = -20512138404086613L;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Long getSortNo() {
        return sortNo;
    }

    public void setSortNo(Long sortNo) {
        this.sortNo = sortNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}

