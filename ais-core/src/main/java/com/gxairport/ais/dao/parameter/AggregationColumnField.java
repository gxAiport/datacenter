package com.gxairport.ais.dao.parameter;


import com.gxairport.ais.enums.AggregationFieldType;

import javax.persistence.Transient;


/**
 * FileName      AggregationColumnField.java
 * Description  TODO 聚合列字段，用来定义需要对数据分组的字段，实际上去查询数据的字段
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月22日      ZhangYu    1.0    create
 * Why  What is modified:
 */

public class AggregationColumnField extends ColumnField {

    private static final long serialVersionUID = 1L;

    public static String AGGREGATION_TYPE = "aggregationType";

    public static String COMPARE = "compare";

    public static String WHEN_CONDITION = "whenCondition";

    /**
     * 聚合的类型
     */
    private AggregationFieldType aggregationType;
    /**
     * 比较标志，选定日期年+Compare的值
     */
    private boolean compare;

    /**
     * 聚合条件
     */
    @Transient
    private Object[] whenCondition;


    /**
     * @return the aggregationType
     */
    public AggregationFieldType getAggregationType() {
        return aggregationType;
    }

    /**
     * @param aggregationType the aggregationType to set
     */
    public void setAggregationType(AggregationFieldType aggregationType) {
        this.aggregationType = aggregationType;

    }

    /**
     * @return 比较的结果
     */
    public boolean getCompare() {
        return compare;
    }

    /**
     * @param compare the compare to set
     */
    public void setCompare(boolean compare) {
        this.compare = compare;
    }

    /**
     * @return the whenCondition
     */
    public Object[] getWhenCondition() {
        return whenCondition;
    }

    /**
     * @param whenCondition the whenCondition to set
     */
    public void setWhenCondition(Object[] whenCondition) {
        this.whenCondition = whenCondition;
    }


}
