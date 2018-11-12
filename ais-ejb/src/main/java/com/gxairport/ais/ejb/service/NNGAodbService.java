package com.gxairport.ais.ejb.service;


import com.gxairport.ais.service.INNGAodbService;
import com.gxairport.ais.service.impl.Service;
import com.gxairport.ais.ejb.dao.NNGAodbDaoImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * FileName      AODBService.java
 * Description  TODO 南宁机场服务层实现类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月24日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月24日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */
@Stateless
public class NNGAodbService<K, E> extends Service<K, E> implements INNGAodbService<K, E> {

    @EJB
    public void setAodbDAO(NNGAodbDaoImpl<K, E> daoImpl) {
        setDao(daoImpl);
    }

}
