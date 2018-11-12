


package com.gxairport.ais.enums.aodb;

import javax.xml.bind.annotation.XmlEnumValue;


/**
 * FileName      BaggageReclaimCarouselRole.java
 * Description  TODO  行李转盘规则
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月17日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

public enum BaggageReclaimCarouselRole {

    @XmlEnumValue("Primary")
    PRIMARY("Primary"),

    @XmlEnumValue("Secondary")
    SECONDARY("Secondary");

    private final String value;

    BaggageReclaimCarouselRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BaggageReclaimCarouselRole fromValue(String v) {
        for (BaggageReclaimCarouselRole c : BaggageReclaimCarouselRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
