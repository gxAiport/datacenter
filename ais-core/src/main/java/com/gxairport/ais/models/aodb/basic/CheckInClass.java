package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      CheckInClass.java
 * Description  TODO 值机等级的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0     create
 * <p>Why  What is modified:
 */

@Entity
@Table(name = "CheckInClass")
public class CheckInClass extends DefaultEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CLASS_CODE = "classCode";
    public static final String ENGLISH_DESCRIPTION = "englishDescription";
    public static final String CHINESE_DESCRIPTION = "chineseDescription";

    /**
     * 值机等级代码
     */
    @Id
    @Column(length = 1)
    private String classCode;
    /**
     * 英文描述
     */
    @Column(length = 128)
    private String englishDescription;
    /**
     * 中文描述
     */
    @Column(length = 128)
    private String chineseDescription;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
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

        return this.classCode;
    }

}
