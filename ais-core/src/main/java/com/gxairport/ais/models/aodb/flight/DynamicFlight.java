package com.gxairport.ais.models.aodb.flight;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gxairport.ais.models.aodb.basic.*;
import com.gxairport.ais.models.aodb.flight.collection.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;


/**
 * FileName      DynamicFlight.java
 * Description  运营航班的基类继承 BasicFlight,添加运营航班所需的数据字段。
 * 1、对静态数据集合类继承以便进一步的扩充字段
 * 2、添加一个静态数据集合类Load
 * 3、添加两个实体表
 * 3.1 DynamicFlight.BasicLoad.BasicLoad
 * 3.2 DynamicFlight.BasicLoad.BasicPayPassenger
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月17日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0    create
 * <p>Why  What is modified:
 */


@Entity
@Table(name = "Dynamic_Flight")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DynamicFlight", allocationSize = 1)
public class DynamicFlight extends BasicFlight {

    /*
     * 各个数据字段名,用来调用点用字段名
     */


    /**
     * Description  航班标识信息的静态类，能唯一标识一个航班
     * -----------------------------------------------------------------------------------------------------------------
     */
    public static final String SCHEDULED_DATETIME = "scheduledDateTime";
    public static final String FLIGHT_REPEAT_COUNT = "flightRepeatCount";
    /**
     * 执行日期
     */
    private Date scheduledDateTime;

    /**
     * 航班重复次数，一般指返场
     */
    private Integer flightRepeatCount;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public Integer getFlightRepeatCount() {
        return flightRepeatCount;
    }

    public void setFlightRepeatCount(Integer flightRepeatCount) {
        this.flightRepeatCount = flightRepeatCount;
    }




    /*
     * @Description  飞机数据的静态类，与飞机数据相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String AIRCRAFT = "aircraft";
    public static final String CARRIER = "carrier";
    public static final String SETTLEMENT_WEIGHT = "settlementWeight";
    public static final String SETTLEMENT_LOAD = "settlementPayload";
    public static final String MAXIMUM_PAY_LOAD = "maximumPayload";
    public static final String MAXIMUM_PASSENGER_CAPACITY = "maximumPassengerCapacity";
    public static final String AVAILABLE_PAYLOAD = "availablePayload";
    public static final String AVAILABLE_PASSENGER_CAPACITY = "availablePassengerCapacity";


    /**
     * 飞机
     */
    @ManyToOne
    @JoinColumn(name = "aircraftRegistration")
    private Aircraft aircraft;
    /**
     * 承运人
     */
    @ManyToOne
    @JoinColumn(name = "carrierCode")
    private Carrier carrier;
    /**
     * 飞机的重量,用于结算系统
     */
    private Integer settlementWeight;
    /**
     * 结算业载，用于结算
     */
    private Integer settlementPayload;

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

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Integer getSettlementWeight() {
        return settlementWeight;
    }

    public void setSettlementWeight(Integer settlementWeight) {
        this.settlementWeight = settlementWeight;
    }

    public Integer getSettlementPayload() {
        return settlementPayload;
    }

    public void setSettlementPayload(Integer settlementPayload) {
        this.settlementPayload = settlementPayload;
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
     * @Description  航班数据的静态类，与航班相关的数据
     *------------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String FLIGHT_STATUS = "flightStatus";
    public static final String DIVERT_AIRPORT = "divertAirport";
    public static final String IS_RETURN_FLIGHT = "isReturnFlight";
    public static final String HAS_VIPS = "hasVIPs";
    public static final String FLIGHT_CODE = "flightCode";
    public static final String CAAC_DELAY_CATEGORY = "caacDelayCategory";
    public static final String CAAC_DELAY_CODE = "caacDelayCode";
    public static final String CAAC_DELAY_DURATION = "caacDelayDuration";
    public static final String CAAC_DELAY_AIRPORT_ORIGINATED = "caacDelayAirportOriginated";


    /**
     * 航班状态
     */
    @ManyToOne
    @JoinColumn(name = "statusCode")
    private FlightStatus flightStatus;
    /**
     * 备降机场
     */
    @ManyToOne
    @JoinColumn(name = "divertAirportIATACode")
    private Airport divertAirport;
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
    @ManyToOne
    @JoinColumn(name = "flightCode")
    private FlightCode flightCode;
    /**
     * 延误类别
     */
    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private CAACDelayCategory CAACDelayCategory;
    /**
     * 延误代码
     */
    @ManyToOne
    @JoinColumn(name = "delayCode")
    private CAACDelayCode CAACDelayCode;
    /**
     * 延误时间
     */
    @Column(length = 6)
    private String CAACDelayDuration;
    /**
     * 是否是始发延误原因
     */
    private Boolean CAACDelayAirportOriginated;
    /**
     * 连接航班
     */
    @Embedded
    private LinkedFlight linkedFlight;


    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Airport getDivertAirport() {
        return divertAirport;
    }

    public void setDivertAirport(Airport divertAirport) {
        this.divertAirport = divertAirport;
    }

    public Boolean getIsReturnFlight() {
        return isReturnFlight;
    }

    public void setIsReturnFlight(Boolean isReturnFlight) {
        this.isReturnFlight = isReturnFlight;
    }

    public Boolean getHasVIPs() {
        return hasVIPs;
    }

    public void setHasVIPs(Boolean hasVIPs) {
        this.hasVIPs = hasVIPs;
    }

    public FlightCode getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(FlightCode flightCode) {
        this.flightCode = flightCode;
    }

    public LinkedFlight getLinkedFlight() {
        return linkedFlight;
    }

    public void setLinkedFlight(LinkedFlight linkedFlight) {
        this.linkedFlight = linkedFlight;
    }


    public CAACDelayCategory getCAACDelayCategory() {
        return CAACDelayCategory;
    }

    public void setCAACDelayCategory(CAACDelayCategory CAACDelayCategory) {
        this.CAACDelayCategory = CAACDelayCategory;
    }

    public CAACDelayCode getCAACDelayCode() {
        return CAACDelayCode;
    }

    public void setCAACDelayCode(CAACDelayCode CAACDelayCode) {
        this.CAACDelayCode = CAACDelayCode;
    }

    public String getCAACDelayDuration() {
        return CAACDelayDuration;
    }

    public void setCAACDelayDuration(String CAACDelayDuration) {
        this.CAACDelayDuration = CAACDelayDuration;
    }

    public Boolean getCAACDelayAirportOriginated() {
        return CAACDelayAirportOriginated;
    }

    public void setCAACDelayAirportOriginated(Boolean CAACDelayAirportOriginated) {
        this.CAACDelayAirportOriginated = CAACDelayAirportOriginated;
    }

    /**
     * 共享航班集合
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicShareFlight> shareFlights;

    /**
     * 航班经停点
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicStop> stops;

    @Override
    public Set<DynamicShareFlight> getShareFlights() {
        if (shareFlights == null) {
            shareFlights = new HashSet<>();
        }
        return shareFlights;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void setShareFlights(Set shareFlights) {
        this.shareFlights = shareFlights;
    }


    @Override
    public Set<DynamicStop> getStops() {
        if (stops == null) {
            stops = new LinkedHashSet<>();
        } else {
            /*
             * 进行排序，用冒泡排序法
             */
            DynamicStop[] sortStops = stops.toArray(new DynamicStop[0]);
            for (int i = 0; i < sortStops.length - 1; i++) {
                for (int j = 0; j < sortStops.length - i - 1; j++) {//-1为了防止溢出
                    if (sortStops[j].getOrderCode() > sortStops[j + 1].getOrderCode()) {
                        DynamicStop temp = sortStops[j];
                        sortStops[j] = sortStops[j + 1];
                        sortStops[j + 1] = temp;
                    }
                }
            }
            stops = new LinkedHashSet<>();
            stops.addAll(Arrays.asList(sortStops));
        }
        return stops;
    }


    @Override
    @SuppressWarnings({"unchecked"})
    public void setStops(Set stops) {
        this.stops = stops;
    }


    /*
     * @Description  航班时间相关的静态类，所有操作时间的集合
     * 注：备降时间也更新在正常起降时间中
     * -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String EXEC_DATETIME = "execDateTime";
    public static final String ACTUAL_OFF_BLOCKS_DATETIME = "actualOffBlocksDateTime";
    public static final String ACTUAL_ONB_LOCKS_DATETIME = "actualOnBlocksDateTime";
    public static final String SCHEDULED_DEPARTURE_DATETIME = "scheduledDepartureDateTime";
    public static final String ESTIMATED_DEPARTURE_DATETIME = "estimatedDepartureDateTime";
    public static final String ACTUAL_AIRBORNE_DATETIME = "actualAirborneDateTime";
    public static final String SCHEDULED_ARRIVAL_DATETIME = "scheduledArrivalDateTime";
    public static final String ESTIMATED_ARRIVAL_DATETIME = "estimatedArrivalDateTime";
    public static final String ACTUAL_LAND_DATETIME = "actualLandDateTime";


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
     * 执行日期
     */
    private Date execDateTime;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getExecDateTime() {
        return execDateTime;
    }

    public void setExecDateTime(Date execDateTime) {
        this.execDateTime = execDateTime;
    }




    /*
     * Description  机场数据的静态类，与机场相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */


    public static final String ENSURE_SERVICES = "ensureServices";

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicBaggageReclaimCarousel> baggageReclaimCarousels;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicBaggageMakeupPosition> baggageMakeupPositions;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicCheckIn> checkIns;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicGate> gates;

    @Override
    public Set<DynamicCheckIn> getCheckIns() {
        if (checkIns == null) {
            checkIns = new HashSet<>();
        }
        return checkIns;
    }


    @Override
    @SuppressWarnings({"unchecked"})
    public void setCheckIns(Set checkIns) {
        this.checkIns = checkIns;
    }


    @Override
    public Set<DynamicGate> getGates() {
        if (gates == null) {
            gates = new HashSet<>();
        }
        return gates;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void setGates(Set gates) {
        this.gates = gates;
    }

    @Override
    public Set<DynamicBaggageReclaimCarousel> getBaggageReclaimCarousels() {
        if (baggageReclaimCarousels == null) {
            baggageReclaimCarousels = new HashSet<>();
        }
        return baggageReclaimCarousels;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void setBaggageReclaimCarousels(Set baggageReclaimCarousels) {
        this.baggageReclaimCarousels = baggageReclaimCarousels;
    }

    @Override
    public Set<DynamicBaggageMakeupPosition> getBaggageMakeupPositions() {
        if (baggageMakeupPositions == null) {
            baggageMakeupPositions = new HashSet<>();
        }
        return baggageMakeupPositions;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void setBaggageMakeupPositions(Set baggageMakeupPositions) {
        this.baggageMakeupPositions = baggageMakeupPositions;
    }


    /*
     * @Description  航班载量的静态类，与载量相关的所有数据的集合
     * -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String PASSENGER_LOAD_FACTOR = "passengerLoadFactor";
    public static final String PASSENGER_TON_KILOMETERS = "passengerTonKilometers";
    public static final String CARGO_TON_KILOMETERS = "cargoTonKilometers";
    public static final String MAIL_TON_KILOMETERS = "mailTonKilometers";
    public static final String LOADS = "loads";
    public static final String PASSENGERS = "passengers";


    /**
     * 航班客座率
     */
    private Double passengerLoadFactor;
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

    public Double getPassengerLoadFactor() {
        return passengerLoadFactor;
    }

    public void setPassengerLoadFactor(Double passengerLoadFactor) {
        this.passengerLoadFactor = passengerLoadFactor;
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


    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicLoad> loads;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicPayPassenger> payPassengers;


    /**
     * 载量集合的返回方法，添加用ADD方法
     *
     * @return 载量集合
     */
    public Set<DynamicLoad> getLoads() {
        if (loads == null) {
            loads = new HashSet<>();
        }
        return loads;
    }

    /**
     * 设置载量的方法
     *
     * @param loads 载量集合
     */
    public void setLoads(Set<DynamicLoad> loads) {
        this.loads = loads;
    }

    /**
     * 付费旅客集合的放回方法，添加用ADD方法
     *
     * @return 付费旅客集合
     */
    public Set<DynamicPayPassenger> getPayPassengers() {
        if (payPassengers == null) {
            payPassengers = new HashSet<>();
        }
        return payPassengers;
    }

    /**
     * 设置旅客集合的方法
     *
     * @param payPassengers 付费旅客集合
     */
    public void setPassengers(Set<DynamicPayPassenger> payPassengers) {
        this.payPassengers = payPassengers;
    }

    /**
     * 服务保障节点
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "dynamicFlight_id")
    private Set<DynamicEnsureService> ensureServices;

    public Set<DynamicEnsureService> getEnsureServices() {
        if (ensureServices == null) {
            ensureServices = new HashSet<>();
        }
        return ensureServices;
    }


    public void setEnsureServices(Set<DynamicEnsureService> ensureServices) {
        this.ensureServices = ensureServices;
    }


}
