package com.gxairport.ais.models.aodb.flight;

import com.gxairport.ais.enums.aodb.FlightDirection;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * TypeName      BasicFlight.BasicLinkedFlight
 * Description  连接航班的静态基类
 */
@MappedSuperclass
public abstract class BasicLinkedFlight implements Serializable {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String LINKEDFLIGHTNUMBER = "linkedFlightNumber";
    public static final String LINKEDFLIGHTDIRECTION = "linkedFlightDirection";


    /**
     * 连接航班号
     */
    @Column(length = 15)
    private String linkedFlightNumber;
    /**
     * 进出港标识
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private FlightDirection linkedFlightDirection;

    public String getLinkedFlightNumber() {
        return linkedFlightNumber;
    }

    public void setLinkedFlightNumber(String linkedFlightNumber) {
        this.linkedFlightNumber = linkedFlightNumber;
    }

    public FlightDirection getLinkedFlightDirection() {
        return linkedFlightDirection;
    }

    public void setLinkedFlightDirection(FlightDirection linkedFlightDirection) {
        this.linkedFlightDirection = linkedFlightDirection;
    }


}
