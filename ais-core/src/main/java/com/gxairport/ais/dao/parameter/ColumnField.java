package com.gxairport.ais.dao.parameter;

/**
 * FileName      ColumnField.java
 * Description  TODO  列字段的抽象类，所有实际的列字段都继承它
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月22日      ZhangYu    1.0    create
 * Why  What is modified:
 */

public class ColumnField extends ReportField {

    private static final long serialVersionUID = 1L;

    public static String EXPRESSION = "expression";

    /**
     * 聚合表达式，只能是+,-或者单个
     */
    private Object[] expression;

    /**
     * @return the expression
     */
    public Object[] getExpression() {
        return expression;
    }

    /**
     * @param expression the expression to set
     */
    public void setExpression(Object[] expression) {
        this.expression = expression;
    }


}