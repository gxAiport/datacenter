package com.gxairport.ais.enums;

/**
 * FileName      AggregationFieldType.java
 * Description  TODO 聚合字段枚举类型
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

public enum AggregationFieldType {

    /**
     * 平均
     */
    Avg,

    /**
     * 累计
     */
    Count,

    /**
     * 空
     */
    None,

    /**
     * 求和
     */
    Sum;

    public String value() {
        return name();
    }


    public static AggregationFieldType fromValue(String v) {

        return valueOf(v);
    }
}
