package com.gxairport.ais.ejb.service;

import com.gxairport.ais.ejb.dao.GeneralDaoImpl;
import com.gxairport.ais.service.IGeneralService;
import com.gxairport.ais.service.impl.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * FileName      GeneralService.java
 * Description  TODO 通用服务层视线里
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月26日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月26日      ZhangYu    1.0     create
 * <p>Why  What is modified:
 */

@Stateless
public class GeneralService<K, E> extends Service<K, E> implements IGeneralService<K, E> {


    @EJB
    public void setGeneralDao(GeneralDaoImpl<K, E> daoImpl) {
        setDao(daoImpl);
    }


}
