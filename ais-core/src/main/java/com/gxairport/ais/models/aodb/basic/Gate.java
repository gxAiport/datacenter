package com.gxairport.ais.models.aodb.basic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * FileName BasicGate.java
 * Description TODO 登机口的实体类
 *
 * @author ZhangYu Company: gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date    Author    Version    Description
 * ---------------------------------------------
 * 2017年6月13日            ZhangYu 1.0       create
 * Why  What is modified:
 */

@Entity
@Table(name = "BasicGate")
public class Gate extends FlightResource {

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String GATE_NUMBER = "gateNumber";
    public static final String BOARDING_BRIDGES = "boardingBridges";
    /**
     * 登机口编号
     */
    @Id
    @Column(length = 15)
    private String gateNumber;
    /**
     * 对应的登机桥
     */
    @OneToMany
    @JoinColumn(name = "gate_id")
    private List<BoardingBridge> boardingBridges;

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public List<BoardingBridge> getBoardingBridges() {
        if (boardingBridges == null) {
            boardingBridges = new ArrayList<>();
        }
        return this.boardingBridges;
    }

    @Override
    public Object getIdValue() {
        return this.gateNumber;
    }


}
