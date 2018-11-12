package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      CAACDelayCategory.java
 * Description  TODO 延误类别的实体类
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
@Table(name = "CAACDelayCategory")
public class CAACDelayCategory extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CATEGORY_CODE = "categoryCode";
    public static final String ENGLISH_DESCRIPTION = "englishDescription";
    public static final String CHINESE_DESCRIPTION = "chineseDescription";


    /**
     * 延误代码
     */
    @Id
    @Column(length = 4)
    private String categoryCode;
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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
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
        return this.categoryCode;
    }

}
