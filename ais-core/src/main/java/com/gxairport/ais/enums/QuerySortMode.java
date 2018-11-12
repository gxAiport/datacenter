package com.gxairport.ais.enums;

/**
 * FileName      QuerySortMode.java
 * Description  TODO 排序的枚举类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

public enum QuerySortMode {

    /**
     * 升序
     */
    ASC,

    /**
     * 降序
     */
    DESC;


    public String value() {
        return name();
    }

    public static QuerySortMode fromValue(String v) {
        return valueOf(v);
    }
}
