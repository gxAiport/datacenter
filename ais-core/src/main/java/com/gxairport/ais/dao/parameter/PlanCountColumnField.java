package com.gxairport.ais.dao.parameter;

import java.util.Date;

/**
 * FileName      PlanCountColumnField.java
 * Description  TODO 计划飞行架次的列字段
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version      Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0   create
 * <p>Why  What is modified:
 */


public class PlanCountColumnField extends ColumnField {

    private static final long serialVersionUID = 1L;

    /**
     * 行字段，第一个Group字段
     */
    private GroupField rowField;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束字段
     */
    private Date endDate;


    public GroupField getRowField() {
        return rowField;
    }

    public void setRowField(GroupField rowField) {
        this.rowField = rowField;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
