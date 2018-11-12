package com.gxairport.ais.dao.parameter;


import com.gxairport.ais.enums.QuerySortMode;

import java.io.Serializable;

/**
 * FileName      AisOrder.java
 * Description  TODO 排序类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0    create
 * <p>Why  What is modified:
 */

public class QueryOrder implements Serializable {


    /**
     * 字段名
     */
    private String name;

    /**
     * 排序类型
     */
    private QuerySortMode querySortMode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuerySortMode getQuerySortMode() {
        return querySortMode;
    }

    public void setQuerySortMode(QuerySortMode querySortMode) {
        this.querySortMode = querySortMode;
    }

}
