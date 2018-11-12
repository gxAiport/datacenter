package com.gxairport.ais.models.aodb.flight.collection;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * TypeName      DynamicFlight.AirportData.BasicBaggageMakeupPosition
 * Description  继承BasicFlight.AirportData.BasicBaggageMakeupPosition
 */
@Entity
@Table(name = "Dynamic_BagMakeupPosition")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DynBagMakeupPos", allocationSize = 1)
public class DynamicBaggageMakeupPosition extends BasicBaggageMakeupPosition {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String BAGGAGE_MAKEUP_OPEN_DATETIME = "baggageMakeupOpenDateTime";
    public static final String BAGGAGE_MAKEUP_CLOSE_DATETIME = "baggageMakeupCloseDateTime";
    /**
     * 开启时间
     */
    private Date baggageMakeupOpenDateTime;
    /**
     * 关闭时间
     */
    private Date baggageMakeupCloseDateTime;

    public Date getBaggageMakeupOpenDateTime() {
        return baggageMakeupOpenDateTime;
    }

    public void setBaggageMakeupOpenDateTime(Date baggageMakeupOpenDateTime) {
        this.baggageMakeupOpenDateTime = baggageMakeupOpenDateTime;
    }

    public Date getBaggageMakeupCloseDateTime() {
        return baggageMakeupCloseDateTime;
    }

    public void setBaggageMakeupCloseDateTime(Date baggageMakeupCloseDateTime) {
        this.baggageMakeupCloseDateTime = baggageMakeupCloseDateTime;
    }


}
