package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      FlightCode.java
 * Description  TODO 航班代码
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年7月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月22日      ZhangYu    1.0    create
 * <p>Why  What is modified:
 */

@Entity
@Table(name = "FlightCode")
public class FlightCode extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final String CODE = "code";
    public static final String ENGLISH_DESCRIPTION = "englishDescription";
    public static final String CHINESE_DESCRIPTION = "chineseDescription";
    /**
     * 航班性质
     */
    @Id
    @Column(length = 3)
    private String code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return this.code;
    }

}
