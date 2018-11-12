package com.gxairport.ais.enums.aodb;

/**
 * FileName      PassengerCardLevel.java
 * Description  TODO  常旅客卡等级
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月18日
 * ModificationHistory
 * Date         Author     Version        Description
 * ---------------------------------------------
 * 2017年6月18日      ZhangYu    1.0     create
 * Why  What is modified:
 */

public enum PassengerCardLevel {
    /**
     * 金卡
     */
    GOLD("Gold"),
    /**
     * 银卡
     */
    SILVER("Silver"),
    /**
     * 头等舱
     */
    FIRST_CLASS("FirstClass");

    private final String value;

    PassengerCardLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PassengerCardLevel fromValue(String v) {
        for (PassengerCardLevel c : PassengerCardLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
