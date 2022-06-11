package com.neusoft.project.storage.domain;

import com.neusoft.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 积分记录表(TPointRecord)实体类
 *
 * @author makejava
 * @since 2021-11-23 12:48:58
 */
@Data
public class PointEntity extends BaseEntity {
    private static final long serialVersionUID = -79902195582350212L;
    /**
     * id
     */
    private Long id;
    /**
     * 手机端用户id
     */
    private Long userId;
    /**
     * 方式（1：注册赠送；2：活动获得；3：积分使用）
     */
    private Integer way;
    /**
     * 积分（积分获得为正数，积分使用未负数）
     */
    private Long points;
    /**
     * 广告id
     */
    private Long advertisementId;
    /**
     * 订单id
     */
    private Long orderId;
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

