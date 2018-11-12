package com.gxairport.ais.service;

import com.gxairport.ais.dao.IDao;
import com.gxairport.ais.dao.parameter.QueryCondition;

import java.util.List;
import java.util.Map;


/**
 * FileName      DefaultEntity.java
 * Description  TODO  服务层接口
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月11日
 * ModificationHistory
 * Date         Author     Version        Description
 * ---------------------------------------------
 * 2017年6月11日      ZhangYu    1.0   create
 * Why  What is modified:
 */


public interface IService<K, E> {


    /**
     * Description: TODO 设置操作数据的Dao对象
     *
     * @param dao DAO对象
     */
    void setDao(IDao<K, E> dao);


    /**
     * Description: TODO 删除一个数据对象
     *
     * @param entity 数据对象
     */
    void remove(E entity);

    /**
     * Description: TODO 根据给定的条件删除对应的对象
     *
     * @param condition 传入的条件
     * @param clazz     实体类对象
     * @return 删除的实体对象数
     * @throws Exception 异常
     */
    int removeByCondition(QueryCondition condition, Class<E> clazz) throws Exception;


    /**
     * Description: TODO 增加一个数据对象
     *
     * @param entity 数据对象
     * @return 数据对象
     */
    E add(E entity);

    /**
     * Description: TODO 更新一个数据对象
     *
     * @param entity 数据实体对象
     * @return 数据对象
     */
    E update(E entity);

    /**
     * Description: TODO 返回所有的数据对象
     *
     * @param clazz 数据对象类型
     * @return 所有的数据对象
     * @throws Exception 异常
     */
    List<E> getAll(Class<E> clazz) throws Exception;

    /**
     * Description: TODO 返回指定Id所代表的数据对象
     *
     * @param id    关键字
     * @param clazz 数据对象类型
     * @return 指定Id所代表的数据对象
     * @throws Exception 异常
     */
    E findByID(K id, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 返回指定字段值得数据对象集合
     *
     * @param field 指定字段名
     * @param value 字段值
     * @param clazz 数据对象类型
     * @return 指定字段值得数据对象
     * @throws Exception 异常
     */
    List<E> findByFieldAll(String field, Object value, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 返回指定字段值得单个数据对象
     *
     * @param field 字段名
     * @param value 字段值
     * @param clazz 数据对象类型
     * @return 指定字段值得数据对象
     */
    E findByFieldSingle(String field, Object value, Class<E> clazz);

    /**
     * Description: TODO 根据给定的条件及数据来获得单个实体对象
     *
     * @param condition 条件
     * @param clazz     对象类型
     * @return 实体对象
     * @throws Exception 异常
     */
    E findByConditionSingle(QueryCondition condition, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 根据给定的条件及数据来获得实体对象集合
     *
     * @param condition 条件
     * @param clazz     对象类型
     * @return 实体对象
     * @throws Exception 异常
     */
    List<E> findByConditionAll(QueryCondition condition, Class<E> clazz) throws Exception;

    /**
     * Description: TODO  根据条件返回符合条件对象的数量
     *
     * @param condition 传入的条件
     * @param clazz     对象类型
     * @return 获取符合条件对象的数量
     * @throws Exception 异常
     */
    int countByCondition(QueryCondition condition, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 根据给定的条件进行聚合处理
     *
     * @param condition 条件
     * @param clazz     对象类型
     * @return 聚合处理的结果
     * @throws Exception 异常
     */
    List<Map<String, Object>> findAggregationByCondition(QueryCondition condition, Class<E> clazz) throws Exception;


    /**
     * Description: TODO 根据给定的条件返回前端所需要的Map集合
     *
     * @param condition 根据给定的条件返回前端所需要的Map集合
     * @param clazz     对象类型
     * @return 前端所需要的集合
     * @throws Exception 异常
     */
    Map<String, Object> fetchResponseByCondition(QueryCondition condition, Class<E> clazz) throws Exception;


}
