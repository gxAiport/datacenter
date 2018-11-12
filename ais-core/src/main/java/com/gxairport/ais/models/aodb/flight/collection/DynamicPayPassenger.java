package com.gxairport.ais.models.aodb.flight.collection;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * FileName      DynamicPayPassenger.java
 * Description  TODO 航班动态付费旅客实体类
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
@Table(name = "Dynamic_PayPassenger")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DynPayPax", allocationSize = 1)
public class DynamicPayPassenger extends BasicPayPassenger {

}
