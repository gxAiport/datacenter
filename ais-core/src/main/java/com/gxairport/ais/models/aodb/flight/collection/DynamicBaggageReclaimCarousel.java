package com.gxairport.ais.models.aodb.flight.collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * TypeName      DynamicFlight.AirportData.BasicBaggageReclaimCarousel
 * Description  继承BasicFlight.AirportData.BasicBaggageReclaimCarousel
 */
@Entity
@Table(name = "Dynamic_BagCarousel")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DynBagCarousel", allocationSize = 1)
public class DynamicBaggageReclaimCarousel extends BasicBaggageReclaimCarousel {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String BAGGAGE_RECLAIM_OPEN_DATETIME = "baggageReclaimOpenDateTime";
    public static final String BAGGAGE_RECLAIM_CLOSE_DATETIME = "baggageReclaimCloseDateTime";
    public static final String FIRST_BAG_DATETIME = "firstBagDateTime";
    public static final String LAST_BAG_DATETIME = "lastBagDateTime";
    public static final String EXIT_DOOR_NUMBER = "exitDoorNumber";

    /**
     * 开启时间
     */
    private Date baggageReclaimOpenDateTime;
    /**
     * 关闭时间
     */
    private Date baggageReclaimCloseDateTime;
    /**
     * 开启时间
     */
    private Date firstBagDateTime;
    /**
     * 关闭时间
     */
    private Date lastBagDateTime;
    /**
     * 出口标识
     */
    @Column(length = 4)
    private String exitDoorNumber;

    public Date getBaggageReclaimOpenDateTime() {
        return baggageReclaimOpenDateTime;
    }

    public void setBaggageReclaimOpenDateTime(Date baggageReclaimOpenDateTime) {
        this.baggageReclaimOpenDateTime = baggageReclaimOpenDateTime;
    }

    public Date getBaggageReclaimCloseDateTime() {
        return baggageReclaimCloseDateTime;
    }

    public void setBaggageReclaimCloseDateTime(Date baggageReclaimCloseDateTime) {
        this.baggageReclaimCloseDateTime = baggageReclaimCloseDateTime;
    }

    public Date getFirstBagDateTime() {
        return firstBagDateTime;
    }

    public void setFirstBagDateTime(Date firstBagDateTime) {
        this.firstBagDateTime = firstBagDateTime;
    }

    public Date getLastBagDateTime() {
        return lastBagDateTime;
    }

    public void setLastBagDateTime(Date lastBagDateTime) {
        this.lastBagDateTime = lastBagDateTime;
    }

    public String getExitDoorNumber() {
        return exitDoorNumber;
    }

    public void setExitDoorNumber(String exitDoorNumber) {
        this.exitDoorNumber = exitDoorNumber;
    }


}
