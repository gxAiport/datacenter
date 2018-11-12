package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.enums.aodb.SectorCode;
import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;


/**
 * FileName      Airline.java
 * Description  TODO 航空公司的实体类
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
@Table(name = "Airline")
public class Airline extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String IATA_CODE = "IATACode";
    public static final String ICAO_CODE = "ICAOCode";
    public static final String DESCRIPTION = "description";
    public static final String ENGLISH_NAME = "englishName";
    public static final String CHINESE_NAME = "chineseName";
    public static final String SECTOR = "sector";
    public static final String RECEIVE_ADDRESS = "receiveAddress";


    /**
     * 两字代码
     */

    @Column(length = 10)
    private String IATACode;
    /**
     * 三字代码
     */
    @Id
    @Column(length = 10)
    private String ICAOCode;
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
     * 航空公司领域
     */
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private SectorCode sectorCode;
    /**
     * 接收地址，用于空管系统
     */
    @Column(length = 128)
    private String receiveAddress;


    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String iATACode) {
        IATACode = iATACode;
    }

    public String getICAOCode() {
        return ICAOCode;
    }

    public void setICAOCode(String iCAOCode) {
        ICAOCode = iCAOCode;
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

    public SectorCode getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(SectorCode sector) {
        this.sectorCode = sector;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }


    @Override
    public Object getIdValue() {
        return this.IATACode;
    }


}
