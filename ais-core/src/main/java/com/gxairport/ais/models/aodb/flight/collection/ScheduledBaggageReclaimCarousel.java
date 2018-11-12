package com.gxairport.ais.models.aodb.flight.collection;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * FileName      ScheduledBaggageReclaimCarousel.java
 * Description  TODO 计划航班的行李提取转盘
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
@Table(name = "Scheduled_BagReclaimCarousel")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_SHBagCarousel", allocationSize = 1)
public class ScheduledBaggageReclaimCarousel extends BasicBaggageReclaimCarousel {

}
