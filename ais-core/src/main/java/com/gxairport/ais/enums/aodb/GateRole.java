package com.gxairport.ais.enums.aodb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * FileName      GateRole.java
 * Description  TODO 登机口规则的枚举类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2018年9月4日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2018年9月4日      ZhangYu    1.0        create
 * Why  What is modified:
 */

@XmlType(name = "GateRole")
@XmlEnum
public enum GateRole {

    @XmlEnumValue("Primary")
    PRIMARY("Primary"),

    @XmlEnumValue("Secondary")
    SECONDARY("Secondary");

    private final String value;

    GateRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GateRole fromValue(String v) {
        for (GateRole c : GateRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
