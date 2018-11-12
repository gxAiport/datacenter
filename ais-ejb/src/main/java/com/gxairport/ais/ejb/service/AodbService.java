package com.gxairport.ais.ejb.service;

import com.gxairport.ais.service.IAodbService;
import com.gxairport.ais.service.impl.Service;
import com.gxairport.ais.ejb.dao.AodbDaoImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * FileName      AODBService.java
 * Description  TODO  Aodb服务层实现类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月24日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月24日      ZhangYu    1.0     create
 * <p>Why  What is modified:
 */
@Stateless
public class AodbService<K, E> extends Service<K, E> implements IAodbService<K, E> {

    @EJB
    public void setAodbDAO(AodbDaoImpl<K, E> daoImpl) {
        setDao(daoImpl);
    }

}
