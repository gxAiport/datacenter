package com.gxairport.ais.enums.aodb;

/**
 * FileName      IDType.java
 * Description  TODO 证件类型 的枚举类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2018年9月4日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2018年9月4日      ZhangYu    1.0     create
 * Why  What is modified:
 */

public enum IDCardType {
    /**
     * 身份证
     */
    NATIONAL("National"),
    /**
     * 护照
     */
    PASSPORT("Passport"),
    /**
     * 军官证
     */
    MILITARY("Military"),
    /**
     * 工作证
     */
    EMPLOYEE("Employee"),
    /**
     * 驾驶证
     */
    DRIVER("Driver"),
    /**
     * 学生证
     */
    STUDENT("Student");

    private final String value;

    IDCardType(String value) {
        this.value = value;
    }

    public static IDCardType fromValue(String v) {
        for (IDCardType u : IDCardType.values()) {
            if (u.value.equals(v)) {
                return u;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
