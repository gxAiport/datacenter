package com.gxairport.ais.ejb.dao;

import com.gxairport.ais.dao.impl.DaoImpl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


/**
 * FileName      NNGAodbDaoImpl.java
 * Description   AODB运营数据库DAO层接口实现基类， 该数据库DAO层所有实现类都继承它
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */

@Stateless
public class NNGAodbDaoImpl<K, E> extends DaoImpl<K, E> {

    @PersistenceContext(unitName = "nngAodbDS", type = PersistenceContextType.TRANSACTION)
    private EntityManager nngAodbEm;

    @PostConstruct
    @Override
    public void initCriteriaVariable() {
        em = nngAodbEm;
        model = em.getMetamodel();
        cb = em.getCriteriaBuilder();
    }


}
