package com.gxairport.ais.models.aodb.flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gxairport.ais.enums.aodb.FlightDirection;
import com.gxairport.ais.enums.aodb.SectorCode;
import com.gxairport.ais.models.IntIdEntity;
import com.gxairport.ais.models.aodb.flight.collection.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FileName HistoryFlight.java
 * <p>
 * Description TODO 运营航班的历史数据，主要是定义各中航班相关的实体表
 *
 * @author ZhangYu Company: gxAirport
 * @version V1.0 CreateDate: 2017年6月20日
 * ModificationHistory Date Author Version Description
 * ---------------------------------------------
 * 2017年6月20日 ZhangYu 1.0 create
 * Why  What is modified:
 */

@Entity
@Table(name = "History_Flight")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_HistoryFlight", allocationSize = 1)
public class HistoryFlight extends IntIdEntity {


    /*
     * @Description 航班标识信息的静态类，能唯一标识一个航班
     * -------------------------------------------------------------------------------------------------
     */

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String FLIGHT_NUMBER = "flightNumber";
    public static final String FLIGHT_DIRECTION = "flightDirection";
    public static final String SCHEDULED_DATETIME = "scheduledDateTime";
    public static final String EXEC_DATETIME = "execDateTime";
    public static final String SETTLEMENT_DATE = "settlementDate";
    public static final String FLIGHT_REPEAT_COUNT = "flightRepeatCount";
    public static final String AIRLINE_IATA_CODE = "airlineIATACode";

    /**
     * 航班号
     */
    @Column(length = 8)
    private String flightNumber;
    /**
     * 进出港标识
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private FlightDirection flightDirection;

    @Column(length = 10)
    private String airlineIATACode;

    /**
     * 执行日期1 标识离港航班日期跟计划离港日期，进港航班日期跟计划进港日期
     */
    private Date scheduledDateTime;

    /**
     * 执行日期2 标识所有航班日期都跟计划离港日期
     */
    private Date execDateTime;

    /**
     * 结算日期 根据进出港航班实际起飞落地时间
     */
    private Date settlementDate;
    /**
     * 航班重复次数，一般指返场
     */
    private Integer flightRepeatCount;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public FlightDirection getFlightDirection() {
        return flightDirection;
    }

    public void setFlightDirection(FlightDirection flightDirection) {
        this.flightDirection = flightDirection;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getExecDateTime() {
        return execDateTime;
    }

    public void setExecDateTime(Date execDateTime) {
        this.execDateTime = execDateTime;
    }

    public Integer getFlightRepeatCount() {
        return flightRepeatCount;
    }

    public void setFlightRepeatCount(Integer flightRepeatCount) {
        this.flightRepeatCount = flightRepeatCount;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getAirlineIATACode() {
        return airlineIATACode;
    }

    public void setAirlineIATACode(String airlineIATACode) {
        this.airlineIATACode = airlineIATACode;
    }

    /*
     * Description 飞机数据的静态类，与飞机数据相关的数据集合
     * ---------------------------------------------------------------------------------------------------------------
     */

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String AIRCRAFT_REGISTRATION = "aircraftRegistration";
    public static final String SUBTYPE_IATA_CODE = "SubtypeIATACode";
    public static final String CARRIER_CODE = "carrierCode";
    public static final String SETTLEMENT_LOAD = "settlementPayload";
    public static final String MAXIMUM_PAYLOAD = "maximumPayload";
    public static final String MAXIMUM_PASSENGER_CAPACITY = "maximumPassengerCapacity";
    public static final String AVAILABLE_PAYLOAD = "availablePayload";
    public static final String AVAILABLE_PASSENGER_CAPACITY = "availablePassengerCapacity";

    /**
     * 飞机注册号
     */
    @Column(length = 15)
    private String aircraftRegistration;
    /**
     * 机型
     */
    @Column(length = 10)
    private String SubtypeIATACode;

    @Column(length = 3)
    private String carrierCode;

    /**
     * 最大业载，用于统计系统
     */
    private Integer maximumPayload;
    /**
     * 最大座位数，用于统计系统
     */
    private Integer maximumPassengerCapacity;
    /**
     * 可用业载，用于统计系统
     */
    private Integer availablePayload;
    /**
     * 可用座位数，用于统计系统
     */
    private Integer availablePassengerCapacity;

    public String getAircraftRegistration() {
        return aircraftRegistration;
    }

    public void setAircraftRegistration(String aircraftRegistration) {
        this.aircraftRegistration = aircraftRegistration;
    }


    public String getSubtypeIATACode() {
        return SubtypeIATACode;
    }

    public void setSubtypeIATACode(String subtypeIATACode) {
        SubtypeIATACode = subtypeIATACode;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public Integer getMaximumPayload() {
        return maximumPayload;
    }

    public void setMaximumPayload(Integer maximumPayload) {
        this.maximumPayload = maximumPayload;
    }

    public Integer getMaximumPassengerCapacity() {
        return maximumPassengerCapacity;
    }

    public void setMaximumPassengerCapacity(Integer maximumPassengerCapacity) {
        this.maximumPassengerCapacity = maximumPassengerCapacity;
    }

    public Integer getAvailablePayload() {
        return availablePayload;
    }

    public void setAvailablePayload(Integer availablePayload) {
        this.availablePayload = availablePayload;
    }

    public Integer getAvailablePassengerCapacity() {
        return availablePassengerCapacity;
    }

    public void setAvailablePassengerCapacity(Integer availablePassengerCapacity) {
        this.availablePassengerCapacity = availablePassengerCapacity;
    }

    /*
     * Description 航班数据的静态类，与航班相关的数据
     * ---------------------------------------------------------------------------------------------------------------
     */

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String JOIN_FLIGHT_NUMBER = "joinFlightNumber";
    public static final String CLASSIFICATION_CODE = "classificationCode";
    public static final String NATURE_CODE = "natureCode";
    public static final String SERVICE_TYPE_IATA_CODE = "serviceTypeIATACode";
    public static final String DEPARTURE_AIRPORT_IATA_CODE = "departureAirportIATACode";
    public static final String ARRIVAL_AIRPORT_IATA_CODE = "arrivalAirportIATACode";
    public static final String IS_OPERATES_OVERNIGHT = "isOperatesOvernight";
    public static final String IS_BEFORE_FLIGHT = "isBeforeFlight";
    public static final String IS_GENERAL_AVIATION_FLIGHT = "isGeneralAviationFlight";
    public static final String IS_TRANSFER_FLIGHT = "isTransferFlight";
    public static final String SECTOR_CODE = "sectorCode";
    public static final String FLIGHT_STATUS_CODE = "flightStatusCode";
    public static final String DIVERT_AIRPORT_IATA_CODE = "divertAirportIATACode";
    public static final String IS_RETURN_FLIGHT = "isReturnFlight";
    public static final String HAS_VIPS = "hasVIPs";
    public static final String FLIGHT_CODE = "flightCode";
    public static final String CAAC_DELAY_CATEGORY_CODE = "caacDelayCategoryCode";
    public static final String CAAC_DELAY_CODE = "caacDelayCode";
    public static final String CAAC_DELAY_DURATION = "caacDelayDuration";
    public static final String CAAC_DELAY_AIRPORT_ORIGINATED = "caacDelayAirportOriginated";
    public static final String LINKED_FLIGHT_NUMBER = "linkedFlightNumber";
    public static final String LINKED_FLIGHT_DIRECTION = "linkedFlightDirection";
    public static final String LINKED_SCHEDULED_DATETIME = "linkedScheduledDateTime";
    public static final String SHARE_FLIGHT_NUMBER_1 = "shareFlightNumber_1";
    public static final String SHARE_AIRLINE_1 = "shareAirlineIATACode_1";
    public static final String SHARE_FLIGHT_NUMBER_2 = "shareFlightNumber_2";
    public static final String SHARE_AIRLINE_2 = "shareAirlineIATACode_2";

    /**
     * 拼接航班号
     */
    @Column(length = 17)
    private String joinFlightNumber;
    /**
     * 航班分类代码，例如 W/Z
     */
    @Column(length = 3)
    private String classificationCode;

    /**
     * 航班性质，例如PAX
     */
    @Column(length = 3)
    private String natureCode;

    /**
     * 航班服务性质，例如J
     */
    @Column(length = 1)
    private String serviceTypeIATACode;
    /**
     * 航班服务性质
     */
    private String serviceTypeCnName;
    /**
     * 区域，例如国内国外
     */
    private SectorCode sectorCode;
    /**
     * 出港机场IATA代码
     */
    @Column(length = 10)
    private String departureAirportIATACode;

    /**
     * 到达机场IATA代码
     */
    @Column(length = 10)
    private String arrivalAirportIATACode;

    /**
     * 航后服务标志
     */
    private Boolean isOperatesOvernight;
    /**
     * 航前服务标志
     */
    private Boolean isBeforeFlight;
    /**
     * 通航航班标志
     */
    private Boolean isGeneralAviationFlight;
    /**
     * 中转航班标志
     */
    private Boolean isTransferFlight;
    /**
     * 航班状态
     */
    @Column(length = 3)
    private String flightStatusCode;
    /**
     * 备降机场IATA代码
     */
    @Column(length = 10)
    private String divertAirportIATACode;

    /**
     * 航班航班标识
     */
    private Boolean isReturnFlight;
    /**
     * 是否有VIP
     */
    private Boolean hasVIPs;
    /**
     * 航班代码
     */
    @Column(length = 3)
    private String flightCode;
    /**
     * 延误类别
     */
    @Column(length = 4)
    private String caacDelayCategoryCode;
    /**
     * 延误代码
     */
    @Column(length = 4)
    private String caacDelayCode;
    /**
     * 延误时间
     */
    @Column(length = 6)
    private String caacDelayDuration;
    /**
     * 是否是始发延误原因
     */
    private Boolean caacDelayAirportOriginated;
    /**
     * 连接航班号
     */
    @Column(length = 8)
    private String linkedFlightNumber;
    /**
     * 进出港标识
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private FlightDirection linkedFlightDirection;
    /**
     * 连接航班日期
     */
    private Date linkedScheduledDateTime;
    /**
     * 共享航班号
     */
    @Column(length = 8)
    private String shareFlightNumber_1;
    /**
     * 共享航空公司
     */
    @Column(length = 10)
    private String shareAirlineICAOCode_1;
    /**
     * 共享航班号
     */
    @Column(length = 8)
    private String shareFlightNumber_2;
    /**
     * 共享航空公司
     */
    @Column(length = 10)
    private String shareAirlineICAOCode_2;

    public String getJoinFlightNumber() {
        return joinFlightNumber;
    }

    public void setJoinFlightNumber(String joinFlightNumber) {
        this.joinFlightNumber = joinFlightNumber;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getNatureCode() {
        return natureCode;
    }

    public void setNatureCode(String natureCode) {
        this.natureCode = natureCode;
    }

    public String getServiceTypeIATACode() {
        return serviceTypeIATACode;
    }

    public void setServiceTypeIATACode(String serviceTypeIATACode) {
        this.serviceTypeIATACode = serviceTypeIATACode;
    }

    public SectorCode getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(SectorCode sectorCode) {
        this.sectorCode = sectorCode;
    }

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


    public String getFlightStatusCode() {
        return flightStatusCode;
    }

    public void setFlightStatusCode(String flightStatusCode) {
        this.flightStatusCode = flightStatusCode;
    }

    public String getDivertAirportIATACode() {
        return divertAirportIATACode;
    }

    public void setDivertAirportIATACode(String divertAirportIATACode) {
        this.divertAirportIATACode = divertAirportIATACode;
    }

    public Boolean getOperatesOvernight() {
        return isOperatesOvernight;
    }

    public void setOperatesOvernight(Boolean operatesOvernight) {
        isOperatesOvernight = operatesOvernight;
    }

    public Boolean getBeforeFlight() {
        return isBeforeFlight;
    }

    public void setBeforeFlight(Boolean beforeFlight) {
        isBeforeFlight = beforeFlight;
    }

    public Boolean getGeneralAviationFlight() {
        return isGeneralAviationFlight;
    }

    public void setGeneralAviationFlight(Boolean generalAviationFlight) {
        isGeneralAviationFlight = generalAviationFlight;
    }

    public Boolean getTransferFlight() {
        return isTransferFlight;
    }

    public void setTransferFlight(Boolean transferFlight) {
        isTransferFlight = transferFlight;
    }

    public Boolean getReturnFlight() {
        return isReturnFlight;
    }

    public void setReturnFlight(Boolean returnFlight) {
        isReturnFlight = returnFlight;
    }

    public Boolean getHasVIPs() {
        return hasVIPs;
    }

    public void setHasVIPs(Boolean hasVIPs) {
        this.hasVIPs = hasVIPs;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getCaacDelayCategoryCode() {
        return caacDelayCategoryCode;
    }

    public void setCaacDelayCategoryCode(String caacDelayCategoryCode) {
        this.caacDelayCategoryCode = caacDelayCategoryCode;
    }

    public String getCaacDelayCode() {
        return caacDelayCode;
    }

    public void setCaacDelayCode(String caacDelayCode) {
        this.caacDelayCode = caacDelayCode;
    }

    public String getCaacDelayDuration() {
        return caacDelayDuration;
    }

    public void setCaacDelayDuration(String caacDelayDuration) {
        this.caacDelayDuration = caacDelayDuration;
    }

    public Boolean getCaacDelayAirportOriginated() {
        return caacDelayAirportOriginated;
    }

    public void setCaacDelayAirportOriginated(Boolean caacDelayAirportOriginated) {
        this.caacDelayAirportOriginated = caacDelayAirportOriginated;
    }

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

    public Date getLinkedScheduledDateTime() {
        return linkedScheduledDateTime;
    }

    public void setLinkedScheduledDateTime(Date linkedscheduledDateTime) {
        this.linkedScheduledDateTime = linkedscheduledDateTime;
    }

    public String getShareFlightNumber_1() {
        return shareFlightNumber_1;
    }

    public void setShareFlightNumber_1(String shareFlightNumber_1) {
        this.shareFlightNumber_1 = shareFlightNumber_1;
    }

    public String getShareAirlineICAOCode_1() {
        return shareAirlineICAOCode_1;
    }

    public void setShareAirlineICAOCode_1(String shareAirlineICAOCode_1) {
        this.shareAirlineICAOCode_1 = shareAirlineICAOCode_1;
    }

    public String getShareFlightNumber_2() {
        return shareFlightNumber_2;
    }

    public void setShareFlightNumber_2(String shareFlightNumber_2) {
        this.shareFlightNumber_2 = shareFlightNumber_2;
    }

    public String getShareAirlineICAOCode_2() {
        return shareAirlineICAOCode_2;
    }

    public void setShareAirlineICAOCode_2(String shareAirlineICAOCode_2) {
        this.shareAirlineICAOCode_2 = shareAirlineICAOCode_2;
    }

    public String getServiceTypeCnName() {
        return serviceTypeCnName;
    }

    public void setServiceTypeCnName(String serviceTypeCnName) {
        this.serviceTypeCnName = serviceTypeCnName;
    }

    /*
     * @Description 机场数据的静态类，与机场相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String LOCAL_AIRPORT_IATA_CODE = "localAirportIATACode";
    public static final String TERMINAL_CODE = "terminalCode";
    public static final String STAND_POSITION = "standPosition";
    public static final String RUNWAY_ID = "runwayID";
    public static final String BAGGAGE_MAKEUP_POSITION_ID = "baggageMakeupPositionID";
    public static final String BAGGAGE_MAKEUP_OPEN_DATETIME = "baggageMakeupOpenDateTime";
    public static final String BAGGAGE_MAKEUP_CLOSE_DATETIME = "baggageMakeupCloseDateTime";
    public static final String BAGGAGE_RECLAIM_CAROUSEL_ID = "baggageReclaimCarouselID";
    public static final String BAGGAGE_RECLAIM_OPEN_DATETIME = "baggageReclaimOpenDateTime";
    public static final String BAGGAGE_RECLAIM_CLOSE_DATETIME = "baggageReclaimCloseDateTime";
    public static final String FIRST_BAG_DATETIME = "firstBagDateTime";
    public static final String LAST_BAG_DATETIME = "lastBagDateTime";
    public static final String EXIT_DOOR_NUMBER = "exitDoorNumber";
    public static final String CHECKIN_DESK_RANGE = "checkInDeskRange";
    public static final String CHECKIN_OPEN_DATETIME = "checkInOpenDateTime";
    public static final String CHECKIN_CLOSE_DATETIME = "checkInCloseDateTime";
    public static final String GATE_NUMBER = "gateNumber";
    public static final String GATE_OPEN_DATETIME = "gateOpenDateTime";
    public static final String GATE_CLOSE_DATETIME = "gateCloseDateTime";
    /**
     * 本地机场
     */
    @Column(length = 10)
    private String localAirportIATACode;

    /**
     * 起降频率
     */
    private Integer landFreq;
    /**
     * 航站楼
     */
    @Column(length = 4)
    private String terminalCode;
    /**
     * 停机位
     */
    @Column(length = 15)
    private String standPosition;
    /**
     * 跑道
     */
    @Column(length = 10)
    private String runwayID;
    /**
     * 行李装载转盘编号
     */
    @Column(length = 4)
    private String baggageMakeupPositionID;
    /**
     * 开启时间
     */
    private Date baggageMakeupOpenDateTime;
    /**
     * 关闭时间
     */
    private Date baggageMakeupCloseDateTime;

    /**
     * 行李提取转盘编号
     */
    @Column(length = 4)
    private String baggageReclaimCarouselID;

    /**
     * 开启时间
     */
    private Date baggageReclaimOpenDateTime;
    /**
     * 关闭时间
     */
    private Date baggageReclaimCloseDateTime;
    /**
     * 开启时间
     */
    private Date firstBagDateTime;
    /**
     * 关闭时间
     */
    private Date lastBagDateTime;
    /**
     * 出口标识
     */
    @Column(length = 4)
    private String exitDoorNumber;

    @Column(length = 32)
    private String checkInDeskRange;
    /**
     * 值机开始时间
     */
    private Date checkInOpenDateTime;
    /**
     * 值机结束时间
     */
    private Date checkInCloseDateTime;
    /**
     * 登机口编号
     */
    private String gateNumber;
    /**
     * 登机开放的时间
     */
    private Date gateOpenDateTime;
    /**
     * 登机结束的时间
     */
    private Date gateCloseDateTime;

    public String getLocalAirportIATACode() {
        return localAirportIATACode;
    }

    public void setLocalAirportIATACode(String localAirpotIATACode) {
        this.localAirportIATACode = localAirpotIATACode;
    }

    public Integer getLandFreq() {
        return landFreq;
    }

    public void setLandFreq(Integer landFreq) {
        this.landFreq = landFreq;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public String getStandPosition() {
        return standPosition;
    }

    public void setStandPosition(String standPosition) {
        this.standPosition = standPosition;
    }

    public String getRunwayID() {
        return runwayID;
    }

    public void setRunwayID(String runwayID) {
        this.runwayID = runwayID;
    }

    public String getBaggageMakeupPositionID() {
        return baggageMakeupPositionID;
    }

    public void setBaggageMakeupPositionID(String baggageMakeupPositionID) {
        this.baggageMakeupPositionID = baggageMakeupPositionID;
    }

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

    public String getBaggageReclaimCarouselID() {
        return baggageReclaimCarouselID;
    }

    public void setBaggageReclaimCarouselID(String baggageReclaimCarouselID) {
        this.baggageReclaimCarouselID = baggageReclaimCarouselID;
    }

    public Date getBaggageReclaimOpenDateTime() {
        return baggageReclaimOpenDateTime;
    }

    public void setBaggageReclaimOpenDateTime(Date baggageReclaimOpenDateTime) {
        this.baggageReclaimOpenDateTime = baggageReclaimOpenDateTime;
    }

    public Date getBaggageReclaimCloseDateTime() {
        return baggageReclaimCloseDateTime;
    }

    public void setBaggageReclaimCloseDateTime(Date baggageReclaimCloseDateTime) {
        this.baggageReclaimCloseDateTime = baggageReclaimCloseDateTime;
    }

    public Date getFirstBagDateTime() {
        return firstBagDateTime;
    }

    public void setFirstBagDateTime(Date firstBagDateTime) {
        this.firstBagDateTime = firstBagDateTime;
    }

    public Date getLastBagDateTime() {
        return lastBagDateTime;
    }

    public void setLastBagDateTime(Date lastBagDateTime) {
        this.lastBagDateTime = lastBagDateTime;
    }

    public String getExitDoorNumber() {
        return exitDoorNumber;
    }

    public void setExitDoorNumber(String exitDoorNumber) {
        this.exitDoorNumber = exitDoorNumber;
    }

    public String getCheckInDeskRange() {
        return checkInDeskRange;
    }

    public void setCheckInDeskRange(String checkinDeskRange) {
        this.checkInDeskRange = checkinDeskRange;
    }

    public Date getCheckInOpenDateTime() {
        return checkInOpenDateTime;
    }

    public void setCheckInOpenDateTime(Date checkinOpenDateTime) {
        this.checkInOpenDateTime = checkinOpenDateTime;
    }

    public Date getCheckInCloseDateTime() {
        return checkInCloseDateTime;
    }

    public void setCheckInCloseDateTime(Date checkinCloseDateTime) {
        this.checkInCloseDateTime = checkinCloseDateTime;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

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

    /*
     * @Description 航班时间相关的静态类，所有操作时间的集合 注：备降时间也更新在正常起降时间中
     * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String ACTUAL_OFF_BLOCKS_DATETIME = "actualOffBlocksDateTime";
    public static final String ACTUAL_ON_BLOCKS_DATETIME = "actualOnBlocksDateTime";
    public static final String SCHEDULED_DEPARTURE_DATETIME = "scheduledDepartureDateTime";
    public static final String ESTIMATED_DEPARTURE_DATETIME = "estimatedDepartureDateTime";
    public static final String ACTUAL_AIRBORNE_DATETIME = "actualAirborneDateTime";
    public static final String SCHEDULED_ARRIVAL_DATETIME = "scheduledArrivalDateTime";
    public static final String ESTIMATED_ARRIVAL_DATETIME = "estimatedArrivalDateTime";
    public static final String ACTUAL_LAND_DATETIME = "actualLandDateTime";
    public static final String ESTIMATED_FLIGHT_DURATION = "estimatedFlightDuration";

    /**
     * 实际停到停机位的时间
     */
    private Date actualOffBlocksDateTime;
    /**
     * 实际停到停机位的时间
     */
    private Date actualOnBlocksDateTime;

    /**
     * 计划出发的时间
     */
    private Date scheduledDepartureDateTime;
    /**
     * 预计出发的时间
     */
    private Date estimatedDepartureDateTime;
    /**
     * 实际起飞的时间
     */
    private Date actualAirborneDateTime;
    /**
     * 计划到达的时间
     */
    private Date scheduledArrivalDateTime;
    /**
     * 预计到达的时间
     */
    private Date estimatedArrivalDateTime;
    /**
     * 实际落地的时间
     */
    private Date actualLandDateTime;
    /**
     * 预计飞行时间
     */
    @Column(length = 6)
    private String estimatedFlightDuration;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getActualOffBlocksDateTime() {
        return actualOffBlocksDateTime;
    }

    public void setActualOffBlocksDateTime(Date actualOffBlocksDateTime) {
        this.actualOffBlocksDateTime = actualOffBlocksDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getActualOnBlocksDateTime() {
        return actualOnBlocksDateTime;
    }

    public void setActualOnBlocksDateTime(Date actualOnBlocksDateTime) {
        this.actualOnBlocksDateTime = actualOnBlocksDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getActualAirborneDateTime() {
        return actualAirborneDateTime;
    }

    public void setActualAirborneDateTime(Date actualAirborneDateTime) {
        this.actualAirborneDateTime = actualAirborneDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getActualLandDateTime() {
        return actualLandDateTime;
    }

    public void setActualLandDateTime(Date actualLandDateTime) {
        this.actualLandDateTime = actualLandDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getScheduledDepartureDateTime() {
        return scheduledDepartureDateTime;
    }

    public void setScheduledDepartureDateTime(Date scheduledDepartureDateTime) {
        this.scheduledDepartureDateTime = scheduledDepartureDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getEstimatedDepartureDateTime() {
        return estimatedDepartureDateTime;
    }

    public void setEstimatedDepartureDateTime(Date estimatedDepartureDateTime) {
        this.estimatedDepartureDateTime = estimatedDepartureDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getScheduledArrivalDateTime() {
        return scheduledArrivalDateTime;
    }

    public void setScheduledArrivalDateTime(Date scheduledArrivalDateTime) {
        this.scheduledArrivalDateTime = scheduledArrivalDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getEstimatedArrivalDateTime() {
        return estimatedArrivalDateTime;
    }

    public void setEstimatedArrivalDateTime(Date estimatedArrivalDateTime) {
        this.estimatedArrivalDateTime = estimatedArrivalDateTime;
    }

    public String getEstimatedFlightDuration() {
        return estimatedFlightDuration;
    }

    public void setEstimatedFlightDuration(String estimatedFlightDuration) {
        this.estimatedFlightDuration = estimatedFlightDuration;
    }

    /*
     * @Description 航线数据的静态类，与航线数据相关的数据集合
     * -------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String FIRST_STATION_IATA_CODE = "firstStationIATACode";
    public static final String STOP_IATA_CODE_1 = "stopIATACode_1";
    public static final String STOP_IATA_CODE_2 = "stopIATACode_2";
    public static final String DESTINATION_STATION_IATA_CODE = "destinationStationIATACode";
    public static final String AIR_ROUTE = "airRoute";
    public static final String CHINESE_ROUTE = "chineseRoute";
    public static final String IATA_ROUTE = "IATARoute";
    public static final String SHORT_ROUTE = "shortRoute";
    public static final String AIR_ROUTE_DISTANCE = "airRouteDistance";

    /**
     * 航路
     */
    @Column(length = 64)
    private String airRoute;
    /**
     * 航线的距离
     */
    private Integer airRouteDistance;
    /**
     * 起始机场IATA代码
     */
    @Column(length = 10)
    private String firstStationIATACode;
    /**
     * 经停点1 IATA代码
     */
    @Column(length = 10)
    private String stopIATACode_1;
    /**
     * 经停点2 IATA代码
     */
    @Column(length = 10)
    private String stopIATACode_2;
    /**
     * 终端机场
     */
    @Column(length = 10)
    private String destinationStationIATACode;
    /**
     * 航线中文
     */
    @Column(length = 128)
    private String chineseRoute;
    /**
     * 航线IATA代码
     */
    @Column(length = 64)
    private String IATARoute;
    /***
     * 航线简写
     */
    @Column(length = 64)
    private String shortRoute;

    public String getAirRoute() {
        return airRoute;
    }

    public void setAirRoute(String airRoute) {
        this.airRoute = airRoute;
    }

    public Integer getAirRouteDistance() {
        return airRouteDistance;
    }

    public void setAirRouteDistance(Integer airRouteDistance) {
        this.airRouteDistance = airRouteDistance;
    }

    public String getFirstStationIATACode() {
        return firstStationIATACode;
    }

    public void setFirstStationIATACode(String firstStationIATACode) {
        this.firstStationIATACode = firstStationIATACode;
    }

    public String getStopIATACode_1() {
        return stopIATACode_1;
    }

    public void setStopIATACode_1(String stopIATACode_1) {
        this.stopIATACode_1 = stopIATACode_1;
    }

    public String getStopIATACode_2() {
        return stopIATACode_2;
    }

    public void setStopIATACode_2(String stopIATACode_2) {
        this.stopIATACode_2 = stopIATACode_2;
    }

    public String getDestinationStationIATACode() {
        return destinationStationIATACode;
    }

    public void setDestinationStationIATACode(String destinationStationIATACode) {
        this.destinationStationIATACode = destinationStationIATACode;
    }

    public String getChineseRoute() {
        return chineseRoute;
    }

    public void setChineseRoute(String chineseRoute) {
        this.chineseRoute = chineseRoute;
    }

    public String getIATARoute() {
        return IATARoute;
    }

    public void setIATARoute(String iATARoute) {
        IATARoute = iATARoute;
    }

    public String getShortRoute() {
        return shortRoute;
    }

    public void setShortRoute(String shortRoute) {
        this.shortRoute = shortRoute;
    }

    /*
     * Description 航班载量的静态类，与载量相关的所有数据的集合
     *------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */
    public static final String PASSENGER_LOAD_FACTOR = "passengerLoadFactor";
    public static final String PASSENGER_TON_KILOMETERS = "passengerTonKilometers";
    public static final String PASSENGER_KILOMETERS = "passengerKilometers";
    public static final String CARGO_TON_KILOMETERS = "cargoMailTonKilometers";
    public static final String ADULT = "adult";
    public static final String CHD = "chd";
    public static final String INF = "inf";
    public static final String CARGO = "cargo";
    public static final String MAIL = "mail";
    public static final String BAGGAGE = "baggage";
    public static final String LOADS = "loads";
    public static final String PASSENGER_COUNTS = "passengerCounts";
    public static final String DEPARTURE_CHECK_COUNTS = "departureCheckCounts";
    public static final String DEPARTURE_LOAD_COUNTS = "departureLoadCounts";
    public static final String ARRIVAL_GOODS_COUNTS = "arrivalGoodsCounts";
    /**
     * 航班客座率
     */
    private Double passengerLoadFactor;
    /**
     * 旅客周转量(吨公里)
     */
    private Integer passengerTonKilometers;

    /**
     * 旅客周转量(人公里)
     */
    private Integer passengerKilometers;
    /**
     * 货邮周转量
     */
    private Integer cargoMailTonKilometers;

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
    /**
     * 中转成人
     */
    private Integer transferAdult;
    /**
     * 中转儿童
     */
    private Integer transferChd;
    /**
     * 中转婴儿
     */
    private Integer transferInf;

    /**
     * 详细载量航段
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "historyFlight_id")
    private Set<HistoryLoad> loads;


    /**
     * 出港货物开单统计
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "historyFlight_id")
    private Set<HistoryDepartureCheckCount> departureCheckCounts;

    /**
     * 出港货物载量统计
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "historyFlight_id")
    private Set<HistoryDepartureLoadCount> departureLoadCounts;

    /**
     * 进港货物统计
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "historyFlight_id")
    private Set<HistoryArrivalGoodsCount> arrivalGoodsCounts;


    public Set<HistoryLoad> getLoads() {
        if (loads == null) {
            loads = new HashSet<>();
        }
        return loads;
    }

    public void setLoads(Set<HistoryLoad> loads) {
        this.loads = loads;
    }


    public Set<HistoryDepartureCheckCount> getDepartureCheckCounts() {
        if (departureCheckCounts == null) {
            departureCheckCounts = new HashSet<>();
        }
        return departureCheckCounts;
    }

    public void setDepartureCheckCounts(Set<HistoryDepartureCheckCount> departureCheckCounts) {
        this.departureCheckCounts = departureCheckCounts;
    }

    public Set<HistoryDepartureLoadCount> getDepartureLoadCounts() {
        if (departureLoadCounts == null) {
            departureLoadCounts = new HashSet<>();
        }
        return departureLoadCounts;
    }

    public void setDepartureLoadCounts(Set<HistoryDepartureLoadCount> departureLoadCounts) {
        this.departureLoadCounts = departureLoadCounts;
    }

    public Set<HistoryArrivalGoodsCount> getArrivalGoodsCounts() {
        return arrivalGoodsCounts;
    }

    public void setArrivalGoodsCounts(Set<HistoryArrivalGoodsCount> arrivalGoodsCounts) {
        this.arrivalGoodsCounts = arrivalGoodsCounts;
    }

    public Double getPassengerLoadFactor() {
        return passengerLoadFactor;
    }

    public void setPassengerLoadFactor(Double passengerLoadFactor) {
        this.passengerLoadFactor = passengerLoadFactor;
    }

    public Integer getPassengerTonKilometers() {
        return passengerTonKilometers;
    }

    public void setPassengerTonKilometers(Integer passengerTonkilometers) {
        this.passengerTonKilometers = passengerTonkilometers;
    }

    public Integer getPassengerKilometers() {
        return passengerKilometers;
    }

    public void setPassengerKilometers(Integer passengerKilometers) {
        this.passengerKilometers = passengerKilometers;
    }

    public Integer getCargoMailTonKilometers() {
        return cargoMailTonKilometers;
    }

    public void setCargoMailTonKilometers(Integer cargoMailTonKilometers) {
        this.cargoMailTonKilometers = cargoMailTonKilometers;
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

    public Integer getTransferAdult() {
        return transferAdult;
    }

    public void setTransferAdult(Integer transferAdult) {
        this.transferAdult = transferAdult;
    }

    public Integer getTransferChd() {
        return transferChd;
    }

    public void setTransferChd(Integer transferChd) {
        this.transferChd = transferChd;
    }

    public Integer getTransferInf() {
        return transferInf;
    }

    public void setTransferInf(Integer transferInf) {
        this.transferInf = transferInf;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "historyFlight_id")
    private Set<HistoryEnsureService> ensureServices;

    public Set<HistoryEnsureService> getEnsureServices() {
        return ensureServices;
    }

    public void setEnsureServices(Set<HistoryEnsureService> ensureServices) {
        this.ensureServices = ensureServices;
    }


    /*
     * Description 更新
     * -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    public static final String UPDATE_SOURCE = "updateSource";
    public static final String UPDATE_TIME = "updateTime";

    /**
     * 数据更新源
     */

    private String updateSource;

    /**
     * 数据更新时间
     */
    private Date updateTime;

    public String getUpdateSource() {
        return updateSource;
    }

    public void setUpdateSource(String updateSource) {
        this.updateSource = updateSource;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
