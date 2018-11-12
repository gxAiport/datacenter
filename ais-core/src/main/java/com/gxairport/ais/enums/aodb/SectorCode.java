package com.gxairport.ais.enums.aodb;

/**
 * FileName      SectorCode.java
 * Description  TODO 区域代码
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月12日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月12日      ZhangYu    1.0     create
 * Why  What is modified:
 */

public enum SectorCode {
    /**
     * 国内
     */
    D,
    /**
     * 国际
     */
    I,
    /**
     * 混合
     */
    M,
    /**
     * A
     * 地区
     */
    R;

    public String value() {
        return name();
    }

    public static SectorCode fromValue(String v) {
        return valueOf(v);
    }

    /**
     * 根据CAAC区域的代码，返回对应的区域枚举值
     *
     * @param code CAAC对应代码
     * @return 区域枚举值
     */
    public static SectorCode fromCAACCode(String code) {

        switch (code.toUpperCase()) {

            case "DOM":
                return D;
            case "INT":
                return I;
            case "REG":
                return R;
            default:
                return null;

        }
    }

    /**
     * 根据区域枚举类值，返回对应的区域CAAC代码
     *
     * @param code 枚举类
     * @return 区域CAAC代码
     */
    public static String toCAACCode(SectorCode code) {

        switch (code) {

            case D:
                return "DOM";
            case I:
                return "INT";
            case R:
                return "REG";
            default:
                return null;

        }
    }

    /**
     * 根据区域枚举值，返回区域中文含义
     *
     * @param code 枚举值
     * @return 中文含义，如果没有对应枚举值，返回值为空
     */

    public static String getChinese(SectorCode code) {

        switch (code) {
            case D:
                return "国内";
            case I:
                return "国际";
            case M:
                return "混合";
            case R:
                return "地区";
            default:
                return null;
        }

    }


}