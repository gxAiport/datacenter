package com.gxairport.ais.models.aodb.flight.collection;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * FileName      SeasonGate.java
 * Description  TODO 航季航班的登机口
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
@Table(name = "Scheduled_Gate")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_SeasonGate", allocationSize = 1)
public class SeasonGate extends BasicGate {
}
