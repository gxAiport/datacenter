package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.CustomerType;
import com.gxairport.ais.enums.aodb.GoodsType;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.*;

/**
 * TypeName GoodsDepartureCount
 * Description  TODO  出港货物开票统计实体类
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018年9月4日      ZhangYu    1.0        1.0
 * <p>Why  What is modified:
 */
@Entity
@Table(name = "History_DepartureCheckCount")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_DepCheckCount", allocationSize = 1)
public class HistoryDepartureCheckCount extends IntIdEntity {

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
    public static final String CHECK_NUMBER = "checkNumber";
    public static final String WEIGHT = "weight";
    public static final String DESTINATION_IATA_CODE = "destinationIATACode";
    public static final String FIRST_IATA_CODE = "firstIATACode";


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
     * 开单数
     */
    private int checkNumber;
    /**
     * 重量
     */
    private int goodsWeight;

    /**
     * 物流目的地IATA代码
     */
    @Column(length = 10)
    private String destinationIATACode;

    /**
     * 物流第一站IATA代码
     */
    @Column(length = 10)
    private String firstIATACode;

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

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
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

    public String getFirstIATACode() {
        return firstIATACode;
    }

    public void setFirstIATACode(String firstIATACode) {
        this.firstIATACode = firstIATACode;
    }
}
