package com.gxairport.ais.service.impl;

import com.gxairport.ais.dao.IDao;
import com.gxairport.ais.dao.parameter.QueryCondition;
import com.gxairport.ais.service.IService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName      DefaultEntity.java
 * Description  TODO  通用的Service层接口的实现类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月11日
 * ModificationHistory
 * Date         Author     Version        Description
 * ---------------------------------------------
 * 2017年6月11日      ZhangYu    1.0   create
 * Why  What is modified:
 */

public class Service<K, E> implements IService<K, E> {

    protected IDao<K, E> dao;

    private static final String RECORDS = "records";

    private static final String RECORD_COUNT = "totalCount";

    @Override
    public void setDao(IDao<K, E> dao) {
        this.dao = dao;
    }

    @Override
    public E add(E entity) {
        return dao.save(entity);
    }


    @Override
    public E update(E entity) {
        return dao.update(entity);
    }

    @Override
    public void remove(E entity) {
        dao.remove(entity);
    }

    @Override
    public int removeByCondition(QueryCondition condition, Class<E> clazz) throws Exception {
        return dao.removeByCondition(condition, clazz);
    }

    @Override
    public List<E> getAll(Class<E> clazz) throws Exception {
        return dao.getAll(clazz);
    }

    @Override
    public E findByID(K id, Class<E> clazz) throws Exception {
        if (id != null) {
            return dao.findById(id, clazz);
        } else {
            return null;
        }
    }

    @Override
    public List<E> findByFieldAll(String field, Object value, Class<E> clazz) throws Exception {
        return dao.findByFieldAll(field, value, clazz);

    }

    @Override
    public E findByFieldSingle(String field, Object value, Class<E> clazz) {
        return dao.findByFieldSingle(field, value, clazz);

    }

    @Override
    public E findByConditionSingle(QueryCondition condition, Class<E> clazz) throws Exception {
        E result = dao.findByConditionSingle(condition, clazz);
        if (result != null) {
            return result;
        } else {
            return null;
        }
    }

    @Override
    public List<E> findByConditionAll(QueryCondition condition, Class<E> clazz) throws Exception {
        return dao.findByConditionAll(condition, clazz);
    }


    @Override
    public int countByCondition(QueryCondition condition, Class<E> clazz) throws Exception {
        return dao.findCountByCondition(condition, clazz);
    }


    @Override
    public List<Map<String, Object>> findAggregationByCondition(QueryCondition condition, Class<E> clazz) throws Exception {
        return dao.findAggregationByCondition(condition, clazz);
    }


    @Override
    public Map<String, Object> fetchResponseByCondition(QueryCondition condition, Class<E> clazz) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(RECORD_COUNT, countByCondition(condition, clazz));
        map.put(RECORDS, findByConditionAll(condition, clazz));
        return map;
    }


}
