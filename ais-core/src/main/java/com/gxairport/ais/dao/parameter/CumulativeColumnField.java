package com.gxairport.ais.dao.parameter;

import com.gxairport.ais.enums.CumulativeDateType;

/**
 * FileName      CumulativeColumnField.java
 * Description  TODO 用于累计计算的列字段
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version       Description
 * ---------------------------------------------
 * 2017年6月22日      ZhangYu    1.0    create
 * Why  What is modified:
 */


public class CumulativeColumnField extends ColumnField {

    private static final long serialVersionUID = 1L;

    /**
     * 需要进行累计字段数据
     */
    private AggregationColumnField aggregationColumnField;


    /**
     * 限定的年份
     */
    private String year;

    /**
     * 对比标志
     */
    private boolean compare;

    /**
     * 累计日期类型(年，月，日)
     */
    private CumulativeDateType cumulativeDateType;

    public AggregationColumnField getAggregationColumnField() {
        return aggregationColumnField;
    }

    public void setAggregationColumnField(AggregationColumnField aggregationColumnField) {
        this.aggregationColumnField = aggregationColumnField;
    }

    public Boolean getCompare() {
        return compare;
    }

    public void setCompare(Boolean compare) {
        this.compare = compare;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public CumulativeDateType getCumulativeDateType() {
        return cumulativeDateType;
    }

    public void setCumulativeDateType(CumulativeDateType cumulativeDateType) {
        this.cumulativeDateType = cumulativeDateType;
    }


}
