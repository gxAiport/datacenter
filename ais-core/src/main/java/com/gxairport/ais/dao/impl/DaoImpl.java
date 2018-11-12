package com.gxairport.ais.dao.impl;

import com.gxairport.ais.dao.IDao;
import com.gxairport.ais.dao.parameter.*;
import com.gxairport.ais.enums.QuerySortMode;
import com.gxairport.ais.exception.ComposeException;
import com.gxairport.ais.models.DefaultEntity;
import com.gxairport.ais.utils.ObjectMethodUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.FetchParent;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.Attribute.PersistentAttributeType;


/**
 * FileName      DaoImpl.java
 * Description  TODO 通用的DAO层接口抽象类，实现各种通用的操作数据库的方法
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2017年6月23日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月23日      ZhangYu    1.0     create
 * Why  What is modified:
 */
@Stateless
public abstract class DaoImpl<K, E> implements IDao<K, E> {


    /**
     * 实体管理器，用于操作实体
     */
    protected EntityManager em = null;
    /**
     * 元模型由EM获取
     */
    protected Metamodel model = null;
    /**
     * Criteria建造者，由EM获取
     */
    protected CriteriaBuilder cb = null;


    /**
     * Description  TODO  初始化Criteria关键的对象、赋值EM、获取原模型及Cb；
     */
    public abstract void initCriteriaVariable();

    /**
     * Description  TODO  用元模型替换条件表达式中的实体属性的静态字符串
     *
     * @param root        JPA中的root对象，用于将对应的属性变为JPA可识别的表达式
     * @param expressions 需要替换的表达式
     * @param isCondition 条件标识式，如果是条件表达式，则对后面表达式的枚举类型进行转换
     * @param joins       SetAttribute属性匹配字段连接存入数据组
     * @throws NoSuchMethodException     调用getDeclaredMethod抛出的异常
     * @throws InvocationTargetException 调用invoke抛出的异常
     * @throws IllegalAccessException    调用invoke抛出的异常
     */

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void modelToExpression(Root root, Object[] expressions, boolean isCondition, List<Join> joins)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        if (expressions != null) {
            /*
             *   获取所有的元模式属性
             */
            Set<Attribute> attributes = root.getModel().getAttributes();
            /*
             * 查找Expression表达式中与属性相同的字段，并进行替换
             */
            for (Attribute attribute : attributes)
                for (int i = 0; i < expressions.length; i++)
                    if (attribute.getName().equals(expressions[i])) {

                        expressions[i] = root.get((SingularAttribute) attribute);
					/*
					     如果是条件表达式，对应的数值需要进行对应的转换，主要用于枚举类的转换
					 */
                        if (isCondition) {
                            /*
                             *   如果Value是字符串型，而对应的字段是枚举，调用枚举类型的fromValue方法进行转换
                             *
                             */
                            if (Enum.class.isAssignableFrom(attribute.getJavaType()) &&
                                    ((i + 2) <= expressions.length) && (expressions[i + 2] instanceof String)) {
                                Method method = attribute.getJavaType().getDeclaredMethod("fromValue", String.class);
                                expressions[i + 2] = method.invoke(attribute.getJavaType(), expressions[i + 2].toString());
                            }

                            /*
                             * 如果字段为ManyToOne，且传入的Value(expression[i+2])是字符串或者枚举型
                             * 则进行查找替换
                             */
                            if (attribute.getPersistentAttributeType().equals(PersistentAttributeType.MANY_TO_ONE) &&
                                    i + 2 <= expressions.length &&
                                    (expressions[i + 2] instanceof String || expressions[i + 2] instanceof Enum)) {
                                /*
                                 *   如果Value是字符串型，而对应的实体的ID是枚举，调用枚举类型的fromValue方法进行转换
                                 *
                                 */
                                Class jt = attribute.getJavaType();
                                CriteriaQuery cq = cb.createQuery(jt);
                                Root er = cq.from(jt);
                                Class idType = er.getModel().getIdType().getJavaType();
                                if (Enum.class.isAssignableFrom(idType) && expressions[i + 2] instanceof String) {
                                    Method method = idType.getDeclaredMethod("fromValue", String.class);
                                    expressions[i + 2] = method.invoke(idType, expressions[i + 2].toString());
                                }
                                /*
                                 *   利用findById进行查找对应的entity 进行替换expression中对应的数值
                                 */
                                expressions[i + 2] = findById((K) expressions[i + 2], attribute.getJavaType());

                            }

                        }


                    } else if (attribute instanceof SetAttribute && joins != null) {
					/*
						 如果当前属性是集合，则在集合属性中查找对应的表达式
					 */
                        Class jt = ((SetAttribute) attribute).getBindableJavaType();
                        Expression subExpression = getSubExpression(cb, jt, root, expressions[i],
                                (SetAttribute) attribute, joins);
                        if (subExpression != null) {
                            expressions[i] = subExpression;
                        }
                    }
        }

    }

    /**
     * Description          TODO   用元模型替换GroupField对象表达式中的静态字符串
     *
     * @param root  Root对象
     * @param joins JOIN数组用来保存JION的表达式
     * @param field 分组字段，因为分组字段的表达式不是数组，所以特殊处理
     */
    @SuppressWarnings({"unchecked"})
    private void modelToField(Root root, GroupField field, List<Join> joins) {

        Set<Attribute> attributes = root.getModel().getAttributes();

        for (Attribute attribute : attributes) {

            if (field != null) {

                if (attribute.getName().equals(field.getExpression())) {
                    field.setExpression(root.get((SingularAttribute) attribute));
                } else if (attribute instanceof SetAttribute) {
                    Class javaType = ((SetAttribute) attribute).getBindableJavaType();
                    Expression subExpression = getSubExpression(cb, javaType, root, field.getExpression(),
                            (SetAttribute) attribute, joins);
                    if (subExpression != null) {
                        field.setExpression(subExpression);
                    }
                }
            }
        }
    }

    /**
     * Description          TODO   用元模型的属性替换排序表达式中的实体属性的静态字符串
     *
     * @param root        JPA中的root对象，用于将对应的属性变为JPA可识别的表达式
     * @param clazz       需要操作的CLASS对象
     * @param queryOrders 需要替换的表达式
     */
    @SuppressWarnings({"unchecked"})
    private List<Order> modelToOrder(Root root, Class clazz, QueryOrder[] queryOrders) {
        /*
         *   获取CLAZZ所有的元模式属性
         */
        List<Order> orders = new ArrayList<>();
        Set<Attribute> attributes = model.managedType(clazz).getAttributes();
        for (Attribute attribute : attributes) {
            if (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.EMBEDDED)) {
                /*
                 * 该字段的JPA属性是EMBEDDED，说明该字段为一个对象，递归调用方法本身进行替换
                 */
                orders.addAll(modelToOrder(root, attribute.getJavaType(), queryOrders));
            }
            /*
             * 查找Expression表达式中与属性相同的字段，并进行替换
             */
            for (int i = 0; (queryOrders != null) && (i < queryOrders.length); i++) {

                if (attribute.getName().equals(queryOrders[i].getName())) {
                    if (queryOrders[i].getQuerySortMode().equals(QuerySortMode.ASC)) {
                        orders.add(cb.asc(root.get((SingularAttribute) attribute)));
                    } else {
                        orders.add(cb.desc(root.get((SingularAttribute) attribute)));
                    }

                }
            }
        }
        return orders;
    }


    /**
     * Description        TODO 将实体对象的一对多和多对一对象拼接起来
     *
     * @param fetchParent Fetch的父类对象
     * @param clazz       需要链接实体对象的类型
     * @param manyToOne   多对一的字符串
     * @param oneToMany   一对多的字符串
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private void fetchEntity(FetchParent fetchParent, Class clazz, String manyToOne, String oneToMany) {

        Set<Attribute> attributes = model.managedType(clazz).getAttributes();

        for (Attribute attribute : attributes) {

            switch (attribute.getPersistentAttributeType()) {

                case MANY_TO_ONE:
                    if (manyToOne.equals("ALL") || manyToOne.contains(attribute.getName())) {

                        fetchParent.fetch((SingularAttribute) attribute, JoinType.LEFT);
                    }
                    break;
                case ONE_TO_MANY:
                    if (oneToMany.equals("ALL") || oneToMany.contains(attribute.getName())) {
                        fetchParent.fetch((SetAttribute) attribute, JoinType.LEFT);
                    }
                    break;
                default:
                    break;
            }
        }

    }


    /**
     * Description     TODO 将查询字段转换成JPA样式的Selection集合
     *
     * @param root   JPA中的root对象
     * @param clazz  对应的Class
     * @param fields 字段组
     * @return JPA样式的Selection集合
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private List<Selection<?>> convertSelect(Root root, Class clazz, String[] fields) {
        List<Selection<?>> selections = new ArrayList<>();
        Set<Attribute> attributes = model.managedType(clazz).getAttributes();
        for (String field : fields) {
            for (Attribute attribute : attributes) {
                if (attribute.getName().equals(field)) {
                    switch (attribute.getPersistentAttributeType()) {

                        case MANY_TO_ONE:
                        case ONE_TO_MANY:
                            selections.add(root.join(field, JoinType.LEFT));
                            break;
                        default:
                            selections.add(root.get(field));
                            break;
                    }
                }
            }

        }
        return selections;
    }


    /**
     * Description     TODO 将Object数组转换成对应的实体类
     *
     * @param tq     类型查询对象
     * @param clazz  实体类的类型
     * @param fields 需要转换的字段集合
     * @return 转换并赋值好的额实体类集合
     * @throws NoSuchMethodException  方法异常
     *                                * @throws IllegalAccessException      安全异常
     *                                * @throws InvocationTargetException   目标异常
     * @throws InstantiationException 创建异常
     */
    @SuppressWarnings({"unchecked"})
    private List<E> convertEntity(TypedQuery tq, Class<E> clazz, String[] fields) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        List<E> entityList = new ArrayList<>();

        Set<Attribute<? super E, ?>> attributes = model.managedType(clazz).getAttributes();

        List<Object[]> arrayList = tq.getResultList();

        for (Object[] array : arrayList) {
            E entity = null;
            for (E iterator : entityList) {
                DefaultEntity defaultEntity = (DefaultEntity) iterator;
                if (defaultEntity.getIdValue().equals(array[0])) {
                    entity = iterator;
                    break;
                }
            }
            if (entity == null) {
                entity = clazz.newInstance();
                entityList.add(entity);
            }
            for (int i = 0; i < fields.length; i++) {
                for (Attribute attribute : attributes) {
                    if (attribute.getName().equals(fields[i]) && (array[i] != null)) {
                        if (PersistentAttributeType.ONE_TO_MANY.equals(attribute.getPersistentAttributeType())) {
                            /*
                             * 如果是一对多的属性,取得集合后调用add添加
                             */
                            Object set = ObjectMethodUtil.getFieldObject(entity, fields[i], false);
                            ObjectMethodUtil.setFieldObject(set, "add", array[i], Object.class, true);
                        } else {
                            ObjectMethodUtil.setFieldObject(entity, fields[i], array[i], array[i].getClass(), false);
                        }
                    }
                }
            }

        }
        return entityList;

    }


    /**
     * @param condition TODO 以给定的条件查询返回TypedQuery的对象，提供给其他方法以获取最后的结果
     * @param clazz     实体对象的类型
     * @return TypedQuery对象
     * @throws NoSuchMethodException     传导出的异常
     * @throws IllegalAccessException    传导出的异常
     * @throws InvocationTargetException 传导出的异常
     * @throws ComposeException          传导出的异常
     */
    @SuppressWarnings({"unchecked"})
    private TypedQuery<E> findByCondition(QueryCondition condition, Class<E> clazz)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ComposeException {
        /*
         * 判断是否多选字段标志
         */
        boolean multiSelected = false;

        if (condition.getSelectFields() != null && condition.getSelectFields().length > 0) {
            multiSelected = true;
        }

        CriteriaQuery cq;
        if (multiSelected) {
            /*
             * 如果是指定字段，返回类型是对象数组
             */
            cq = cb.createQuery(Object[].class);
        } else {
            /*
             * 否则返回类型是实体类
             */
            cq = cb.createQuery(clazz);
        }


        Root<E> root = cq.from(clazz);
        List<Order> orders = modelToOrder(root, clazz, condition.getOrders());

        cq.orderBy(orders);
        cq.distinct(true);
        if (multiSelected) {
            cq.multiselect(convertSelect(root, clazz, condition.getSelectFields()));
        } else {
            fetchEntity(root, clazz, condition.getFetchManyToOne(), condition.getFetchOneToMany());
        }

        /*
         *   合成Where表达式
         */
        if (condition.getExpression() != null) {
            modelToExpression(root, condition.getExpression(), true, null);
            Predicate predicate = new ExpressionUtil(cb).composeExpression(condition.getExpression());
            cq.where(predicate);
        }

        if (condition.getFirst() != null && condition.getMax() != null && condition.getMax() != 0) {
            return em.createQuery(cq).
                    setMaxResults(condition.getMax()).
                    setFirstResult(condition.getFirst());
        } else {
            return em.createQuery(cq);
        }
    }


    /**
     * Description: TODO    获取子表达式
     *
     * @param cb            CriteriaBuilder对象
     * @param javaType      实体类的CLASS类型
     * @param root          JPA的ROOT对象
     * @param attributeName 属性名
     * @param setAttribute  集合属性对象
     * @param joins         连接对象集合
     * @return 子表达式
     */
    @SuppressWarnings({"unchecked"})
    private Expression getSubExpression(CriteriaBuilder cb, Class javaType, Root root, Object attributeName,
                                        SetAttribute setAttribute, List<Join> joins) {

        try {
            CriteriaQuery cq = cb.createQuery(javaType);
            Root sr = cq.from(javaType);
            boolean foundJoin = false;
            Join setJoin = null;
            /*
             *  获取元模型及取得元模型所对应的所有属性
             */
            EntityType et = sr.getModel();
            Set<Attribute> attributes = et.getAttributes();
            for (Attribute attribute : attributes) {
                if (attribute.getName().equals(attributeName)) {
                    for (Join join : joins) {
                        if (javaType.equals(join.getModel().getBindableJavaType())) {
                            foundJoin = true;
                            setJoin = join;
                        }
                    }
                    if (!foundJoin) {
                        setJoin = root.join(setAttribute, JoinType.INNER);
                        joins.add(setJoin);
                    }
                    return setJoin.get((SingularAttribute) attribute);
                }
            }
        } catch (Exception e) {
            /*
             *  如果类型不是实体类，返回空
             */
            return null;
        }
        return null;

    }


    /**
     * Description       TODO 根据条件进行聚合查询
     *
     * @param condition 条件
     * @return 最终查询的TypedQuery的对象
     * @throws NoSuchMethodException     modelToExpression方法抛出的异常
     * @throws IllegalAccessException    modelToExpression方法抛出的异常
     * @throws InvocationTargetException modelToExpression方法抛出的异常
     * @throws ComposeException          composeExpression方法抛出的异常
     */
    @SuppressWarnings({"unchecked"})
    private TypedQuery<Tuple> AggregationByCondition(QueryCondition condition, Class<E> clazz)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            ComposeException {

        List<Order> orders = new ArrayList<>();
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
        Root<E> root = cq.from(clazz);
        ExpressionUtil expressionUtil = new ExpressionUtil(cb);

        List<Join> joins = new ArrayList<>();

        /*
         *	用元模型的属性替换条件表达式中的实体属性的静态字符串
         */
        modelToExpression(root, condition.getExpression(), true, joins);
        /*
         *  用元模型的属性替代求和字段的静态字符串
         */
        for (AggregationColumnField field : condition.getAggregationFields()) {
            modelToExpression(root, field.getExpression(), false, joins);
            modelToExpression(root, field.getWhenCondition(), true, joins);
        }
        /*
         * 用元模型属性替代分组字段的静态字符串
         */
        for (GroupField groupField : condition.getGroupFields()) {
            modelToField(root, groupField, joins);
        }

        /*
         *  用元模型属性替换排序字符串
         */
        modelToOrder(root, clazz, condition.getOrders());


        if (condition.getExpression() != null) {
            Predicate predicate = expressionUtil.composeExpression(condition.getExpression());
            cq.where(predicate);
        }

        /*
         *  合并条件表达式
         */
        List<Selection<?>> selections = new ArrayList<>();
        for (AggregationColumnField field : condition.getAggregationFields()) {

            Expression expression = expressionUtil.composeExpression(field.getExpression());

            if (field.getWhenCondition() != null) {
                Predicate predicate = expressionUtil.composeExpression(field.getWhenCondition());
                expression = cb.selectCase().when(predicate, expression).otherwise(0);
            }

            switch (field.getAggregationType()) {
                case Sum:
                    selections.add(cb.sum(expression).alias(field.getAlias()));
                    break;
                case Avg:
                    selections.add(cb.avg(expression).alias(field.getAlias()));
                    break;
                case Count:
                    selections.add(cb.count(expression).alias(field.getAlias()));
                    break;
                case None:
                    selections.add(expression.alias(field.getAlias()));
                    break;
            }
        }


        List<Expression<?>> expressions = new ArrayList<>();
        if (condition.getGroupFields() != null) {
            for (GroupField field : condition.getGroupFields()) {
                Expression expression = (Expression) field.getExpression();

                if (field.getQueryGroupDate() != null) {
                    expression = expressionUtil.getYMDExpression(field.getQueryGroupDate(), expression);
                }
                expressions.add(expression);
                selections.add(expression.alias(field.getAlias()));
            }
        }
        //分组字段放入cq中
        cq.groupBy(expressions);
        cq.orderBy(orders);
        cq.multiselect(selections);
        return em.createQuery(cq);

    }


    /**
     * @param condition TODO 返回符合条件的记录数量
     * @param clazz     对象的类型
     * @return 符合的实体数量
     * @throws NoSuchMethodException     modelToExpression抛出的异常
     * @throws IllegalAccessException    modelToExpression抛出的异常
     * @throws InvocationTargetException modelToExpression抛出的异常
     * @throws ComposeException          composeExpression抛出的异常
     */
    private int CountByCondition(QueryCondition condition, Class<E> clazz) throws
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, ComposeException {

        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<E> root = cq.from(clazz);

        modelToExpression(root, condition.getExpression(), true, null);

        if (condition.getExpression() != null) {
            Predicate predicate = new ExpressionUtil(cb).composeExpression(condition.getExpression());
            cq.where(predicate);
        }

        cq.select(cb.countDistinct(root));
        return em.createQuery(cq).getSingleResult().intValue();

    }


    /**
     * 通过构造方法指定DAO的具体实现类
     */

    public DaoImpl() {


    }


    /**
     * 新增实体
     */
    @Override
    public E save(E entity) {
        return em.merge(entity);
    }


    @Override
    public void remove(E entity) {
        em.remove(em.merge(entity));
    }


    @Override
    public E update(E entity) {
        return em.merge(entity);
    }


    @Override
    public E findById(K id, Class<E> clazz) {

        return em.find(clazz, id);

    }


    @Override
    public List<E> getAll(Class<E> clazz)
            throws InvocationTargetException, NoSuchMethodException, ComposeException, IllegalAccessException {

        QueryCondition conditions = new QueryCondition();
        return findByCondition(conditions, clazz).getResultList();
    }


    @Override
    public List<E> findByFieldAll(String field, Object value, Class<E> clazz)
            throws InvocationTargetException, NoSuchMethodException, ComposeException, IllegalAccessException {

        QueryCondition conditions = new QueryCondition();
        conditions.setExpression(new Object[]{field, "=", value});
        return findByCondition(conditions, clazz).getResultList();
    }

    @Override
    public E findByFieldSingle(String field, Object value, Class<E> clazz) {
        QueryCondition conditions = new QueryCondition();
        conditions.setExpression(new Object[]{field, "=", value});
        try {
            return findByCondition(conditions, clazz).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public E findByConditionSingle(QueryCondition conditions, Class<E> clazz)
            throws InvocationTargetException, NoSuchMethodException, ComposeException, IllegalAccessException {
        return findByCondition(conditions, clazz).setMaxResults(1).getSingleResult();

    }


    @Override
    public List<E> findByConditionAll(QueryCondition condition, Class<E> clazz) throws Exception {

        if (condition.getSelectFields() != null && condition.getSelectFields().length > 0) {
            return convertEntity(findByCondition(condition, clazz), clazz, condition.getSelectFields());
        } else {
            return findByCondition(condition, clazz).getResultList();
        }

    }

    @Override
    public int findCountByCondition(QueryCondition conditions, Class<E> clazz)
            throws InvocationTargetException, NoSuchMethodException, ComposeException, IllegalAccessException {
        return CountByCondition(conditions, clazz);
    }


    @Override
    public List<Map<String, Object>> findAggregationByCondition(QueryCondition conditions, Class<E> clazz)
            throws InvocationTargetException, NoSuchMethodException, ComposeException, IllegalAccessException {

        List<Tuple> tuples = AggregationByCondition(conditions, clazz).getResultList();
        List<Map<String, Object>> records = new ArrayList<>();
        Map<String, Object> record;

        for (int i = 0; i < tuples.size(); i++) {

            record = new HashMap<>();
            record.put("id", i);
            for (ColumnField field : conditions.getAggregationFields()) {
                record.put(field.getAlias(), tuples.get(i).get(field.getAlias()));
            }
            if (conditions.getGroupFields() != null) {
                for (GroupField field : conditions.getGroupFields()) {

                    if (tuples.get(i).get(field.getAlias()) != null) {
                        record.put(field.getAlias(), tuples.get(i).get(field.getAlias()).toString());
                    } else {
                        record.put(field.getAlias(), null);
                    }
                }
            }
            if (conditions.getGroupFields() != null && conditions.getGroupFields().size() > 0) {
                GroupField field = conditions.getGroupFields().get(0);
                Object rowValue = tuples.get(i).get(field.getAlias());
                if (rowValue != null && !"".equals(rowValue)) {
                    records.add(record);
                }
            } else {
                records.add(record);
            }
        }
        return records;
    }


    @Override
    public int removeByCondition(QueryCondition condition, Class<E> clazz) {
        String alias = " " + clazz.getSimpleName().toLowerCase();
        StringBuilder jpql = new StringBuilder("delete from " + clazz.getSimpleName() + alias);
        String[] fdNames = new String[condition.getExpression().length / 2];
        Object[] values = new Object[condition.getExpression().length / 2];
        int paramsCount = 0;
        /*
         * 将条件数组{flightNumber,=,CA1980,And,execDate,=,1979/09/06}
         * 转换为JPQL字符串"flight.flightNumber=:flightNumber And flight.execDate=:execDate"
         */
        if (condition.getExpression() != null && condition.getExpression().length >= 3) {
            jpql.append(" where");
            int pos = 1;
            for (Object pam : condition.getExpression()) {
                if (pos > 3) {
                    pos = 0;
                }
                switch (pos % 4) {
                    case 0:  /* AND OR */
                        jpql.append(" ");
                        jpql.append(pam);
                        break;
                    case 1:/* 字段名*/
                        jpql.append(alias);
                        jpql.append(".");
                        jpql.append(pam.toString());
                        fdNames[paramsCount] = pam.toString() + paramsCount;
                        break;
                    case 2:  /* >= <= <> = */

                        jpql.append(pam);
                        break;
                    case 3:/* 参数 */
                        jpql.append(":");
                        jpql.append(fdNames[paramsCount]);
                        values[paramsCount] = pam;
                        paramsCount = paramsCount + 1;
                        break;
                }
                pos++;
            }
        }
        Query query = em.createQuery(jpql.toString());
        /*
         * 将数值传入Query的参数中
         */
        for (int i = 0; i < paramsCount; i++) {
            if (values[i] instanceof Date) {
                query.setParameter(fdNames[i], values[i]);
            } else {
                query.setParameter(fdNames[i], values[i]);
            }
        }
        return query.executeUpdate();

    }


}
