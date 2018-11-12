package com.gxairport.ais.enums.aodb;

import javax.xml.bind.annotation.XmlEnumValue;


/**
 * FileName      CheckInRole.java
 * Description  TODO  值机规则
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2017年6月17日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月17日      ZhangYu    1.0   create
 * Why  What is modified:
 */

public enum CheckInRole {

    @XmlEnumValue("Primary")
    PRIMARY("Primary"),

    @XmlEnumValue("Secondary")
    SECONDARY("Secondary");

    private final String value;

    CheckInRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CheckInRole fromValue(String v) {
        for (CheckInRole c : CheckInRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
