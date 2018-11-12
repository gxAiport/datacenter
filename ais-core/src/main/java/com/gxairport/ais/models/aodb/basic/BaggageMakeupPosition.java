package com.gxairport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      BasicBaggageMakeupPosition.java
 * Description  TODO 行李装载转盘的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月13日      ZhangYu    1.0    create
 * Why  What is modified:
 */
@Entity
@Table(name = "BasicBaggageMakeupPosition")
public class BaggageMakeupPosition extends FlightResource {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String BAGGAGE_MAKEUP_POSITION_ID = "baggageMakeupPositionID";
    public static final String CAPACITY = "capacity";

    @Id
    @Column(length = 15)
    private String baggageMakeupPositionID;

    /**
     * 装载能力
     */
    private Integer capacity;

    public String getBaggageMakeupPositionID() {
        return baggageMakeupPositionID;
    }

    public void setBaggageMakeupPositionID(String baggageMakeupPositionID) {
        this.baggageMakeupPositionID = baggageMakeupPositionID;
    }


    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public Object getIdValue() {
        // TODO Auto-generated method stub
        return this.baggageMakeupPositionID;
    }


}
