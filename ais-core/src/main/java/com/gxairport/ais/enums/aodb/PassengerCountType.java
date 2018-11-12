package com.gxairport.ais.enums.aodb;

/**
 * FileName      PassengerCardLevel.java
 * Description  TODO  旅客统计类型
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月18日
 * ModificationHistory
 * Date         Author     Version        Description
 * ---------------------------------------------
 * 2017年6月18日      ZhangYu    1.0     create
 * Why  What is modified:
 */

public enum PassengerCountType {

    /**
     * 年龄：30岁
     */
    AGE("Age"),
    /**
     * 性别：男，女
     */
    SEX("Sex"),
    /**
     * 座位等级：头等，商务，经济
     */
    SEAT_CLASS("SeatClass"),
    /**
     * 区域:国内、国外
     */
    SECTOR("Sector"),
    /**
     * 省份：湖南
     */
    PROVINCES("Provinces"),
    /**
     * 城市：北京
     */
    CITY("City");

    private final String value;

    PassengerCountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PassengerCountType fromValue(String v) {
        for (PassengerCountType c : PassengerCountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
