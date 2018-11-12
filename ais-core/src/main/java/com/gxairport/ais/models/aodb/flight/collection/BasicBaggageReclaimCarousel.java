package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.BaggageReclaimCarouselRole;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * TypeName      BasicFlight.AirportData.BasicBaggageReclaimCarousel
 * Description  行李认领转盘实体类的基类
 */
@MappedSuperclass
public abstract class BasicBaggageReclaimCarousel extends IntIdEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String BAGGAGE_RECLAIM_CAROUSEL_ID = "baggageReclaimCarouselID";
    public static final String BAGGAGE_RECLAIM_CAROUSEL_ROLE = "baggageReclaimCarouselRole";
    /**
     * 行李认领转盘编号
     */
    @Column(length = 4)
    private String baggageReclaimCarouselID;
    /**
     * 行李认领转盘规则
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private BaggageReclaimCarouselRole baggageReclaimCarouselRole;

    public String getBaggageReclaimCarouselID() {
        return baggageReclaimCarouselID;
    }

    public void setBaggageReclaimCarouselID(String baggageReclaimCarouselID) {
        this.baggageReclaimCarouselID = baggageReclaimCarouselID;
    }

    public BaggageReclaimCarouselRole getBaggageReclaimCarouselRole() {
        return baggageReclaimCarouselRole;
    }

    public void setBaggageReclaimCarouselRole(BaggageReclaimCarouselRole baggageReclaimCarouselRole) {
        this.baggageReclaimCarouselRole = baggageReclaimCarouselRole;
    }
}
