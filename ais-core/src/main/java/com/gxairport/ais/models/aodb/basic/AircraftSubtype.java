package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      AircraftSubtype.java
 * Description  TODO 飞机分类的实体类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

@Entity
@Table(name = "AircraftSubtype")
public class AircraftSubtype extends DefaultEntity {


    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String SUBTYPE_DESCRIPTION = "subtypeDescription";
    public static final String SUBTYPE_IATA_CODE = "subtypeIATACode";
    public static final String TYPE_IATA_CODE = "typeIATACode";
    public static final String TYPE_ICAO_CODE = "typeICAOCode";
    public static final String SETTLEMENT_CODE = "settlementCode";
    public static final String HEIGHT = "height";
    public static final String LENGTH = "length";
    public static final String WEIGHT = "weight";
    public static final String WIDTH = "width";
    public static final String PASSENGER_CAPACITY = "passengerCapacity";
    public static final String BUSINESS_CLASS_PASSENGER_CAPACITY = "businessClassPassengerCapacity";
    public static final String ECONOMY_CLASS_PASSENGER_CAPACITY = "economyClassPassengerCapacity";
    public static final String FIRST_CLASS_PASSENGER_CAPACITY = "firstClassPassengerCapacity";
    public static final String NEAR_BRIDGE_FLAG = "nearBridgeFlag";
    public static final String CLEARANCE_SECOND = "clearanceSecond";

    /**
     * 机型描述
     */
    @Column(length = 64)
    private String subtypeDescription;
    /**
     * IB定义的机型类别
     */

    @Column(length = 4)
    private String subtypeIATACode;
    /**
     * ITATA机型类别
     */
    @Column(length = 4)
    private String typeIATACode;
    /**
     * 民航统计系统的机型类别
     */
    @Column(length = 4)
    private String typeICAOCode;
    /**
     * 结算机型类别
     */
    @Id
    @Column(length = 15)
    private String settlementCode;

    /**
     * 高度
     */
    private Integer height;
    /**
     * 长度
     */
    private Integer length;
    /**
     * 重量
     */
    private Integer weight;
    /**
     * 宽度
     */
    private Integer width;
    /**
     * 座位数
     */
    private Integer passengerCapacity;
    /**
     * 公务舱数量
     */
    private Integer businessClassPassengerCapacity;
    /**
     * 经济舱数量
     */
    private Integer economyClassPassengerCapacity;
    /**
     * 头等舱数量
     */
    private Integer firstClassPassengerCapacity;
    /**
     * 靠桥标志
     */
    private boolean nearBridgeFlag;
    /**
     * 放行正常的毫秒数
     */
    private long clearanceSecond;

    public String getSubtypeDescription() {
        return subtypeDescription;
    }

    public void setSubtypeDescription(String subtypeDescription) {
        this.subtypeDescription = subtypeDescription;
    }

    public String getTypeIATACode() {
        return typeIATACode;
    }

    public void setTypeIATACode(String typeIATACode) {
        this.typeIATACode = typeIATACode;
    }

    public String getTypeICAOCode() {
        return typeICAOCode;
    }

    public void setTypeICAOCode(String typeICAOCode) {
        this.typeICAOCode = typeICAOCode;
    }

    public String getSettlementCode() {
        return settlementCode;
    }

    public void setSettlementCode(String settlementCode) {
        this.settlementCode = settlementCode;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getBusinessClassPassengerCapacity() {
        return businessClassPassengerCapacity;
    }

    public void setBusinessClassPassengerCapacity(Integer businessClassPassengerCapacity) {
        this.businessClassPassengerCapacity = businessClassPassengerCapacity;
    }

    public Integer getEconomyClassPassengerCapacity() {
        return economyClassPassengerCapacity;
    }

    public void setEconomyClassPassengerCapacity(Integer economyClassPassengerCapacity) {
        this.economyClassPassengerCapacity = economyClassPassengerCapacity;
    }

    public Integer getFirstClassPassengerCapacity() {
        return firstClassPassengerCapacity;
    }

    public void setFirstClassPassengerCapacity(Integer firstClassPassengerCapacity) {
        this.firstClassPassengerCapacity = firstClassPassengerCapacity;
    }

    public boolean isNearBridgeFlag() {
        return nearBridgeFlag;
    }

    public void setNearBridgeFlag(boolean nearBridgeFlag) {
        this.nearBridgeFlag = nearBridgeFlag;
    }

    public long getClearanceSecond() {
        return clearanceSecond;
    }

    public void setClearanceSecond(long clearanceSecond) {
        this.clearanceSecond = clearanceSecond;
    }

    public String getSubtypeIATACode() {
        return subtypeIATACode;
    }

    public void setSubtypeIATACode(String subtypeIATACode) {
        this.subtypeIATACode = subtypeIATACode;
    }

    @Override
    public Object getIdValue() {
        // TODO Auto-generated method stub
        return this.settlementCode;
    }


}
