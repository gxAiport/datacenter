package com.gxairport.ais.models.aodb.flight;

import com.gxairport.ais.enums.aodb.FlightDirection;
import com.gxairport.ais.enums.aodb.SectorCode;
import com.gxairport.ais.models.IntIdEntity;
import com.gxairport.ais.models.aodb.basic.*;
import com.gxairport.ais.models.aodb.flight.collection.*;
import com.gxairport.ais.models.aodb.flight.collection.BasicGate;

import javax.persistence.*;
import java.util.Set;


/**
 * FileName      BasicFlight.java
 * Description  TODO 航班实体类的基类，航班所包含所有数据的集合
 * 基类有两种内部类：
 * 一、整理归纳相似数据的集合，此类为航班实体的一部分，用@Embedded注解，用Static关键字，为静态类，框架不会生成额外的表。
 * 1、BasicFlight.FlightIdentification
 * 2、BasicFlight.AircraftData
 * 3、BasicFlight.FlightData
 * 4、BasicFlight.RouteData
 * 5、BasicFlight.OperationalTimes
 * 6、BasicFlight.FlightData.BasicLinkedFlight
 * 二、与航班相关的实体表，一般是一对多，用@OneToMany注解，生成额外的实体表
 * 1、BasicFlight.FlightData.BasicShareFlight
 * 2、BasicFlight.RouteData.BasicStop
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月17日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月17日      ZhangYu    1.0     create
 * 2018年10月29日     ZhangYu    1.0     去掉了内部基类
 * Why  What is modified:
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BasicFlight extends IntIdEntity {

    /*
     * @Description  航班标识信息的静态类，能唯一标识一个航班
     * ------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String FLIGHT_NUMBER = "flightNumber";
    public static final String FLIGHT_DIRECTION = "flightDirection";
    public static final String AIRLINE = "airline";
    /**
     * 航班号
     */
    @Column(length = 15)
    private String flightNumber;
    /**
     * 进出港标识
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private FlightDirection flightDirection;
    /**
     * 航空公司
     */
    @ManyToOne
    @JoinColumn(name = "airLineICAOCode")
    private Airline airline;

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

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }



    /*
     * @Description  飞机数据的静态类，与飞机数据相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String AIRCRAFT_SUBTYPE = "aircraftSubtype";

    /**
     * 机型
     */
    @ManyToOne
    @JoinColumn(name = "aircraftSubtype")
    private AircraftSubtype aircraftSubtype;

    public AircraftSubtype getAircraftSubtype() {
        return aircraftSubtype;
    }

    public void setAircraftSubtype(AircraftSubtype aircraftSubtype) {
        this.aircraftSubtype = aircraftSubtype;
    }



    /*
     * @Description  航班数据的静态类，与航班相关的数据
     * -----------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String JOIN_FLIGHT_NUMBER = "joinFlightNumber";
    public static final String FLIGHT_CLASSIFICATION = "flightClassification";
    public static final String FLIGHT_NATURE = "flightNature";
    public static final String FLIGHT_SERVICE_TYPE = "flightServiceType";
    public static final String DEPARTURE_AIRPORT = "departureAirport";
    public static final String ARRIVAL_AIRPORT = "arrivalAirport";
    public static final String IS_OPERATES_OVERNIGHT = "isOperatesOvernight";
    public static final String IS_BEFORE_FLIGHT = "isBeforeFlight";
    public static final String IS_GENERAL_AVIATION_FLIGHT = "isGeneralAviationFlight";
    public static final String IS_TRANSFER_FLIGHT = "isTransferFlight";
    public static final String LINKED_FLIGHT = "linkedFlight";
    public static final String SHARE_FLIGHTS = "shareFlights";
    public static final String SECTOR = "sector";

    /**
     * 拼接航班号
     */
    @Column(length = 17)
    private String joinFlightNumber;
    /**
     * 航班分类，例如 W/Z
     */
    @ManyToOne
    @JoinColumn(name = "classificationCode")
    private FlightClassification flightClassification;
    /**
     * 航班性质，例如PAX
     */
    @ManyToOne
    @JoinColumn(name = "natureCode")
    private FlightNature flightNature;
    /**
     * 航班服务性质，例如J
     */
    @ManyToOne
    @JoinColumn(name = "serviceTypeCode")
    private FlightServiceType flightServiceType;

    /**
     * 领域，例如国内国外
     */
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private SectorCode sectorCode;

    /**
     * 出港机场
     */
    @ManyToOne
    @JoinColumn(name = "departureAirportIATACode")
    private Airport departureAirport;
    /**
     * 到达机场
     */
    @ManyToOne
    @JoinColumn(name = "arrivalAirportIATACode")
    private Airport arrivalAirport;

    /**
     * O
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


    public String getJoinFlightNumber() {
        return joinFlightNumber;
    }

    public void setJoinFlightNumber(String joinFlightNumber) {
        this.joinFlightNumber = joinFlightNumber;
    }

    public FlightClassification getFlightClassification() {
        return flightClassification;
    }

    public void setFlightClassification(FlightClassification flightClassification) {
        this.flightClassification = flightClassification;
    }

    public FlightNature getFlightNature() {
        return flightNature;
    }

    public void setFlightNature(FlightNature flightNature) {
        this.flightNature = flightNature;
    }

    public FlightServiceType getFlightServiceType() {
        return flightServiceType;
    }

    public void setFlightServiceType(FlightServiceType flightServiceType) {
        this.flightServiceType = flightServiceType;
    }

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


    public Boolean getIsOperatesOvernight() {
        return isOperatesOvernight;
    }

    public void setIsOperatesOvernight(Boolean isOperatesOvernight) {
        this.isOperatesOvernight = isOperatesOvernight;
    }

    public Boolean getIsBeforeFlight() {
        return isBeforeFlight;
    }

    public void setIsBeforeFlight(Boolean isBeforeFlight) {
        this.isBeforeFlight = isBeforeFlight;
    }

    public Boolean getIsGeneralAviationFlight() {
        return isGeneralAviationFlight;
    }

    public void setIsGeneralAviationFlight(Boolean isGeneralAviationFlight) {
        this.isGeneralAviationFlight = isGeneralAviationFlight;
    }

    public Boolean getIsTransferFlight() {
        return isTransferFlight;
    }

    public void setIsTransferFlight(Boolean isTransferFlight) {
        this.isTransferFlight = isTransferFlight;
    }

    public SectorCode getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(SectorCode sector) {
        this.sectorCode = sector;
    }

    /**
     * 共享航班集合的返回方法，添加集合用Add方法
     *
     * @return 返回共享航班的方法
     */
    public abstract Set<? extends BasicShareFlight> getShareFlights();

    /**
     * 设置共享航班
     *
     * @param shareFlights 共享航班集合
     */
    public abstract void setShareFlights(Set<? extends BasicShareFlight> shareFlights);


    /*
     * Description  机场数据的静态类，与机场相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String LOCAL_AIRPORT = "localAirport";
    public static final String TERMINAL = "terminal";
    public static final String STAND = "stand";
    public static final String RUNWAY = "runway";
    public static final String BAGGAGE_MAKEUP_POSITIONS = "baggageMakeupPositions";
    public static final String BAGGAGE_RECLAIM_CAROUSELS = "baggageReclaimCarousels";
    public static final String CHECKINS = "checkIns";
    public static final String GATES = "gates";
    /**
     * 本地机场
     */
    @ManyToOne
    @JoinColumn(name = "localAirportIATACode")
    private Airport localAirport;
    /**
     * 航站楼
     */
    @ManyToOne
    @JoinColumn(name = "terminalCode")
    private Terminal terminal;
    /**
     * 停机位
     */
    @ManyToOne
    @JoinColumn(name = "standPosition")
    private Stand stand;
    /**
     * 跑道
     */
    @ManyToOne
    @JoinColumn(name = "runwayID")
    private Runway runway;


    public Airport getLocalAirport() {
        return localAirport;
    }

    public void setLocalAirport(Airport localAirport) {
        this.localAirport = localAirport;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public Runway getRunway() {
        return runway;
    }

    public void setRunway(Runway runway) {
        this.runway = runway;
    }

    /**
     * 行李装载转盘集合的返回方法，添加集合用Add的方法
     *
     * @return 行李装载转盘集合
     */
    public abstract Set<? extends BasicBaggageMakeupPosition> getBaggageMakeupPositions();

    /**
     * 设置行李分拣转盘的方法
     *
     * @param baggageMakeupPositions 行李分拣转盘集合
     */
    public abstract void setBaggageMakeupPositions(Set<? extends BasicBaggageMakeupPosition> baggageMakeupPositions);

    /**
     * 行李认领转盘集合的返回方法，添加集合用Add的方法
     *
     * @return 行李认领转盘集合
     */
    public abstract Set<? extends BasicBaggageReclaimCarousel> getBaggageReclaimCarousels();

    /**
     * 设置行李提取转盘的方法
     *
     * @param baggageReclaimCarousels 行李提取转盘集合
     */
    public abstract void setBaggageReclaimCarousels(Set<? extends BasicBaggageReclaimCarousel> baggageReclaimCarousels);

    /**
     * 值机柜台集合的返回方法，添加集合用Add的方法
     *
     * @return 值机柜台集合
     */
    public abstract Set<? extends BasicCheckIn> getCheckIns();

    /**
     * 设置值机柜台的方法
     *
     * @param checkIns 值机柜台集合
     */
    public abstract void setCheckIns(Set<? extends BasicCheckIn> checkIns);


    /**
     * 登机口集合的返回方法，添加集合用Add的方法
     *
     * @return 值机柜台集合
     */
    public abstract Set<? extends BasicGate> getGates();

    /**
     * 设置登机口的方法
     *
     * @param gates 登机口集合
     */
    public abstract void setGates(Set<? extends BasicGate> gates);


    /*
     * Description  航线数据的静态类，与航线数据相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String AIR_ROUTE = "airRoute";
    public static final String AIR_ROUTE_DISTANCE = "airRouteDistance";
    public static final String FIRST_STATION = "firstStation";
    public static final String DESTINATION_STATION = "destinationStation";
    public static final String FIRST_STATION_SCHEDULED_AIRBORNE_TIME = "firstStationScheduledAirborneTime";
    public static final String DESTINATION_STATION_SCHEDULED_LAND_TIME = "destinationStationScheduledLandTime";
    public static final String FLIGHT_ROUTE = "flightRoute";
    public static final String STOPS = "stops";

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
     * 起始机场
     */
    @ManyToOne
    @JoinColumn(name = "firstStationIATACode")
    private Airport firstStation;
    /**
     * 最终机场
     */
    @ManyToOne
    @JoinColumn(name = "destinationStationIATACode")
    private Airport destinationStation;
    /**
     * 起始机场计划起飞时间
     */
    @Column(length = 6, name = "firstScheduledAirborneTime")
    private String firstStationScheduledAirborneTime;
    /**
     * 终端机场计划落地时间
     */
    @Column(length = 6, name = "destinationScheduledLandTime")
    private String destinationStationScheduledLandTime;
    /**
     * 对应的航线
     */
    @ManyToOne
    @JoinColumn(name = "flightRoute_id")
    private FlightRoute flightRoute;


    /**
     * @return the airRoute
     */
    public String getAirRoute() {
        return airRoute;
    }

    /**
     * @param airRoute the airRoute to set
     */
    public void setAirRoute(String airRoute) {
        this.airRoute = airRoute;
    }

    /**
     * @return the airRouteDistance
     */
    public Integer getAirRouteDistance() {
        return airRouteDistance;
    }

    /**
     * @param airRouteDistance the airRouteDistance to set
     */
    public void setAirRouteDistance(Integer airRouteDistance) {
        this.airRouteDistance = airRouteDistance;
    }

    /**
     * @return the firstStation
     */
    public Airport getFirstStation() {
        return firstStation;
    }

    /**
     * @param firstStation the firstStation to set
     */
    public void setFirstStation(Airport firstStation) {
        this.firstStation = firstStation;
    }

    /**
     * @return the destinationStation
     */
    public Airport getDestinationStation() {
        return destinationStation;
    }

    /**
     * @param destinationStation the destinationStation to set
     */
    public void setDestinationStation(Airport destinationStation) {
        this.destinationStation = destinationStation;
    }

    /**
     * @return the firstStationScheduledAirborneTime
     */
    public String getFirstStationScheduledAirborneTime() {
        return firstStationScheduledAirborneTime;
    }

    /**
     * @param firstStationScheduledAirborneTime the firstStationScheduledAirborneTime to set
     */
    public void setFirstStationScheduledAirborneTime(String firstStationScheduledAirborneTime) {
        this.firstStationScheduledAirborneTime = firstStationScheduledAirborneTime;
    }

    /**
     * @return the destinationStationScheduledLandTime
     */
    public String getDestinationStationScheduledLandTime() {
        return destinationStationScheduledLandTime;
    }

    /**
     * @param destinationStationScheduledLandTime the destinationStationScheduledLandTime to set
     */
    public void setDestinationStationScheduledLandTime(String destinationStationScheduledLandTime) {
        this.destinationStationScheduledLandTime = destinationStationScheduledLandTime;
    }

    /**
     * @return the flightRoute
     */
    public FlightRoute getFlightRoute() {
        return flightRoute;
    }

    /**
     * @param flightRoute the flightRoute to set
     */
    public void setFlightRoute(FlightRoute flightRoute) {
        this.flightRoute = flightRoute;
    }

    /**
     * 经停点集合的返回方法，添加集合用Add方法
     *
     * @return 经停点集合
     */
    public abstract Set<? extends BasicStop> getStops();

    /*
     * 经停航班集合的设置
     */
    public abstract void setStops(Set<? extends BasicStop> stops);


    /*
     * @Description  航班时间相关的静态类，所有操作时间的集合
     * -----------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String ESTIMATED_FLIGHT_DURATION = "estimatedFlightDuration";

    /**
     * 预计飞行时间
     */
    @Column(length = 6)
    private String estimatedFlightDuration;

    public String getEstimatedFlightDuration() {
        return estimatedFlightDuration;
    }

    public void setEstimatedFlightDuration(String estimatedFlightDuration) {

        this.estimatedFlightDuration = estimatedFlightDuration;
    }


    /**
     * 返回航线的中文
     *
     * @return 航线的中文
     */
    public String getChineseRoute() {
        StringBuilder route = new StringBuilder();
        if (firstStation != null) {
            route = new StringBuilder(firstStation.getChineseName());
        }

        for (BasicStop stop : getStops()) {
            if (stop.getStopAirport() != null) {
                route.append("-").append(stop.getStopAirport().getChineseName());
            }
        }

        if (destinationStation != null) {
            route.append("-").append(destinationStation.getChineseName());
        }
        return route.toString();
    }

    public String getIATARoute() {
        StringBuilder route = new StringBuilder();
        if (firstStation != null) {
            route = new StringBuilder(firstStation.getIATACode());
        }

        for (BasicStop stop : getStops()) {
            if (stop.getStopAirport() != null) {
                route.append("-").append(stop.getStopAirport().getIATACode());
            }
        }

        if (destinationStation != null) {
            route.append("-").append(destinationStation.getIATACode());
        }
        return route.toString();
    }

    public String getShortRoute() {
        StringBuilder route = new StringBuilder();
        if (firstStation != null) {
            route = new StringBuilder(firstStation.getShortName());
        }

        for (BasicStop stop : getStops()) {
            if (stop.getStopAirport() != null) {
                route.append("-").append(stop.getStopAirport().getShortName());
            }
        }

        if (destinationStation != null) {
            route.append("-").append(destinationStation.getShortName());
        }
        return route.toString();
    }


}
