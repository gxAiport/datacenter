package com.gxairport.ais.models.passenger;

import com.gxairport.ais.enums.aodb.FlightDirection;
import com.gxairport.ais.enums.aodb.IDCardType;
import com.gxairport.ais.enums.aodb.SectorCode;
import com.gxairport.ais.enums.aodb.Sex;
import com.gxairport.ais.models.IntIdEntity;

import java.util.Date;

import javax.persistence.*;

/**
 * FileName      HistoryPassenger.java
 * Description  TODO 旅客的历史数据
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年9月24日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年9月24日      ZhangYu    1.0     create
 * Why  What is modified:
 */
@Entity
@Table(name = "History_Passenger")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_HistoryPassenger", allocationSize = 1)
public class HistoryPassenger extends IntIdEntity {

    public static final String FLIGHT_ID = "flightId";
    public static final String SCHEDULED_DATE = "scheduledDate";
    public static final String FLIGHT_NUMBER = "flightNumber";
    public static final String FLIGHT_DIRECTION = "flightDirection";
    public static final String NAME_CN = "nameCn";
    public static final String NAME_EN = "nameEn";
    public static final String ID_CARD_TYPE = "idCardType";
    public static final String ID_CARD_NUMBER = "idCardNumber";
    public static final String SEX = "sex";
    public static final String ADDRESS = "address";
    public static final String ID_CARD_DEPARTMENT = "idCardDepartment";
    public static final String ID_CARD_VALID_DATE = "idCardValidDate";
    public static final String DEPARTURE_AIRPORT_IATA_CODE = "departureAirportIATACode";
    public static final String DEPARTURE_AIRPORT_CN_Name = "departureAirportCnName";
    public static final String ARRIVAL_AIRPORT_IATA_CODE = "arrivalAirportIATACode";
    public static final String ARRIVAL_AIRPORT_CN_Name = "arrivalAirportCnName";
    public static final String TICKET_NUMBER = "ticketNumber";
    public static final String SEAT_CLASS = "seatClass";
    public static final String SEAT_NUMBER = "seatNumber";
    public static final String BAGGAGE_IATA_CODE = "baggageIATACode";
    public static final String GATE_NUMBER = "gateNumber";
    public static final String BOARDING_TIME = "boardingTime";
    public static final String VIP = "vip";
    public static final String TRANSFER = "transfer";
    public static final String HAS_BOARD = "hasBoard";
    public static final String ICS_CODE = "icsCode";
    public static final String AGE = "age";
    public static final String SECTOR_CODE = "sectorCode";
    public static final String PROVINCES = "provinces";
    public static final String GROUP_NUMBER = "groupNumber";
    public static final String CHECKIN_NUMBER = "checkInNumber";
    public static final String CHECKIN_TIME = "checkInTime";
    public static final String HAS_INF = "hasInf";
    public static final String BOARD_NUMBER = "boardNumber";
    public static final String AIRLINE_IATA_CODE = "airlineIATACode";
    public static final String AIRLINE_CN_CODE = "airlineCnCode";
    public static final String ROUTE_IATA_CODE = "routeIATACode";
    public static final String ROUTE_CN_CODE = "routeCnCode";
    public static final String GROUP = "group";
    public static final String AREA = "area";
    public static final String CITY_ADMIN_CODE = "cityAdminCode";
    public static final String CITY_CN_NAME = "cityCnName";
    public static final String SCHEDULED_DEPARTURE_TIME = "scheduleDepartmentTime";
    public static final String REGION = "region";


    /**
     * 航班标识
     */
    private Integer flightId;
    /**
     * 航班执行日期
     */
    private Date scheduledDate;
    /**
     * 计划出港时间
     */
    private Date scheduleDepartmentTime;
    /**
     * 航班号
     */
    @Column(length = 15)
    private String flightNumber;

    /**
     * 航空公司IATA代码
     */
    private String airlineIATACode;

    /**
     * 航空公司中文名
     */
    private String airlineCnName;

    /**
     * 进出港标识
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private FlightDirection flightDirection;

    /**
     * 姓名中文
     */
    @Column(length = 48)
    private String nameCn;
    /**
     * 姓名英文
     */
    @Column(length = 64)
    private String nameEn;
    /**
     * 证件类型
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private IDCardType idCardType;
    /**
     * 证件号码
     */
    @Lob
    private String idCardNumber;
    /**
     * 性别
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Sex sex;
    /**
     * 地址
     */
    @Column(length = 64)
    private String address;
    /**
     * 发证机关
     */
    @Column(length = 32)
    private String idCardDepartment;

    /**
     * 证件有效期
     */
    private Date idCardValidDate;

    /**
     * 始发机场IATA代码
     */
    @Column(length = 10)
    private String departureAirportIATACode;

    /**
     * 始发机场中文代码
     */
    @Column(length = 32)
    private String departureAirportCnName;
    /**
     * 目的机场IATA代码
     */
    @Column(length = 10)
    private String arrivalAirportIATACode;
    /**
     * 目的机场中文代码
     */
    @Column(length = 32)
    private String arrivalAirportCnName;

    /**
     * 航线IATA代码
     */
    private String routeIATACode;

    /**
     * 航线中文名
     */
    private String routeCnCode;


    /**
     * 团队号
     */
    @Column(length = 10)
    private String groupNumber;

    /**
     * 团队标识
     */
    @Column(name = "isGroup")
    private boolean group;


    /**
     * 客票号
     */
    @Column(length = 32)
    private String ticketNumber;
    /**
     * 登记号
     */
    @Column(length = 10)
    private String boardNumber;
    /**
     * 舱位等级
     */
    @Column(length = 4)
    private String seatLevel;
    /**
     * 座位号
     */
    @Column(length = 4)
    private String seatNumber;

    /**
     * 行李IATA代码
     */
    @Column(length = 32)
    private String baggageIATACode;

    /**
     * 是否携带行李
     */
    private boolean hasBag;

    /**
     * 登机口
     */
    @Column(length = 10)
    private String gateNumber;

    /**
     * 值机柜台
     */
    @Column(length = 10)
    private String checkInNumber;

    /**
     * 值机时间
     */
    private Date checkInTime;
    /**
     * 登机时间
     */
    private Date boardingTime;

    /**
     * 是否VIP
     */
    @Column(name = "isVip")
    private boolean vip;

    /**
     * 是否中转
     */
    @Column(name = "isTransfer")
    private boolean transfer;

    /**
     * 是否有小孩
     */
    private boolean hasInf;

    /**
     * 是否登机
     */
    private boolean hasBoard;
    /**
     * 旅客ICS代码
     */
    @Column(length = 20)
    private String icsCode;
    /**
     * 年龄
     */
    private int age;
    /**
     * 区域
     */
    private SectorCode sectorCode;
    /**
     * 省份
     */
    @Column(length = 32)
    private String provinces;
    /**
     * 区域
     */
    @Column(length = 16)
    private String area;

    /**
     * 地区
     */
    private String region;

    /**
     * 城市行政代码
     */
    @Column(length = 4)
    private String cityAdminCode;

    /**
     * 城市中文代码
     */
    private String cityCnName;

    /**
     * 电话号码
     */
    @Column(length = 38)
    private String telephoneNumber;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Date getScheduleDepartmentTime() {
        return scheduleDepartmentTime;
    }

    public void setScheduleDepartmentTime(Date scheduleDepartmentTime) {
        this.scheduleDepartmentTime = scheduleDepartmentTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlineIATACode() {
        return airlineIATACode;
    }

    public void setAirlineIATACode(String airlineIATACode) {
        this.airlineIATACode = airlineIATACode;
    }

    public String getAirlineCnName() {
        return airlineCnName;
    }

    public void setAirlineCnName(String airlineCnName) {
        this.airlineCnName = airlineCnName;
    }

    public FlightDirection getFlightDirection() {
        return flightDirection;
    }

    public void setFlightDirection(FlightDirection flightDirection) {
        this.flightDirection = flightDirection;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public IDCardType getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(IDCardType idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCardDepartment() {
        return idCardDepartment;
    }

    public void setIdCardDepartment(String idCardDepartment) {
        this.idCardDepartment = idCardDepartment;
    }

    public Date getIdCardValidDate() {
        return idCardValidDate;
    }

    public void setIdCardValidDate(Date idCardValidDate) {
        this.idCardValidDate = idCardValidDate;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(String departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    public String getDepartureAirportCnName() {
        return departureAirportCnName;
    }

    public void setDepartureAirportCnName(String departureAirportCnName) {
        this.departureAirportCnName = departureAirportCnName;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    public String getArrivalAirportCnName() {
        return arrivalAirportCnName;
    }

    public void setArrivalAirportCnName(String arrivalAirportCnName) {
        this.arrivalAirportCnName = arrivalAirportCnName;
    }

    public String getRouteIATACode() {
        return routeIATACode;
    }

    public void setRouteIATACode(String routeIATACode) {
        this.routeIATACode = routeIATACode;
    }

    public String getRouteCnCode() {
        return routeCnCode;
    }

    public void setRouteCnCode(String routeCnCode) {
        this.routeCnCode = routeCnCode;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    public String getSeatLevel() {
        return seatLevel;
    }

    public void setSeatLevel(String seatLevel) {
        this.seatLevel = seatLevel;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBaggageIATACode() {
        return baggageIATACode;
    }

    public void setBaggageIATACode(String baggageIATACode) {
        this.baggageIATACode = baggageIATACode;
    }

    public boolean isHasBag() {
        return hasBag;
    }

    public void setHasBag(boolean hasBag) {
        this.hasBag = hasBag;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getCheckInNumber() {
        return checkInNumber;
    }

    public void setCheckInNumber(String checkInNumber) {
        this.checkInNumber = checkInNumber;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public boolean isHasInf() {
        return hasInf;
    }

    public void setHasInf(boolean hasInf) {
        this.hasInf = hasInf;
    }

    public boolean isHasBoard() {
        return hasBoard;
    }

    public void setHasBoard(boolean hasBoard) {
        this.hasBoard = hasBoard;
    }

    public String getIcsCode() {
        return icsCode;
    }

    public void setIcsCode(String icsCode) {
        this.icsCode = icsCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SectorCode getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(SectorCode sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityAdminCode() {
        return cityAdminCode;
    }

    public void setCityAdminCode(String cityAdminCode) {
        this.cityAdminCode = cityAdminCode;
    }

    public String getCityCnName() {
        return cityCnName;
    }

    public void setCityCnName(String cityCnName) {
        this.cityCnName = cityCnName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}

	
	
	
