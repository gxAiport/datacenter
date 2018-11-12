package com.gxairport.ais.ejb.service;

import com.gxairport.ais.ejb.dao.NNGAommsDaoImpl;
import com.gxairport.ais.service.INNGAommsService;
import com.gxairport.ais.service.impl.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * FileName      NNGAommsService.java
 * Description  TODO 南宁机场地服系统的Service
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2017年10月19日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月19日      ZhangYu    1.0    create
 * <p>Why & What is modified: <修改原因描述>
 */

@Stateless
public class NNGAommsService<K, E> extends Service<K, E> implements INNGAommsService<K, E> {

    @EJB
    public void setNNGAommsDAO(NNGAommsDaoImpl<K, E> daoImpl) {
        setDao(daoImpl);
    }

}
