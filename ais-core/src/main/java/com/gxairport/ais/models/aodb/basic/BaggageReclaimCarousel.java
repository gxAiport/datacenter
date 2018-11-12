package com.gxairport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      BasicBaggageReclaimCarousel.java
 * Description  TODO 行李转盘的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

@Entity
@Table(name = "BasicBaggageReclaimCarousel")
public class BaggageReclaimCarousel extends FlightResource {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String BAGGAGE_RECLAIM_CAROUSEL_ID = "BaggageReclaimCarouselID";
    public static final String CAPACITY = "capacity";
    public static final String EXIT_DOOR = "exitDoor";

    /**
     * 行李转盘ID
     */
    @Id
    @Column(length = 15)
    private String BaggageReclaimCarouselID;

    /**
     * 装载能力
     */
    private Integer capacity;
    /**
     * 出口编号
     */
    private Integer exitDoor;

    public String getBaggageReclaimCarouselID() {
        return BaggageReclaimCarouselID;
    }

    public void setBaggageReclaimCarouselID(String baggageReclaimCarouselID) {
        BaggageReclaimCarouselID = baggageReclaimCarouselID;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getExitDoor() {
        return exitDoor;
    }

    public void setExitDoor(Integer exitDoor) {
        this.exitDoor = exitDoor;
    }

    @Override
    public Object getIdValue() {
        return this.BaggageReclaimCarouselID;
    }


}
