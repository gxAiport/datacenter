package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      FlightNature.java
 * Description  TODO 航班性质的实体类
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
@Table(name = "FlightNature")
public class FlightNature extends DefaultEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String NATURE_CODE = "natureCode";
    public static final String ENGLISH_DESCRIPTION = "englishDescription";
    public static final String CHINESE_DESCRIPTION = "chineseDescription";
    /**
     * 航班性质
     */
    @Id
    @Column(length = 3)
    private String natureCode;
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

    public String getNatureCode() {
        return natureCode;
    }

    public void setNatureCode(String natureCode) {
        this.natureCode = natureCode;
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

    @Override
    public Object getIdValue() {
        // TODO Auto-generated method stub
        return this.natureCode;
    }


}
