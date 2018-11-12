package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.*;

/**
 * FileName      AirRouteDistance.java
 * Description  TODO 空中航线实体表
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V0.9a CreateDate: 2017年6月21日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月21日      ZhangYu    1.0     create
 * Why  What is modified:
 */
@Entity
@Table(name = "AirRouteDistance")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_AirDistance", allocationSize = 1)
public class AirRouteDistance extends IntIdEntity {

    /**
     * 查询条件字段与实际数据库字段一一对应
     */

    public final static String DEPARTURE_AIRPORT = "departureAirport";
    public final static String ARRIVAL_AIRPORT = "arrivalAirport";
    public final static String ROUTE = "route";
    public final static String DISTANCE = "distance";


    /**
     * 出港机场
     */
    @ManyToOne
    @JoinColumn(name = "departureAirportIATACode")
    private Airport departureAirport;
    /**
     * 到达机场
     */
    @ManyToOne
    @JoinColumn(name = "arrivalAirportIATACode")
    private Airport arrivalAirport;

    /**
     * 航路
     */
    private String route;


    /**
     * 航线的距离
     */
    private Integer distance;


    /**
     * @return the departureAirport
     */
    public Airport getDepartureAirport() {
        return departureAirport;
    }


    /**
     * @param departureAirport the departureAirport to set
     */
    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }


    /**
     * @return the arrivalAirport
     */
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }


    /**
     * @param arrivalAirport the arrivalAirport to set
     */
    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }


    /**
     * @return the airRoute
     */
    public String getRoute() {
        return route;
    }


    /**
     * @param airRoute the airRoute to set
     */
    public void setRoute(String airRoute) {
        this.route = airRoute;
    }


    /**
     * @return the airRouteDistance
     */
    public Integer getDistance() {
        return distance;
    }


    /**
     * @param airRouteDistance the airRouteDistance to set
     */
    public void setDistance(Integer airRouteDistance) {
        this.distance = airRouteDistance;
    }


}
