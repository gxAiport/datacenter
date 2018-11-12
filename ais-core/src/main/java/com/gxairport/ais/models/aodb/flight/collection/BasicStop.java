package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.models.IntIdEntity;
import com.gxairport.ais.models.aodb.basic.Airport;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * TypeName      BasicFlight.RouteData.BasicStop
 * Description  航班经停点的实体类基类
 */
@MappedSuperclass
public abstract class BasicStop extends IntIdEntity {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String STOP_AIRPORT = "stopAirport";
    public static final String SCHEDULED_LAND_TIME = "scheduledLandTime";
    public static final String SCHEDULED_AIRBORNE_TIME = "scheduledAirborneTime";
    public static final String ORDER_CODE = "orderCode";
    /**
     * 经停航班
     */
    @ManyToOne
    @JoinColumn(name = "stopAirportIATACode")
    private Airport stopAirport;
    /**
     * 计划落地的时间
     */
    @Column(length = 6)
    private String scheduledLandTime;
    /**
     * 计划起飞的时间
     */
    @Column(length = 6)
    private String scheduledAirborneTime;
    /**
     * 序号
     */
    private Integer orderCode;


    public Airport getStopAirport() {
        return stopAirport;
    }

    public void setStopAirport(Airport stopAirport) {
        this.stopAirport = stopAirport;
    }

    public String getScheduledLandTime() {
        return scheduledLandTime;
    }

    public void setScheduledLandTime(String scheduledLandTime) {
        this.scheduledLandTime = scheduledLandTime;
    }

    public String getScheduledAirborneTime() {
        return scheduledAirborneTime;
    }

    public void setScheduledAirborneTime(String scheduledAirborneTime) {
        this.scheduledAirborneTime = scheduledAirborneTime;
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }
}
