package com.gxairport.ais.enums.aodb;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * FileName      FlightDirection.java
 * Description  TODO 航班进出港代码
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月17日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月17日      ZhangYu    1.0    create
 * Why  What is modified:
 */
public enum FlightDirection {

    /**
     * 进港
     */
    @XmlEnumValue("Arrival")
    ARRIVAL("Arrival"),

    /**
     * 出港
     */
    @XmlEnumValue("Departure")
    DEPARTURE("Departure");
    private final String value;

    FlightDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FlightDirection fromValue(String v) {
        for (FlightDirection c : FlightDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
