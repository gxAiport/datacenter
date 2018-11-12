package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.enums.aodb.ResourceStatusCode;
import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * FileName      Runway.java
 * Description  TODO 跑道的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0    create
 * <p>Why  What is modified:
 */
@Entity
@Table(name = "Runway")
public class Runway extends DefaultEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String RUNWAY_ID = "runwayID";
    public static final String DESCRIPTION = "description";
    public static final String STATUS_CODE = "statusCode";
    public static final String STATUS_START_DATETIME = "statusStartDateTime";
    public static final String STATUS_END_DATETIME = "statusEndDateTime";
    public static final String STATUS_REASON = "statusReason";

    /**
     * 跑道ID
     */
    @Id
    @Column(length = 10)
    private String runwayID;
    /**
     * 描述
     */
    @Column(length = 64)
    private String description;
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


    public String getRunwayID() {
        return runwayID;
    }

    public void setRunwayID(String runwayID) {
        this.runwayID = runwayID;
    }

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

    @Override
    public Object getIdValue() {
        return this.runwayID;
    }


}
