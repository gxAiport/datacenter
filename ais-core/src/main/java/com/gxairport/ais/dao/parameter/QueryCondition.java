

package com.gxairport.ais.dao.parameter;

import java.io.Serializable;
import java.util.List;


/**
 * FileName      QueryConditions.java
 * Description  TODO  查询条件
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0   create
 * <p>Why  What is modified:
 */

public class QueryCondition implements Serializable {


    /**
     * 条件表达式
     */
    private Object[] expression;
    /**
     * 选择显示的字段
     */
    private String[] selectFields;

    /**
     * 排序字段
     */
    private QueryOrder[] orders;


    /**
     * 分页开始标记
     */
    private Integer first;

    /**
     * 分页结束标记
     */
    private Integer max;

    /**
     * 连接一对多的标识符
     */
    private String fetchOneToMany = "";

    /**
     * 连接多对一的标识符
     */
    private String fetchManyToOne = "ALL";


    /**
     * 分组字段
     */
    private List<GroupField> groupFields;

    /**
     * 聚合字段
     */
    private List<AggregationColumnField> aggregationFields;


    public Object[] getExpression() {
        return expression;
    }

    public void setExpression(Object[] expression) {
        this.expression = expression;
    }

    public QueryOrder[] getOrders() {
        return orders;
    }

    public void setOrders(QueryOrder[] orders) {
        this.orders = orders;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getFetchOneToMany() {
        return fetchOneToMany;
    }

    public void setFetchOneToMany(String fetchOneToMany) {
        this.fetchOneToMany = fetchOneToMany;
    }

    public String getFetchManyToOne() {
        return fetchManyToOne;
    }

    public void setFetchManyToOne(String fetchManyToOne) {
        this.fetchManyToOne = fetchManyToOne;
    }

    public List<GroupField> getGroupFields() {
        return groupFields;
    }

    public void setGroupFields(List<GroupField> groupFields) {
        this.groupFields = groupFields;
    }

    public List<AggregationColumnField> getAggregationFields() {
        return aggregationFields;
    }

    public void setAggregationFields(List<AggregationColumnField> aggregationFields) {
        this.aggregationFields = aggregationFields;
    }

    public String[] getSelectFields() {
        return selectFields;
    }

    public void setSelectFields(String[] selectFields) {
        this.selectFields = selectFields;
    }


}
