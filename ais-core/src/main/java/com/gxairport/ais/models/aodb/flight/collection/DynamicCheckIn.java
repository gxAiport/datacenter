package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.models.aodb.flight.collection.BasicCheckIn;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * TypeName      DynamicFlight.AirportData.DynamicCheckIn
 * Description  继承BasicFlight.AirportData.DynamicCheckIn
 */

@Entity
@Table(name = "Dynamic_CheckIn")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DynCheckIn", allocationSize = 1)
public class DynamicCheckIn extends BasicCheckIn {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CHECKIN_OPEN_DATETIME = "checkInOpenDateTime";
    public static final String CHECKIN_CLOSE_DATETIME = "checkInCloseDateTime";

    /**
     * 值机开始时间
     */
    private Date checkInOpenDateTime;
    /**
     * 值机结束时间
     */
    private Date checkInCloseDateTime;

    public Date getCheckInOpenDateTime() {
        return checkInOpenDateTime;
    }

    public void setCheckInOpenDateTime(Date checkInOpenDateTime) {
        this.checkInOpenDateTime = checkInOpenDateTime;
    }

    public Date getCheckInCloseDateTime() {
        return checkInCloseDateTime;
    }

    public void setCheckInCloseDateTime(Date checkInCloseDateTime) {
        this.checkInCloseDateTime = checkInCloseDateTime;
    }


}
