package com.gxairport.ais.dao.parameter;


import com.gxairport.ais.enums.SummaryType;

/**
 * FileName      SummaryField.java
 * Description  TODO 用于显示汇总的字段
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年10月11日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年10月11日      ZhangYu    1.0     create
 * Why  What is modified:
 */
public class SummaryField {

    /**
     * 数据Key值
     */
    private String dataIndex;
    /**
     * 表达式
     */
    private Object[] expression;
    /**
     * 数据的标题
     */
    private String text;
    /**
     * 合计的类型
     */
    private SummaryType summaryType;

    public String getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SummaryType getSummaryType() {
        return summaryType;
    }

    public void setSummaryType(SummaryType summaryType) {
        this.summaryType = summaryType;
    }

    public Object[] getExpression() {
        return expression;
    }

    public void setExpression(Object[] expression) {
        this.expression = expression;
    }


}
