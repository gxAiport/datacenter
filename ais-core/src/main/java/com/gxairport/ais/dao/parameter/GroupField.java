package com.gxairport.ais.dao.parameter;

import com.gxairport.ais.enums.QueryGroupDate;


/**
 * FileName      GroupField.java
 * Description  TODO 分组字段，用于报表字段的行，进行GroupBy的统计，表达式的参数只允许一个字段
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月22日      ZhangYu    1.0      create
 * Why  What is modified:
 */


public class GroupField extends ReportField {


    private static final long serialVersionUID = 1L;

    public static String EXPRESSION = "expression";

    public static String QUERY_GROUP_DATE = "queryGroupDate";

    /**
     * 表达式
     */
    private Object expression;


    /**
     * 日期类型
     */
    private QueryGroupDate queryGroupDate;


    public Object getExpression() {
        return expression;
    }


    public void setExpression(Object expression) {
        this.expression = expression;
    }


    public QueryGroupDate getQueryGroupDate() {
        return queryGroupDate;
    }


    public void setQueryGroupDate(QueryGroupDate queryGroupDate) {
        this.queryGroupDate = queryGroupDate;
    }


}
