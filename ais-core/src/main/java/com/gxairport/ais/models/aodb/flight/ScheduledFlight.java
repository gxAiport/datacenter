package com.gxairport.ais.models.aodb.flight;

import com.gxairport.ais.models.aodb.flight.collection.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * FileName      ScheduledFlight.java
 * Description  TODO 航班计划实体类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2017年6月20日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月20日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */
@Entity
@Table(name = "Scheduled_Flight")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_ScheduledFlight", allocationSize = 1)
public class ScheduledFlight extends BasicFlight {


    /*
     * Description  机场数据的静态类，与机场相关的数据集合
     * -----------------------------------------------------------------------------------------------------------------
     */

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "scheduled_Flight_id")
    private Set<ScheduledBaggageMakeupPosition> baggageMakeupPositions;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "scheduled_Flight_id")
    private Set<ScheduledBaggageReclaimCarousel> baggageReclaimCarousels;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "scheduled_Flight_id")
    private Set<ScheduledCheckIn> checkIns;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "scheduled_Flight_id")
    private Set<ScheduledGate> gates;

    @Override
    public Set<ScheduledBaggageMakeupPosition> getBaggageMakeupPositions() {
        if (baggageMakeupPositions == null) {
            baggageMakeupPositions = new HashSet<>();
        }
        return this.baggageMakeupPositions;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void setBaggageMakeupPositions(Set baggageMakeupPositions) {
        this.baggageMakeupPositions = baggageMakeupPositions;
    }

    @Override
    public Set<ScheduledBaggageReclaimCarousel> getBaggageReclaimCarousels() {
        if (baggageReclaimCarousels == null) {
            baggageReclaimCarousels = new HashSet<>();
        }
        return this.baggageReclaimCarousels;
    }


    @SuppressWarnings({"unchecked"})
    @Override
    public void setBaggageReclaimCarousels(Set baggageReclaimCarousels) {
        this.baggageReclaimCarousels = baggageReclaimCarousels;
    }


    @Override
    public Set<ScheduledCheckIn> getCheckIns() {
        if (checkIns == null) {
            checkIns = new HashSet<>();
        }
        return this.checkIns;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void setCheckIns(Set checkIns) {
        this.checkIns = checkIns;
    }

    @Override
    public Set<ScheduledGate> getGates() {
        if (gates == null) {
            gates = new HashSet<>();
        }
        return this.gates;
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
    @JoinColumn(name = "scheduled_Flight_id")
    private Set<ScheduledShareFlight> shareFlights;

    @Override
    public Set<ScheduledShareFlight> getShareFlights() {
        if (shareFlights == null) {
            shareFlights = new HashSet<>();
        }
        return this.shareFlights;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void setShareFlights(Set shareFlights) {
        this.shareFlights = shareFlights;
    }






    /*
     * Description  航线数据的静态类，与航线数据相关的数据集合
     * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "scheduled_Flight_id")
    private Set<ScheduledStop> stops;


    @Override
    public Set<ScheduledStop> getStops() {
        if (stops == null) {
            stops = new HashSet<>();
        }
        return this.stops;
    }


    @SuppressWarnings({"unchecked"})
    @Override
    public void setStops(Set stops) {
        this.stops = stops;
    }

    /**
     * 航班时间相关的静态类，所有操作时间的集合
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
