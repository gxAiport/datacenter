package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.enums.aodb.SectorCode;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.*;

/**
 * FileName      Route.java
 * Description  TODO 航线的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月17日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0     create
 * <p>Why  What is modified:
 */

@Entity
@Table(name = "FlightRoute")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_FlightRoute", allocationSize = 1)
public class FlightRoute extends IntIdEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final String CHINESE_ROUTE = "chineseRoute";
    public static final String IATA_ROUTE = "IATARoute";
    public static final String SHORT_ROUTE = "shortRoute";
    public static final String SECTOR = "Sector";

    @Column(length = 128)
    private String chineseRoute;

    @Column(length = 64)
    private String IATARoute;

    @Column(length = 64)
    private String shortRoute;

    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private SectorCode sector;

    public String getChineseRoute() {
        return chineseRoute;
    }

    public void setChineseRoute(String chineseRoute) {
        this.chineseRoute = chineseRoute;
    }

    public String getIATARoute() {
        return IATARoute;
    }

    public void setIATARoute(String iATARoute) {
        IATARoute = iATARoute;
    }

    public String getShortRoute() {
        return shortRoute;
    }

    public void setShortRoute(String shortRoute) {
        this.shortRoute = shortRoute;
    }

    public SectorCode getSector() {
        return sector;
    }

    public void setSector(SectorCode sector) {
        this.sector = sector;
    }


}
