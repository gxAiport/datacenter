package com.gxairport.ais.models;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * FileName      DefaultEntity.java
 * Description  TODO  实体类原始父类
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月11日
 * ModificationHistory
 * Date         Author     Version        Description
 * <p>---------------------------------------------
 * <p>2017年6月11日      ZhangYu    1.0   create
 * <p>Why  What is modified:
 */

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class DefaultEntity implements Serializable {

    /**
     * Description: TODO 获取实体类的主键
     *
     * @return 返回实体类的主键
     */
    public abstract Object getIdValue();


    /**
     * Description: TODO 重写的equals方法
     *
     * @param entity 比较对象
     * @return 真假
     */
    @Override
    public boolean equals(Object entity) {
        if (entity != null && DefaultEntity.class.isAssignableFrom(entity.getClass())) {
            /*
             *  如果obj和Entity是实体类，比较两个Id
             */
            return (this.getIdValue().equals(((DefaultEntity) entity).getIdValue()));
        }
        /*
         *  否则用父类的方法进行比较，一般是比较内存地址
         */
        return super.equals(entity);
    }


}
