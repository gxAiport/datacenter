package com.gxairport.ais.dao;

import com.gxairport.ais.dao.parameter.QueryCondition;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;


/**
 * FileName      IDao.java
 * Description   TODO 用来操作数据库的通用DAO层接口,
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0       CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月22日      ZhangYu    1.0    create
 * Why  What is modified:
 */
@Local
public interface IDao<K, E> {

    /**
     * Description: TODO 在数据库保存一个对象
     *
     * @param entity 实体对象
     * @return 返回保存的ID值
     */
    E save(E entity);

    /**
     * Description: TODO 在数据库中删除一个给定的对象
     *
     * @param entity 实体对象
     */
    void remove(E entity);

    /**
     * Description: TODO 根据给定的条件删除对应的对象
     *
     * @param condition 传入的条件
     * @param clazz     实体类对象
     * @return 删除记录条数
     * @throws Exception 一般异常为条件合并出错
     */
    int removeByCondition(QueryCondition condition, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 更新一个对象的方法
     *
     * @param entity 实体类
     * @return 对象实体类
     */
    E update(E entity);

    /**
     * Description: TODO 从数据库中返回给定一个ID的实体对象
     *
     * @param id    给定的ID
     * @param clazz 对象类型
     * @return 查询到的实体对象
     * @throws Exception 抛出异常
     */
    E findById(K id, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 从数据库返回给一个特定实体对象的所有数据
     *
     * @param clazz 对象了类型
     * @return 所有的给定实体对象类型的所有数据
     * @throws Exception 抛出异常
     */
    List<E> getAll(Class<E> clazz) throws Exception;

    /**
     * Description: TODO 根据给定的字段名及数据来获得一个实体对象
     *
     * @param clazz 对象类型
     * @param field 给定的字段名
     * @param value 指定的数据
     * @return 符合条件的一个实体对象
     */
    E findByFieldSingle(String field, Object value, Class<E> clazz);

    /**
     * Description: TODO 根据给定的字段名及数据来获得实体对象集合
     *
     * @param clazz 对象类型
     * @param field 给定的字段名
     * @param value 指定的数据
     * @return 符合条件的实体对象集合
     * @throws Exception 抛出异常
     */
    List<E> findByFieldAll(String field, Object value, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 根据给定的条件及数据来获得实体对象集合
     *
     * @param clazz     对象类型
     * @param condition 传入的条件
     * @return 符合条件的一个实体对象
     * @throws Exception 异常
     */
    E findByConditionSingle(QueryCondition condition, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 根据给定的条件及数据来获得实体对象集合
     *
     * @param clazz     对象类型
     * @param condition 传入的条件
     * @return 符合条件的实体对象集合
     * @throws Exception 抛出异常
     */
    List<E> findByConditionAll(QueryCondition condition, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 根据给定的条件获取符合条件的数量
     *
     * @param clazz     对象类型
     * @param condition 传入的条件
     * @return 获取符合条件对象的数量
     * @throws Exception 抛出异常
     */
    int findCountByCondition(QueryCondition condition, Class<E> clazz) throws Exception;

    /**
     * Description: TODO 根据给定的条件进行聚合处理
     *
     * @param clazz     对象类型
     * @param condition 传入的条件
     * @return 聚合的结果
     * @throws Exception 异常
     */
    List<Map<String, Object>> findAggregationByCondition(QueryCondition condition, Class<E> clazz) throws Exception;

}
