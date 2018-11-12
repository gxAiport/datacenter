package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.enums.aodb.ResourceStatusCode;
import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.Date;


/**
 * FileName      FlightResource.java
 * Description  TODO 航班资源的基类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月14日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月14日      ZhangYu    1.0    create
 * Why  What is modified:
 */

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class FlightResource extends DefaultEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String DESCRIPTION = "description";
    public static final String STATUS_CODE = "statusCode";
    public static final String STATUS_START_DATETIME = "statusStartDateTime";
    public static final String STATUS_END_DATETIME = "statusEndDateTime";
    public static final String STATUS_REASON = "statusReason";

    /*
     * 描述
     */
    @Column(length = 128)
    protected String description;
    /**
     * 状态
     */
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private ResourceStatusCode statusCode;
    /**
     * 状态开始时间
     */
    private Date statusStartDateTime;
    /**
     * 状态结束时间
     */
    private Date statusEndDateTime;
    /**
     * 状态理由
     */
    private String statusReason;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ResourceStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(ResourceStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public Date getStatusStartDateTime() {
        return statusStartDateTime;
    }

    public void setStatusStartDateTime(Date statusStartDateTime) {
        this.statusStartDateTime = statusStartDateTime;
    }

    public Date getStatusEndDateTime() {
        return statusEndDateTime;
    }

    public void setStatusEndDateTime(Date statusEndDateTime) {
        this.statusEndDateTime = statusEndDateTime;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }


}