package com.gxairport.ais.models.aodb.basic;


import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * FileName      Aiscraft.java
 * Description  TODO 飞机注册信息的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月13日      ZhangYu    1.0     create
 * Why  What is modified:
 */


@Entity
@Table(name = "Aircraft")
public class Aircraft extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String REGISTRATION = "registration";
    public static final String REGISTRATION_DESCRIPTION = "registrationDescription";
    public static final String CARRIER = "carrier";
    public static final String AIRCRAFT_SUBTYPE = "aircraftSubtype";
    public static final String PASSENGER_CAPACITY = "passengerCapacity";
    public static final String AIRCRAFT_NOSE_NUMBER = "aircraftNoseNumber";
    public static final String SETTLEMENT_WEIGHT = "settlementWeight";
    public static final String SETTLEMENT_LOAD = "settlementPayload";
    public static final String MAXIMUM_PAYLOAD = "maximumPayload";
    public static final String MAXIMUM_PASSENGER_CAPACITY = "maximumPassengerCapacity";
    public static final String AVAILABLE_PAYLOAD = "availablePayload";
    public static final String AVAILABLE_PASSENGER_CAPACITY = "availablePassengerCapacity";
    public static final String EQUIPMENT = "equipment";
    public static final String CALL_SIGN = "callSign";
    public static final String STAR_USE_TIME = "startUseTime";
    public static final String STOP_USE_TIME = "stopUseTime";
    public static final String AGE = "age";

    /**
     * 飞机注册号
     */
    @Id
    @Column(length = 15)
    private String registration;
    /**
     * 飞机注册号的描述
     */
    @Column(length = 64)
    private String registrationDescription;
    /**
     * 归属承运人
     */
    @ManyToOne
    @JoinColumn(name = "carrierCode")
    private Carrier carrier;
    /**
     * 机型
     */
    @ManyToOne
    @JoinColumn(name = "craftType")
    private AircraftSubtype aircraftSubtype;
    /**
     * 飞机座位数
     */
    private Integer passengerCapacity;
    /**
     * 飞机噪声数值
     */
    private String aircraftNoseNumber;
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

    /**
     * 机载设备，用于空管系统
     */
    private String equipment;
    /**
     * 呼号，用于空管系统
     */
    private String callSign;
    /**
     * 开始使用时间，用于更新清算飞机数据用
     */
    private Date startUseTime;
    /**
     * 停止使用时间，用于更新清算飞机数据用
     */
    private Date stopUseTime;

    /**
     * 机龄
     */
    private String age;


    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getRegistrationDescription() {
        return registrationDescription;
    }

    public void setRegistrationDescription(String registrationDescription) {
        this.registrationDescription = registrationDescription;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public AircraftSubtype getAircraftSubtype() {
        return aircraftSubtype;
    }

    public void setAircraftSubtype(AircraftSubtype aircraftSubtype) {
        this.aircraftSubtype = aircraftSubtype;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getAircraftNoseNumber() {
        return aircraftNoseNumber;
    }

    public void setAircraftNoseNumber(String aircraftNoseNumber) {
        this.aircraftNoseNumber = aircraftNoseNumber;
    }


    public Integer getSettlementWeight() {
        return settlementWeight;
    }

    public void setSettlementWeight(Integer settlementWeight) {
        this.settlementWeight = settlementWeight;
    }

    public Integer getMaximumPayload() {
        return maximumPayload;
    }

    public void setMaximumPayload(Integer maximumPayload) {
        this.maximumPayload = maximumPayload;
    }

    public Integer getSettlementPayload() {
        return settlementPayload;
    }

    public void setSettlementPayload(Integer settlementPayload) {
        this.settlementPayload = settlementPayload;
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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String call_sign) {
        this.callSign = call_sign;
    }

    public Date getStartUseTime() {
        return startUseTime;
    }

    public void setStartUseTime(Date startUseTime) {
        this.startUseTime = startUseTime;
    }

    public Date getStopUseTime() {
        return stopUseTime;
    }

    public void setStopUseTime(Date stopUseTime) {
        this.stopUseTime = stopUseTime;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public Object getIdValue() {
        return this.registration;
    }

}
