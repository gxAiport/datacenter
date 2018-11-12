package com.gxairport.ais.models;

import com.gxairport.ais.models.aodb.basic.Aircraft;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * FileName      IntIdEntity.java
 * Description  TODO id为整型实体类基类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0       CreateDate: 2017年6月11日
 * ModificationHistory
 * Date         Author     Version      Description
 * <p>---------------------------------------------
 * <p>2017年6月11日      ZhangYu    1.0   create
 * <p>Why  What is modified:
 */

@MappedSuperclass
public abstract class IntIdEntity extends DefaultEntity {

    public static String ID = "id";


    /**
     * 整型的主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
    protected Integer id;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Object getIdValue() {
        return this.id;
    }


}
