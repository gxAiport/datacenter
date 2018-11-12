package com.gxairport.ais.enums.aodb;


/**
 * FileName      Sex.java
 * Description  TODO 性别枚举值
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月12日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月12日      ZhangYu    1.0     create
 * Why  What is modified:
 */

public enum Sex {

    /**
     * 男
     */
    MALE("Male"),

    /**
     * 女
     */
    FEMALE("Female");

    private final String value;

    Sex(String value) {
        this.value = value;
    }

    public static Sex fromValue(String v) {
        for (Sex u : Sex.values()) {
            if (u.value.equals(v)) {
                return u;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
