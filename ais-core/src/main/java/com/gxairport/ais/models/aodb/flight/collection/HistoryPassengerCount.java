package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * TypeName PassagerLabelCount
 * Description  旅客标签统计数据实体类
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018年9月4日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

public class HistoryPassengerCount extends IntIdEntity {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CONDITION = "condition";
    public static final String VALUE = "value";

    /**
     * 标签的条件
     */
    @Column(length = 64)
    private String condition;

    /**
     * 标签的值
     */
    private int value;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String labCondition) {
        this.condition = labCondition;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
