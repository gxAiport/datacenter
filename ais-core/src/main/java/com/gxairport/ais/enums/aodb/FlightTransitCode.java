package com.gxairport.ais.enums.aodb;

/**
 * FileName      FlightTransitCode.java
 * Description  TODO 飞机的经停代码
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月12日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月12日      ZhangYu    1.0    create
 * Why  What is modified:
 */


public enum FlightTransitCode {
    /**
     * 技术性经停
     */
    T,
    /**
     * 一般经停
     */
    Y;

    public String value() {
        return name();
    }

    public static FlightTransitCode fromValue(String v) {
        return valueOf(v);
    }

}