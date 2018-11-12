package com.gxairport.ais.models.aodb.basic;

import com.gxairport.ais.models.DefaultEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName      EnsureItem.java
 * Description  TODO 服务保障节点项目实体类
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
@Table(name = "EnsureItem")
public class EnsureItem extends DefaultEntity {

    public static final String ENSURE_CODE = "ensureCode";
    public static final String ENSURE_NAME = "ensureName";

    @Id
    @Column(length = 10)
    private String ensureCode;

    @Column(length = 32)
    private String ensureName;


    public String getEnsureCode() {
        return ensureCode;
    }

    public void setEnsureCode(String ensureCode) {
        this.ensureCode = ensureCode;
    }

    public String getEnsureName() {
        return ensureName;
    }

    public void setEnsureName(String ensureName) {
        this.ensureName = ensureName;
    }

    @Override
    public Object getIdValue() {
        return ensureCode;
    }
}
