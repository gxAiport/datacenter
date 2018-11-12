package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.GateRole;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * TypeName      BasicFlight.AirportData.BasicGate
 * Description  登机口实体类的基类
 */
@MappedSuperclass
public abstract class BasicGate extends IntIdEntity {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String GATENUMBER = "gateNumber";
    public static final String GATEROLE = "gateRole";
    /**
     * 登机口
     */
    @Column(length = 20)
    private String gateNumber;
    /**
     * 登机口规则
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private GateRole gateRole;

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateRole getGateRole() {
        return gateRole;
    }

    public void setGateRole(GateRole gateRole) {
        this.gateRole = gateRole;
    }


}
