package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.CheckInRole;
import com.gxairport.ais.enums.aodb.CheckInTypeCode;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * TypeName      BasicFlight.AirportData.BasicCheckIn
 * Description  值机实体类的基类
 */
@MappedSuperclass
public abstract class BasicCheckIn extends IntIdEntity {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CHECKIN_DESK_RANGE = "checkInDeskRange";
    public static final String CHECKIN_ROLE = "checkInRole";
    public static final String CHECKIN_TYPE_CODE = "checkInTypeCode";

    /**
     * 值机柜台编号范围，例如15-17
     */
    @Column(length = 100)
    private String checkInDeskRange;
    /**
     * 值机规则
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private CheckInRole checkInRole;
    /**
     * 值机类型代码
     */
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private CheckInTypeCode checkInTypeCode;

    public String getCheckInDeskRange() {
        return checkInDeskRange;
    }

    public void setCheckInDeskRange(String checkinDeskRange) {
        this.checkInDeskRange = checkinDeskRange;
    }

    public CheckInRole getCheckInRole() {
        return checkInRole;
    }

    public void setCheckInRole(CheckInRole checkinRole) {
        this.checkInRole = checkinRole;
    }

    public CheckInTypeCode getCheckInTypeCode() {
        return checkInTypeCode;
    }

    public void setCheckInTypeCode(CheckInTypeCode checkinTypeCode) {
        this.checkInTypeCode = checkinTypeCode;
    }


}
