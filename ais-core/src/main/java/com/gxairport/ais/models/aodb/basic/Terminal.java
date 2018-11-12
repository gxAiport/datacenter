package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.*;


/**
 * FileName      Terminal.java
 * Description  TODO 航站楼的实体类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0    create
 * <p>Why  What is modified:
 */
@Entity
@Table(name = "Terminal")
public class Terminal extends DefaultEntity {


    public static final String TERMINAL_CODE = "terminalCode";
    public static final String DESCRIPTION = "description";
    public static final String AIRPORT = "airport";

    /**
     * 航站楼编码
     */
    @Id
    @Column(length = 4)
    private String terminalCode;
    /**
     * 描述
     */
    @Column(length = 64)
    private String description;
    /**
     * 所属机场
     */
    @ManyToOne
    @JoinColumn(name = "airportIATACode")
    private Airport airport;

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public Object getIdValue() {
        return this.terminalCode;
    }


}
