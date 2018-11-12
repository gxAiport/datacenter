package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;

/**
 * FileName      FlightClassification.java
 * Description  TODO 航班分类的实体类
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
@Table(name = "FlightClassification")
public class FlightClassification extends DefaultEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CLASSIFICATION_CODE = "classificationCode";
    public static final String ENGLISH_DESCRIPTION = "englishDescription";
    public static final String CHINESE_DESCRIPTION = "chineseDescription";
    public static final String FLIGHT_SERVICE_TYPE = "flightServiceType";

    /**
     * 分类代码
     */
    @Id
    @Column(length = 3)
    private String classificationCode;
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
     * 航班服务类型
     */
    @ManyToOne
    @JoinColumn(name = "serviceTypeIATACode")
    private FlightServiceType flightServiceType;

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
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

    public FlightServiceType getFlightServiceType() {
        return flightServiceType;
    }

    public void setFlightServiceType(FlightServiceType flightServiceType) {
        this.flightServiceType = flightServiceType;
    }


    @Override
    public Object getIdValue() {
        return this.classificationCode;
    }


}
