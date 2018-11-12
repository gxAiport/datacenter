package com.gxairport.ais.models.aodb.flight;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * TypeName      DynamicFlight.FlightData.BasicLinkedFlight
 * Description  继承 BasicFlight.FlightData.BasicLinkedFlight
 * 增加字段:
 */

@Embeddable
public class LinkedFlight extends BasicLinkedFlight {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String LINKED_SCHEDULED_DATETIME = "linkedScheduledDateTime";


    /**
     * 连接航班日期
     */
    private Date linkedScheduledDateTime;

    public Date getLinkedScheduledDateTime() {
        return linkedScheduledDateTime;
    }

    public void setLinkedScheduledDateTime(Date linkedScheduledDateTime) {
        this.linkedScheduledDateTime = linkedScheduledDateTime;
    }

}
