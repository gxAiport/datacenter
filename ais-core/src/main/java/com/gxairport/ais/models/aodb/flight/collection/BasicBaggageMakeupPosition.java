package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.BaggageMakeupPositionRole;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * TypeName      BasicFlight.AirportData.BasicBaggageMakeupPosition
 * Description  行李装载转盘实体类的基类
 */
@MappedSuperclass
public abstract class BasicBaggageMakeupPosition extends IntIdEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String BAGGAGE_MAKEUP_POSITION_ID = "baggageMakeupPositionID";
    public static final String BAGGAGE_MAKEUP_POSITION_ROLE = "baggageMakeupPositionRole";

    /**
     * 行李装载转盘编号
     */
    @Column(length = 4)
    private String baggageMakeupPositionID;
    /**
     * 行李转载转盘规则
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private BaggageMakeupPositionRole baggageMakeupPositionRole;

    public String getBaggageMakeupPositionID() {
        return baggageMakeupPositionID;
    }

    public void setBaggageMakeupPositionID(String baggageMakeupPositionID) {
        this.baggageMakeupPositionID = baggageMakeupPositionID;
    }

    public BaggageMakeupPositionRole getBaggageMakeupPositionRole() {
        return baggageMakeupPositionRole;
    }

    public void setBaggageMakeupPositionRole(BaggageMakeupPositionRole baggageMakeupPositionRole) {
        this.baggageMakeupPositionRole = baggageMakeupPositionRole;
    }


}
