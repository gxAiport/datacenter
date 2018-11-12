package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.models.IntIdEntity;
import com.gxairport.ais.models.aodb.basic.Airport;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * TypeName      DynamicFlight.BasicLoad.BasicLoad
 * Description  航班载量的实体类
 */

@MappedSuperclass
public abstract class BasicLoad extends IntIdEntity {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String FLIGHT = "flight";
    public static final String DEPARTURE_AIRPORT = "departureAirport";
    public static final String ARRIVAL_AIRPORT = "arrivalAirport";
    public static final String ADULT = "adult";
    public static final String CHD = "chd";
    public static final String INF = "inf";
    public static final String CARGO = "cargo";
    public static final String MAIL = "mail";
    public static final String BAGGAGE = "baggage";

    /**
     * 起始机场
     */
    @ManyToOne
    @JoinColumn(name = "departureAirportIATACode")
    private Airport departureAirport;
    /**
     * 落地机场
     */
    @ManyToOne
    @JoinColumn(name = "arrivalAirportIATACode")
    private Airport arrivalAirport;
    /**
     * 成人
     */
    private Integer adult;
    /**
     * 儿童
     */
    private Integer chd;
    /**
     * 婴儿
     */
    private Integer inf;
    /**
     * 货物
     */
    private Integer cargo;
    /**
     * 邮件
     */
    private Integer mail;
    /**
     * 行李
     */
    private Integer baggage;


    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public Integer getChd() {
        return chd;
    }

    public void setChd(Integer chd) {
        this.chd = chd;
    }

    public Integer getInf() {
        return inf;
    }

    public void setInf(Integer inf) {
        this.inf = inf;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public Integer getMail() {
        return mail;
    }

    public void setMail(Integer mail) {
        this.mail = mail;
    }

    public Integer getBaggage() {
        return baggage;
    }

    public void setBaggage(Integer baggage) {
        this.baggage = baggage;
    }


}
