package com.gxairport.ais.models.aodb.flight.collection;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * FileName      SeasonShareFlight.java
 * Description  TODO 航季航班的共享航班
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
@Table(name = "Season_ShareFlight")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_SeasonShareFlight", allocationSize = 1)
public class SeasonShareFlight extends BasicShareFlight {

}
