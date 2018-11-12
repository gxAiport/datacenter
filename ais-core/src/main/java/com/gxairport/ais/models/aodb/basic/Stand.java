package com.gxairport.ais.models.aodb.basic;

import javax.persistence.*;

/**
 * FileName      Stand.java
 * Description  TODO 停机位的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0   CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0    create
 * <p>Why  What is modified:
 */

@Entity
@Table(name = "Stand")
public class Stand extends FlightResource {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String STAND_POSITION = "standPosition";
    public static final String STAND_IS_SECURE = "standIsSecure";
    public static final String GATE = "gate";

    /**
     * 停机位编号
     */
    @Id
    @Column(length = 30)
    private String standPosition;
    /**
     * 安全登机口
     */
    private Boolean standIsSecure;
    /**
     * 对应的登机口
     */
    @ManyToOne
    @JoinColumn(name = "gateNumber")
    private Gate gate;

    public String getStandPosition() {
        return standPosition;
    }

    public void setStandPosition(String standPosition) {
        this.standPosition = standPosition;
    }

    public Boolean getStandIsSecure() {
        return standIsSecure;
    }

    public void setStandIsSecure(Boolean standIsSecure) {
        this.standIsSecure = standIsSecure;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    @Override
    public Object getIdValue() {
        return this.standPosition;
    }


}
