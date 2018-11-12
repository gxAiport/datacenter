package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.GateBoardingStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * TypeName      DynamicFlight.AirportData.DynamicCheckIn
 * Description  继承BasicFlight.AirportData.DynamicCheckIn
 */
@Entity
@Table(name = "Dynamic_Gate")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DynGate", allocationSize = 1)
public class DynamicGate extends BasicGate {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String GATE_OPEN_DATETIME = "gateOpenDateTime";
    public static final String GATE_CLOSE_DATETIME = "gateCloseDateTime";
    public static final String GATE_BOARDING_STATUS = "gateBoardingStatus";

    /**
     * 登机开放的时间
     */
    private Date gateOpenDateTime;
    /**
     * 登机结束的时间
     */
    private Date gateCloseDateTime;
    /**
     * 登机状态
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private GateBoardingStatus gateBoardingStatus;

    public Date getGateOpenDateTime() {
        return gateOpenDateTime;
    }

    public void setGateOpenDateTime(Date gateOpenDateTime) {
        this.gateOpenDateTime = gateOpenDateTime;
    }

    public Date getGateCloseDateTime() {
        return gateCloseDateTime;
    }

    public void setGateCloseDateTime(Date gateCloseDateTime) {
        this.gateCloseDateTime = gateCloseDateTime;
    }

    public GateBoardingStatus getGateBoardingStatus() {
        return gateBoardingStatus;
    }

    public void setGateBoardingStatus(GateBoardingStatus gateBoardingStatus) {
        this.gateBoardingStatus = gateBoardingStatus;
    }


}
