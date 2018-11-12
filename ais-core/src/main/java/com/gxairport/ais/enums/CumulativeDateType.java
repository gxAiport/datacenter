package com.gxairport.ais.enums;


/**
 * FileName      CumulativeDateType.java
 * Description  TODO 累计日期类型的枚举类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年10月8日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        create
 * <p>Why  What is modified:
 */

public enum CumulativeDateType {

    day,

    month,

    year;

    public String value() {
        return name();
    }

    public static CumulativeDateType fromValue(String v) {
        return valueOf(v);
    }
}
