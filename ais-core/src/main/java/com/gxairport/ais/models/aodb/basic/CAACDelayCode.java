package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;


/**
 * FileName      CAACDelayCode.java
 * Description  TODO 延误代码
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月13日      ZhangYu    1.0     create
 * Why  What is modified:
 */

@Entity
@Table(name = "CAACDelayCode")
public class CAACDelayCode extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String DELAY_CODE = "delayCode";
    public static final String ENGLISH_DESCRIPTION = "englishDescription";
    public static final String CHINESE_DESCRIPTION = "chineseDescription";
    public static final String CAAC_DELAY_CATEGORY = "caacDelayCategory";

    /**
     * 延误代码
     */
    @Id
    @Column(length = 4)
    private String delayCode;
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

    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private CAACDelayCategory caacDelayCategory;

    public String getDelayCode() {
        return delayCode;
    }

    public void setDelayCode(String delayCode) {
        this.delayCode = delayCode;
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

    public CAACDelayCategory getCaacDelayCategory() {
        return caacDelayCategory;
    }

    public void setCaacDelayCategory(CAACDelayCategory caacDelayCategory) {
        this.caacDelayCategory = caacDelayCategory;
    }

    @Override
    public Object getIdValue() {
        return this.delayCode;
    }


}
