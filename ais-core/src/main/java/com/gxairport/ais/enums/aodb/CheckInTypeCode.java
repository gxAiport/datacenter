package com.gxairport.ais.enums.aodb;

/**
 * FileName      CheckInTypeCode.java
 * Description   TODO 值机类型代码
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

public enum CheckInTypeCode {
    /**
     * common    通用
     */
    C,
    /**
     * dedicated 专用
     */
    D;

    public String value() {
        return name();
    }

    public static CheckInTypeCode fromValue(String v) {
        return valueOf(v);
    }

}
