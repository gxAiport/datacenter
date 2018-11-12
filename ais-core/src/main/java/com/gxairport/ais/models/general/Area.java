package com.gxairport.ais.models.general;


import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * FileName      Area.java
 * Description  TODO 区域实体类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2018年11月7日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2018年11月7日      ZhangYu    1.0     create
 * Why  What is modified:
 */


@Entity
@Table(name = "Area")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_Area", allocationSize = 1)
public class Area extends IntIdEntity {

    public static final String ADMIN_CODE = "adminCode";
    public static final String ADMIN_NAME = "adminName";
    public static final String PROVINCES = "provinces";
    public static final String REGION = "region";
    public static final String CITY = "city";


    /**
     * 行政区域代码
     */
    @Column(length = 6)
    private String adminCode;

    /**
     * 行政区域中文
     */
    @Column(length = 32)
    private String adminName;

    /**
     * 省份
     */
    @Column(length = 32)
    private String provinces;

    /**
     * 地区
     */
    @Column(length = 32)
    private String region;

    /**
     * 城市或者街道
     */
    @Column(length = 32)
    private String city;

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
