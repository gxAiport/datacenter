package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.models.IntIdEntity;
import com.gxairport.ais.models.aodb.basic.Airline;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * TypeName      BasicFlight.FlightData.BasicShareFlight
 * Description  共享航班实体类的基类
 */
@MappedSuperclass
public abstract class BasicShareFlight extends IntIdEntity {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String SHARE_FLIGHT_NUMBER = "shareFlightNumber";
    public static final String SHARE_AIRLINE = "shareAirline";

    /**
     * 共享航班号
     */
    @Column(length = 8)
    private String shareFlightNumber;
    /**
     * 共享航空公司
     */
    @ManyToOne
    @JoinColumn(name = "shareAirlineICAOCode")
    private Airline shareAirline;

    public String getShareFlightNumber() {
        return shareFlightNumber;
    }

    public void setShareFlightNumber(String shareFlightNumber) {
        this.shareFlightNumber = shareFlightNumber;
    }

    public Airline getShareAirline() {
        return shareAirline;
    }

    public void setShareAirline(Airline shareAirline) {
        this.shareAirline = shareAirline;
    }

}
