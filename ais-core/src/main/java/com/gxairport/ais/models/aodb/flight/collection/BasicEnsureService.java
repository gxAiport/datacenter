package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.models.IntIdEntity;
import com.gxairport.ais.models.aodb.basic.EnsureItem;
import com.gxairport.ais.models.aodb.flight.BasicFlight;
import com.gxairport.ais.models.aodb.flight.DynamicFlight;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * FileName      DynamicFlight.java
 * Description  TODO  保障服务类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年9月28日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年9月28日      ZhangYu    1.0    create
 * Why  What is modified:
 */


@MappedSuperclass
public abstract class BasicEnsureService extends IntIdEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String ITEM = "item";
    public static final String PLAN_START_TIME = "planStartTime";
    public static final String PLAN_END_TIME = "planEndTime";
    public static final String ACTUAL_START_TIME = "actualStartTime";
    public static final String ACTUAL_END_TIME = "actualEndTime";
    public static final String NUMBER_OF_TIMES = "numberOfTimes";
    public static final String FLIGHT = "flight";

    @ManyToOne
    @JoinColumn(name = "ensureCode")
    private EnsureItem item;

    private Date planStartTime;

    private Date planEndTime;

    private Date actualStartTime;

    private Date actualEndTime;

    private Integer numberOfTimes;


    public EnsureItem getItem() {
        return item;
    }

    public void setItem(EnsureItem item) {
        this.item = item;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public Integer getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(Integer numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }
}
