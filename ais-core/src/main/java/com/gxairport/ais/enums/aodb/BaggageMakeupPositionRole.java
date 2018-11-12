


package com.gxairport.ais.enums.aodb;

import javax.xml.bind.annotation.XmlEnumValue;


/**
 * FileName      BaggageMakeupPositionRole.java
 * Description  TODO 装载转盘规则,
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月17日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */
public enum BaggageMakeupPositionRole {

    @XmlEnumValue("Primary")
    PRIMARY("Primary"),

    @XmlEnumValue("Secondary")
    SECONDARY("Secondary");

    private final String value;

    BaggageMakeupPositionRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BaggageMakeupPositionRole fromValue(String v) {
        for (BaggageMakeupPositionRole c : BaggageMakeupPositionRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
