package com.gxairport.ais.enums;

/**
 * FileName      ViewColumnType.java
 * Description  TODO 视图列对象的类型种类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月27日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月27日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

public enum ViewColumnType {

    /**
     * 动态字段
     */
    Dyniamic,
    /**
     * 枚举字段
     */
    Enum,
    /**
     * 数据增长字段
     */
    Number,
    /**
     * 静态字段
     */
    Static;

    public String value() {
        return name();
    }

    public static ViewColumnType fromValue(String v) {
        return valueOf(v);
    }


}
