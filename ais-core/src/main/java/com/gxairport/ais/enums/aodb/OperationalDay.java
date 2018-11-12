package com.gxairport.ais.enums.aodb;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * FileName      OperationalDay.java
 * Description  TODO 航班运营日的枚举类型
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月19日
 * ModificationHistory
 * Date         Author     Version      Description
 * ---------------------------------------------
 * 2017年6月19日      ZhangYu    1.0       create
 * Why  What is modified:
 */

public enum OperationalDay {

    @XmlEnumValue("Monday")
    MONDAY("Monday"),

    @XmlEnumValue("Tuesday")
    TUESDAY("Tuesday"),

    @XmlEnumValue("Wednesday")
    WEDNESDAY("Wednesday"),

    @XmlEnumValue("Thursday")
    THURSDAY("Thursday"),

    @XmlEnumValue("Friday")
    FRIDAY("Friday"),

    @XmlEnumValue("Saturday")
    SATURDAY("Saturday"),

    @XmlEnumValue("Sunday")
    SUNDAY("Sunday");

    private final String value;

    OperationalDay(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperationalDay fromValue(String v) {
        for (OperationalDay c : OperationalDay.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
