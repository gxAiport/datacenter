package com.gxairport.ais.models.aodb.flight.collection;


import com.gxairport.ais.models.aodb.flight.HistoryFlight;

import javax.persistence.*;


@Entity
@Table(name = "History_EnsureService")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_HisEnsureService", allocationSize = 1)
public class HistoryEnsureService extends BasicEnsureService {

    @ManyToOne
    @JoinColumn(name = "historyFlight_id")
    private HistoryFlight flight;

    public HistoryFlight getFlight() {
        return flight;
    }

    public void setFlight(HistoryFlight flight) {
        this.flight = flight;
    }


}
