package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;

/**
 * FileName      Carrier.java
 * Description  TODO 承运人实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0    create
 * <p>Why  What is modified:
 */
@Entity
@Table(name = "Carrier")
public class Carrier extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CARRIER_CODE = "carrierCode";
    public static final String SETTLEMENT_OWNER_CODE = "settlementOwnerCode";
    public static final String SETTLEMENT_PAY_CODE = "settlementPayCode";
    public static final String ENGLISH_NAME = "englishName";
    public static final String CHINESE_NAME = "chineseName";
    public static final String DESCRIPTION = "description";
    public static final String AIRLINE = "airline";
    public static final String FLIGHT_SERVICE_TYPE = "flightServiceType";
    public static final String CARGO_CHECK = "cargoCheck";

    /**
     * 承运人代码
     */
    @Id
    @Column(length = 3)
    private String carrierCode;
    /**
     * 结算代码，结算收入用
     */
    @Column(length = 3)
    private String settlementOwnerCode;

    /**
     * 付款代码，结算收入用
     */
    @Column(length = 5)
    private String settlementPayCode;
    /**
     * 航空公司英文名字
     */
    @Column(length = 32)
    private String englishName;
    /**
     * 航空公司中文名字
     */
    @Column(length = 32)
    private String chineseName;
    /**
     * 描述
     */
    @Column(length = 128)
    private String description;
    /**
     * 所属航空公司
     */
    @ManyToOne
    @JoinColumn(name = "airlineICAOCode")
    private Airline airline;
    /**
     * 服务类型
     */
    @ManyToOne
    @JoinColumn(name = "serviceTypeIATACode")
    private FlightServiceType flightServiceType;
    /**
     * 货物判断标志，结算收入用
     */
    private boolean cargoCheck;

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getSettlementOwnerCode() {
        return settlementOwnerCode;
    }

    public void setSettlementOwnerCode(String settlementOwnerCode) {
        this.settlementOwnerCode = settlementOwnerCode;
    }

    public String getSettlementPayCode() {
        return settlementPayCode;
    }

    public void setSettlementPayCode(String settlementPayCode) {
        this.settlementPayCode = settlementPayCode;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public FlightServiceType getFlightServiceType() {
        return flightServiceType;
    }

    public void setFlightServiceType(FlightServiceType flightServiceType) {
        this.flightServiceType = flightServiceType;
    }

    public boolean isCargoCheck() {
        return cargoCheck;
    }

    public void setCargoCheck(boolean cargoCheck) {
        this.cargoCheck = cargoCheck;
    }


    @Override
    public Object getIdValue() {
        // TODO Auto-generated method stub
        return this.carrierCode;
    }

}
