package com.gxairport.ais.models.aodb.flight.collection;

import com.gxairport.ais.enums.aodb.PassengerCardLevel;
import com.gxairport.ais.models.IntIdEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * TypeName      DynamicFlight.BasicLoad.BasicPayPassenger
 * Description  付费旅客名单的实体类
 */
@MappedSuperclass
public abstract class BasicPayPassenger extends IntIdEntity {
    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String NAME = "name";
    public static final String TICKET_NO = "ticketNo";
    public static final String CARD_NUMBER = "cardNumber";
    public static final String CLASS_LEVEL = "classLevel";
    public static final String CARD_LEVEL = "cardLevel";
    public static final String COST = "cost";


    /**
     * 姓名
     */
    @Column(length = 32)
    protected String name;
    /**
     * 票号
     */
    @Column(length = 32)
    private String ticketNumber;
    /**
     * 卡号
     */
    @Column(length = 32)
    private String cardNumber;
    /**
     * 舱位等级
     */
    @Column(length = 1)
    private String classLevel;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private PassengerCardLevel cardLevel;
    /**
     * 费用
     */
    private Integer cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public PassengerCardLevel getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(PassengerCardLevel cardLevel) {
        this.cardLevel = cardLevel;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


}
