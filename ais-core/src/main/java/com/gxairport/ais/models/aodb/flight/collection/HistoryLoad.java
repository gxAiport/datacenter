package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.SectorCode;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TypeName Flight.HistoryLoad.LoadFlight
 * Description 航班载量的实体类
 */
@Entity
@Table(name = "History_Load")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_HisLoad", allocationSize = 1)
public class HistoryLoad extends IntIdEntity {

    public static final String DEPARTURE_AIRPORT_IATA_CODE = "departureAirportIATACode";
    public static final String ARRIVAL_AIRPORT_IATA_CODE = "arrivalAirportIATACode";
    public static final String PASSENGER_TON_KILOMETERS = "passengerTonKilometers";
    public static final String CARGO_TON_KILOMETERS = "cargoTonKilometers";
    public static final String MAIL_TON_KILOMETERS = "mailTonKilometers";
    public static final String AIR_ROUTE_DISTANCE = "airRouteDistance";
    public static final String ADULT = "adult";
    public static final String CHD = "chd";
    public static final String INF = "inf";
    public static final String CARGO = "cargo";
    public static final String MAIL = "mail";
    public static final String BAGGAGE = "baggage";
    public static final String SECTOR_CODE = "sectorCode";

    /**
     * 起始机场
     */
    @Column(length = 10)
    private String departureAirportIATACode;
    /**
     * 落地机场
     */
    @Column(length = 10)
    private String arrivalAirportIATACode;
    /**
     * 航线的距离
     */
    private Integer airRouteDistance;
    /**
     * 旅客周转量
     */
    private Integer passengerTonKilometers;
    /**
     * 货物周转量
     */
    private Integer cargoTonKilometers;
    /**
     * 邮件周转量
     */
    private Integer mailTonKilometers;
    /**
     * 领域，例如国内国外
     */
    private SectorCode sectorCode;
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

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(String departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    public Integer getAirRouteDistance() {
        return airRouteDistance;
    }

    public void setAirRouteDistance(Integer airRouteDistance) {
        this.airRouteDistance = airRouteDistance;
    }

    public Integer getPassengerTonKilometers() {
        return passengerTonKilometers;
    }

    public void setPassengerTonKilometers(Integer passengerTonKilometers) {
        this.passengerTonKilometers = passengerTonKilometers;
    }

    public Integer getCargoTonKilometers() {
        return cargoTonKilometers;
    }

    public void setCargoTonKilometers(Integer cargoTonKilometers) {
        this.cargoTonKilometers = cargoTonKilometers;
    }

    public Integer getMailTonKilometers() {
        return mailTonKilometers;
    }

    public void setMailTonKilometers(Integer mailTonKilometers) {
        this.mailTonKilometers = mailTonKilometers;
    }

    public SectorCode getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(SectorCode sectorCode) {
        this.sectorCode = sectorCode;
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
