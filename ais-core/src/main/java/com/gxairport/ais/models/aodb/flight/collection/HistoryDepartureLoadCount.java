package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.CustomerType;
import com.gxairport.ais.enums.aodb.GoodsType;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.*;

/**
 * TypeName GoodsDepartureCount
 * Description  TODO  货物出港载量统计实体类
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018年9月4日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */
@Entity
@Table(name = "History_DepartureLoadCount")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DepLoadCount", allocationSize = 1)
public class HistoryDepartureLoadCount extends IntIdEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String CUSTOMER = "customer";
    public static final String CUSTOMER_TYPE = "customerType";
    public static final String GOODS_TYPE = "goodsType";
    public static final String NUMBER = "number";
    public static final String DESTINATION_IATA_CODE = "destinationIATACode";
    public static final String WEIGHT = "weight";

    /**
     * 客户
     */
    @Column(length = 32)
    private String customer;
    /**
     * 客户类型
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    /**
     * 货物类别
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private GoodsType goodsType;
    /**
     * 件数
     */
    private int goodsNumber;
    /**
     * 重量
     */
    private int goodsWeight;
    /**
     * 物流目的地IATA代码
     */
    @Column(length = 10)
    private String destinationIATACode;


    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int number) {
        this.goodsNumber = number;
    }

    public int getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(int weight) {
        this.goodsWeight = weight;
    }

    public String getDestinationIATACode() {
        return destinationIATACode;
    }

    public void setDestinationIATACode(String destinationIATACode) {
        this.destinationIATACode = destinationIATACode;
    }
}
