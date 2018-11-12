package com.gxairport.ais.enums.aodb;


/**
 * FileName      GateBoardingStatus.java
 * Description  TODO 登机口登机状态的枚举类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月18日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月18日      ZhangYu    1.0     create
 * Why  What is modified:
 */

public enum GateBoardingStatus {

    /**
     * Attended,显示在航显屏幕
     */
    A,
    /**
     * Boarding,正在登机
     */
    B,
    /**
     * Close，登机结束
     */
    C,
    /**
     * Last Call，最后一次登机广播
     */
    L,
    /**
     * Open,开始登机
     */
    O;

    public String value() {
        return name();
    }

    public static GateBoardingStatus fromValue(String v) {
        return valueOf(v);
    }

}
