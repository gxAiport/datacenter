package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;


/**
 * FileName      FlightServiceType.java
 * Description  TODO 服务类型的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月14日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月14日      ZhangYu    1.0    create
 * <p>Why  What is modified:
 */

@Entity
@Table(name = "FlightServiceType")
public class FlightServiceType extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String SERVICE_TYPE_IATA_CODE = "serviceTypeIATACode";
    public static final String ENGLISH_DESCRIPTION = "englishDescription";
    public static final String CHINESE_DESCRIPTION = "chineseDescription";
    public static final String FLIGHT_NATURE = "flightNature";
    /**
     * IATA代码
     */
    @Id
    @Column(length = 1)
    private String serviceTypeIATACode;
    /**
     * 英文描述
     */
    @Column(length = 32)
    private String englishDescription;
    /**
     * 中文描述
     */
    @Column(length = 32)
    private String chineseDescription;
    /**
     * 航班性质代码
     */
    @ManyToOne
    @JoinColumn(name = "natureCode")
    private FlightNature flightNature;

    public String getServiceTypeIATACode() {
        return serviceTypeIATACode;
    }

    public void setServiceTypeIATACode(String serviceTypeIATACode) {
        this.serviceTypeIATACode = serviceTypeIATACode;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public String getChineseDescription() {
        return chineseDescription;
    }

    public void setChineseDescription(String chineseDescription) {
        this.chineseDescription = chineseDescription;
    }

    public FlightNature getFlightNature() {
        return flightNature;
    }

    public void setFlightNature(FlightNature flightNature) {
        this.flightNature = flightNature;
    }

    @Override
    public Object getIdValue() {
        return this.serviceTypeIATACode;
    }

}
