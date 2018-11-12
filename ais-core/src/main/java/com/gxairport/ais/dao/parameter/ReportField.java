package com.gxairport.ais.dao.parameter;

import java.io.Serializable;


/**
 * FileName      ReportField.java
 * Description  TODO 用于统计分组报表字段的基类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月22日      ZhangYu    1.0    create
 * Why  What is modified:
 */


public class ReportField implements Serializable {


    public static String EXPRESSION_STRING = "expressionString";

    public static String ALIAS = "alias";

    /**
     * 表达式的字符串
     */
    private String expressionString;

    /**
     * 别名
     */
    private String alias;

    public String getExpressionString() {
        return expressionString;
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
