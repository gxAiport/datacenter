package com.gxairport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      CheckInDesk.java
 * Description  TODO 值机柜台的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月13日      ZhangYu    1.0     create
 * Why  What is modified:
 */

@Entity
@Table(name = "CheckInDesk")
public class CheckInDesk extends FlightResource {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CHECK_IN_DESK_ID = "checkInDeskID";
    public static final String CHECK_IN_GROUP = "checkInGroup";

    /**
     * 值机柜台ID
     */
    @Id
    @Column(length = 15)
    private String checkInDeskID;
    /**
     * 值机柜台组
     */
    @Column(length = 4)
    private String checkInGroup;

    public String getCheckInDeskID() {
        return checkInDeskID;
    }

    public void setCheckInDeskID(String checkInDeskID) {
        this.checkInDeskID = checkInDeskID;
    }

    public String getCheckInGroup() {
        return checkInGroup;
    }

    public void setCheckInGroup(String checkInGroup) {
        this.checkInGroup = checkInGroup;
    }

    @Override
    public Object getIdValue() {
        return this.checkInDeskID;
    }


}
