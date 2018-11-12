package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.enums.aodb.SectorCode;
import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;

/**
 * FileName      Airport.java
 * Description  TODO 机场的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月13日      ZhangYu    1.0      create
 * Why  What is modified:
 */
@Entity
@Table(name = "Airport")
public class Airport extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String IATA_CODE = "IATACode";
    public static final String ICAO_CODE = "ICAOCode";
    public static final String ENGLISH_NAME = "englishName";
    public static final String CHINESE_NAME = "chineseName";
    public static final String SHORT_NAME = "shortName";
    public static final String SECTOR = "sector";
    public static final String DESCRIPTION = "description";
    public static final String MAXIMUM_SUBTYPE = "maximumSubtype";
    public static final String INTERVAL_DELAY_TIME = "intervalDelayTime";
    public static final String RECEIVE_ADDRESS_DEPARTURE = "receiveAddressDeparture";
    public static final String RECEIVE_ADDRESS_ARRIVAL = "receiveAddressArrival";
    public static final String RECEIVE_ADDRESS_PLAN = "receiveAddressPlan";
    public static final String RECEIVE_ADDRESS_EST = "receiveAddressEST";
    public static final String COUNTRY_CODE = "countryCode";
    public static final String COUNTRY_NAME = "CountryName";

    /**
     * 三字代码
     */
    @Id
    @Column(length = 10)
    private String IATACode;

    /**
     * 四字代码
     */
    @Column(length = 10)
    private String ICAOCode;

    /**
     * 英文名
     */
    @Column(length = 32)
    private String englishName;
    /**
     * 中文名
     */
    @Column(length = 64)
    private String chineseName;
    /**
     * 城市简写
     */
    @Column(length = 4)
    private String shortName;
    /**
     * 领域代码（国内,国外)
     */
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private SectorCode sectorCode;
    /**
     * 国家代码
     */
    @Column(length = 10)
    private String countryCode;
    /**
     * 国家名字
     */
    @Column(length = 32)
    private String CountryName;
    /**
     * 描述
     */
    @Column(length = 64)
    private String description;
    /**
     * 机场可起降最大机型
     */
    @ManyToOne
    @JoinColumn(name = "maximumSubtype")
    private AircraftSubtype maximumSubtype;
    /**
     * 延误判断时间
     */
    private int intervalDelayTime;

    /**
     * 起飞报收电地址 FPL相同
     */
    private String receiveAddressDeparture;

    /**
     * 落地报收电地址
     */
    private String receiveAddressArrival;

    /**
     * 计划报收电地址
     */
    private String receiveAddressPlan;

    /**
     * 飞越报的收电地址
     */
    private String receiveAddressEST;


    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }

    public String getICAOCode() {
        return ICAOCode;
    }

    public void setICAOCode(String ICAOCode) {
        this.ICAOCode = ICAOCode;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public SectorCode getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(SectorCode sector) {
        this.sectorCode = sector;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AircraftSubtype getMaximumSubtype() {
        return maximumSubtype;
    }

    public void setMaximumSubtype(AircraftSubtype maximumSubtype) {
        this.maximumSubtype = maximumSubtype;
    }

    public int getIntervalDelayTime() {
        return intervalDelayTime;
    }

    public void setIntervalDelayTime(int intervalDelayTime) {
        this.intervalDelayTime = intervalDelayTime;
    }

    public String getReceiveAddressDeparture() {
        return receiveAddressDeparture;
    }

    public void setReceiveAddressDeparture(String receiveAddressDeparture) {
        this.receiveAddressDeparture = receiveAddressDeparture;
    }

    public String getReceiveAddressArrival() {
        return receiveAddressArrival;
    }

    public void setReceiveAddressArrival(String receiveAddressArrival) {
        this.receiveAddressArrival = receiveAddressArrival;
    }

    public String getReceiveAddressPlan() {
        return receiveAddressPlan;
    }

    public void setReceiveAddressPlan(String receiveAddressPlan) {
        this.receiveAddressPlan = receiveAddressPlan;
    }

    public String getReceiveAddressEST() {
        return receiveAddressEST;
    }

    public void setReceiveAddressEST(String receiveAddressEST) {
        this.receiveAddressEST = receiveAddressEST;
    }

    @Override
    public Object getIdValue() {

        return this.IATACode;
    }


}
