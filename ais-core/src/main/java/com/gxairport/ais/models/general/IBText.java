package com.gxairport.ais.models.general;

import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.*;

/**
 * FileName      IBText.java
 * Description  TODO  IB信息对照表
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年7月11日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年7月11日      ZhangYu    1.0       create
 * Why  What is modified:
 */

@Entity
@Table(name = "IbText")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_IbTxt", allocationSize = 1)
public class IBText extends IntIdEntity {


    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String TEXT_CATEGORY_CODE = "textCategoryCode";
    public static final String TEXT_CODE = "textCode";
    public static final String CHINESE_LANGUAGE_TEXT = "chineseLanguageText";
    public static final String ENGLISH_LANGUAGE_TEXT = "englishLanguageText";


    /**
     * 代码种类
     */
    @Column(length = 10)
    private String textCategoryCode;
    /**
     * 代码
     */
    @Column(length = 10)
    private String textCode;
    /**
     * 中文描述
     */
    @Column(length = 128)
    private String chineseLanguageText;
    /**
     * 英文描述
     */
    @Column(length = 128)
    private String englishLanguageText;

    public String getTextCategoryCode() {
        return textCategoryCode;
    }

    public void setTextCategoryCode(String textCategoryCode) {
        this.textCategoryCode = textCategoryCode;
    }

    public String getTextCode() {
        return textCode;
    }

    public void setTextCode(String textCode) {
        this.textCode = textCode;
    }

    public String getChineseLanguageText() {
        return chineseLanguageText;
    }

    public void setChineseLanguageText(String chineseLanguageText) {
        this.chineseLanguageText = chineseLanguageText;
    }

    public String getEnglishLanguageText() {
        return englishLanguageText;
    }

    public void setEnglishLanguageText(String englishLanguageText) {
        this.englishLanguageText = englishLanguageText;
    }


}
