package com.gxairport.ais.models.aodb.flight;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gxairport.ais.enums.aodb.FlightSeason;
import com.gxairport.ais.enums.aodb.OperationalDay;
import com.gxairport.ais.models.aodb.flight.collection.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FileName      SeasonFlight.java
 * Description  TODO 航季航班实体类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月19日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月19日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */


@Entity
@Table(name = "Season_Flight")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_SeasonFlight", allocationSize = 1)
public class SeasonFlight extends BasicFlight {

    private static final long serialVersionUID = 1L;


    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public final static String DAYS_OF_OPERATION = "daysOfOperation";
    public final static String SEASON = "season";
    public final static String FLIGHT_FIRST_DATETIME = "flightFirstDateTime";
    public final static String FLIGHT_LAST_DATETIME = "flightLastDateTime";


    /**
     * 航班执行频率集合
     */

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(length = 12)
    private Set<OperationalDay> daysOfOperation;
    /**
     * 航季
     */
    @Column(length = 15)
    @Enumerated(EnumType.STRING)
    private FlightSeason season;
    /**
     * 航季开始时间
     */
    private Date flightFirstDateTime;
    /**
     * 航季结束时间
     */
    private Date flightLastDateTime;

    public Set<OperationalDay> getDaysOfOperation() {
        if (daysOfOperation == null) {
            daysOfOperation = new HashSet<>();
        }
        return this.daysOfOperation;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getFlightFirstDateTime() {
        return flightFirstDateTime;
    }

    public void setFlightFirstDateTime(Date flightFirstDateTime) {
        this.flightFirstDateTime = flightFirstDateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getFlightLastDateTime() {
        return flightLastDateTime;
    }

    public void setFlightLastDateTime(Date flightLastDateTime) {
        this.flightLastDateTime = flightLastDateTime;
    }

    public FlightSeason getSeason() {
        return season;
    }


    public void setSeason(FlightSeason season) {
        this.season = season;
    }


    /*
     * Description  机场数据的静态类，与机场相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */


    /**
     * 航季行李装载转盘集合
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "season_Flight_id")
    private Set<SeasonBaggageMakeupPosition> baggageMakeupPositions;
    /**
     * 航季行李认领转盘集合
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "season_Flight_id")
    private Set<SeasonBaggageReclaimCarousel> baggageReclaimCarousels;
    /**
     * 航季值机柜台集合
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "season_Flight_id")
    private Set<SeasonCheckIn> checkIns;
    /**
     * 航季登机口集合
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "season_Flight_id")
    private Set<SeasonGate> gates;


    @Override
    public Set<SeasonBaggageMakeupPosition> getBaggageMakeupPositions() {
        if (baggageMakeupPositions == null) {
            baggageMakeupPositions = new HashSet<>();
        }
        return baggageMakeupPositions;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void setBaggageMakeupPositions(Set baggageMakeupPositions) {
        this.baggageMakeupPositions = baggageMakeupPositions;
    }

    @Override
    public Set<SeasonBaggageReclaimCarousel> getBaggageReclaimCarousels() {
        if (baggageReclaimCarousels == null) {
            baggageReclaimCarousels = new HashSet<>();
        }
        return baggageReclaimCarousels;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void setBaggageReclaimCarousels(Set baggageReclaimCarousels) {
        this.baggageReclaimCarousels = baggageReclaimCarousels;
    }

    @Override
    public Set<SeasonCheckIn> getCheckIns() {
        if (checkIns == null) {
            checkIns = new HashSet<>();
        }
        return checkIns;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void setCheckIns(Set checkIns) {
        this.checkIns = checkIns;
    }


    @Override
    public Set<SeasonGate> getGates() {
        if (gates == null) {
            gates = new HashSet<>();
        }
        return gates;
    }


    @SuppressWarnings({"unchecked"})
    @Override
    public void setGates(Set gates) {
        this.gates = gates;
    }



    /*
     * Description  航班数据的静态类，与航班相关的数据
     *------------------------------------------------------------------------------------------------------------------
     */

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "season_Flight_id")
    private Set<SeasonShareFlight> shareFlights;

    @Override
    public Set<SeasonShareFlight> getShareFlights() {
        if (shareFlights == null) {
            shareFlights = new HashSet<>();
        }
        return this.shareFlights;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void setShareFlights(Set shareFlights) {
        this.shareFlights = shareFlights;
    }


    /*
     * Description  航线数据的静态类，与航线数据相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "season_Flight_id")
    private Set<SeasonStop> stops;

    @Override
    public Set<SeasonStop> getStops() {
        if (stops == null) {
            stops = new HashSet<>();
        }
        return stops;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void setStops(Set stops) {
        this.stops = stops;
    }





    /*
     * @Description  航班时间相关的静态类，所有操作时间的集合
     * -----------------------------------------------------------------------------------------------------------------
     */
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String SCHEDULED_OFF_BLOCKS_DATETIME = "scheduledOffBlocksDateTime";
    public static final String SCHEDULED_ON_BLOCKS_DATETIME = "scheduledOnBlocksDateTime";
    public static final String SCHEDULED_AIRBORNE_DATETIME = "scheduledAirborneDateTime";
    public static final String SCHEDULED_LAND_DATETIME = "scheduledLandDateTime";
    /**
     * 计划离港时间
     */
    @Column(length = 6)
    private String scheduledOffBlocksDateTime;
    /**
     * 计划到港时间
     */
    @Column(length = 6)
    private String scheduledOnBlocksDateTime;
    /**
     * 计划起飞的时间
     */
    @Column(length = 6)
    private String scheduledAirborneDateTime;
    /**
     * 计划落地的时间
     */
    @Column(length = 6)
    private String scheduledLandDateTime;

    public String getScheduledOffBlocksDateTime() {
        return scheduledOffBlocksDateTime;
    }

    public void setScheduledOffBlocksDateTime(String scheduledOffBlocksDateTime) {
        this.scheduledOffBlocksDateTime = scheduledOffBlocksDateTime;
    }

    public String getScheduledOnBlocksDateTime() {
        return scheduledOnBlocksDateTime;
    }

    public void setScheduledOnBlocksDateTime(String scheduledOnBlocksDateTime) {
        this.scheduledOnBlocksDateTime = scheduledOnBlocksDateTime;
    }

    public String getScheduledAirborneDateTime() {
        return scheduledAirborneDateTime;
    }

    public void setScheduledAirborneDateTime(String scheduledAirborneDateTime) {
        this.scheduledAirborneDateTime = scheduledAirborneDateTime;
    }

    public String getScheduledLandDateTime() {
        return scheduledLandDateTime;
    }

    public void setScheduledLandDateTime(String scheduledLandDateTime) {
        this.scheduledLandDateTime = scheduledLandDateTime;
    }


}
