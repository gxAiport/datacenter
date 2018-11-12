package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.models.aodb.flight.DynamicFlight;

import javax.persistence.*;

/**
 * FileName      DynamicEnsureService.java
 * Description  TODO  航班动态的服务保障节点
 *
 * @author zhang    Company:    gxAirport
 * @version V1.0  CreateDate: 2018-10-29
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2018-10-29        zhang   1.0    create
 * Why  What is modified:
 */

@Entity
@Table(name = "Dynamic_EnsureService")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DynEnsureService", allocationSize = 1)
public class DynamicEnsureService extends BasicEnsureService {

    @ManyToOne
    @JoinColumn(name = "dynamicFlight_id")
    private DynamicFlight flight;

    public DynamicFlight getFlight() {
        return flight;
    }

    public void setFlight(DynamicFlight flight) {
        this.flight = flight;
    }
}
