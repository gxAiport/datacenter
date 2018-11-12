package com.gxairport.ais.ejb.dao;

import com.gxairport.ais.dao.impl.DaoImpl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * FileName      NNGAommsDaoImpl.java
 * Description  TODO 南宁机场地服系统的DAO层接口实现基类， 该数据库DAO层所有实现类都继承它
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年10月19日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月19日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


@Stateless
public class NNGAommsDaoImpl<K, E> extends DaoImpl<K, E> {
    @PersistenceContext(unitName = "nngAommsDS", type = PersistenceContextType.TRANSACTION)
    private EntityManager nngAodbEm;

    @PostConstruct
    @Override
    public void initCriteriaVariable() {
        em = nngAodbEm;
        model = em.getMetamodel();
        cb = em.getCriteriaBuilder();
    }

}
