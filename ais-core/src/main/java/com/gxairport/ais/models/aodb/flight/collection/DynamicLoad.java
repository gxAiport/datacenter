package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.models.aodb.flight.DynamicFlight;
import com.gxairport.ais.models.aodb.flight.HistoryFlight;

import javax.persistence.*;

/**
 * FileName      DynamicLoad.java
 * Description  TODO 航班动态载量的实体类
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
@Table(name = "Dynamic_Load")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DynLoad", allocationSize = 1)
public class DynamicLoad extends BasicLoad {

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
