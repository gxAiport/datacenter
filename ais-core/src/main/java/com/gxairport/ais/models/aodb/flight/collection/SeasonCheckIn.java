package com.gxairport.ais.models.aodb.flight.collection;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * FileName      SeasonCheckIn.java
 * Description  TODO 航季航班的值机柜台
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
@Table(name = "Season_CheckIn")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_SeasonCheckIn", allocationSize = 1)
public class SeasonCheckIn extends BasicCheckIn {
}
