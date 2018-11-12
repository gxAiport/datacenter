package com.gxairport.ais.models.aodb.flight.collection;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * FileName      ScheduledGate.java
 * Description  TODO  计划航班的登机口
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
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_SHGate", allocationSize = 1)
public class ScheduledGate extends BasicGate {

}
