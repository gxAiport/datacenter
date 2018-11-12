package com.gxairport.ais.models.general;

import com.gxairport.ais.models.IntIdEntity;

import java.util.Date;

import javax.persistence.*;


/**
 * FileName      IBMessage.java
 * Description  TODO  IB消息实体类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2018年11月7日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2018年11月7日      ZhangYu    1.0     create
 * Why  What is modified:
 */


@Entity
@Table(name = "IBMessage")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "SEQ_IbMsg", allocationSize = 1)
public class IBMessage extends IntIdEntity {


    public static final String MESSAGE_SEQUENCE_NUMBER = "messageSequenceNumber";
    public static final String MESSAGE_TYPE = "messageType";
    public static final String SOURCE_SYSTEM_ID = "sourceSystemID";
    public static final String DESTINATION_SYSTEM_ID = "destinationSystemID";
    public static final String MESSAGE_ORIGINATOR_ID = "messageOriginatorID";
    public static final String MESSAGE_SENT_DATETIME = "messageSentDateTime";
    public static final String ORIGINATOR_DATETIME = "originatorDateTime";
    public static final String CONTENT = "content";
    public static final String PROCESSED = "processed";

    /**
     * 发送序列号
     */
    private int messageSequenceNumber;

    /**
     * 消息类型
     */
    @Column(length = 35)
    private String messageType;

    /**
     * 发送系统
     */
    @Column(length = 35)
    private String sourceSystemID;

    /**
     * 目标系统
     */
    @Column(length = 35)
    private String destinationSystemID;


    /**
     * 消息原系统
     */
    @Column(length = 35)
    private String messageOriginatorID;

    /**
     * 发送时间
     */
    private Date messageSentDateTime;


    /**
     * 原系统时间
     */
    private Date originatorDateTime;


    /**
     * 内容
     */
    @Lob
    private String content;

    /**
     * 处理标志
     */
    private boolean processed;

    /**
     * @return the messageSequenceNumber
     */
    public int getMessageSequenceNumber() {
        return messageSequenceNumber;
    }


    /**
     * @param messageSequenceNumber the messageSequenceNumber to set
     */
    public void setMessageSequenceNumber(int messageSequenceNumber) {
        this.messageSequenceNumber = messageSequenceNumber;
    }


    /**
     * @return the messageType
     */
    public String getMessageType() {
        return messageType;
    }


    /**
     * @param messageType the messageType to set
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }


    /**
     * @return the sourceSystemID
     */
    public String getSourceSystemID() {
        return sourceSystemID;
    }


    /**
     * @param sourceSystemID the sourceSystemID to set
     */
    public void setSourceSystemID(String sourceSystemID) {
        this.sourceSystemID = sourceSystemID;
    }


    /**
     * @return the destinationSystemID
     */
    public String getDestinationSystemID() {
        return destinationSystemID;
    }


    /**
     * @param destinationSystemID the destinationSystemID to set
     */
    public void setDestinationSystemID(String destinationSystemID) {
        this.destinationSystemID = destinationSystemID;
    }


    /**
     * @return the messageOriginatorID
     */
    public String getMessageOriginatorID() {
        return messageOriginatorID;
    }


    /**
     * @param messageOriginatorID the messageOriginatorID to set
     */
    public void setMessageOriginatorID(String messageOriginatorID) {
        this.messageOriginatorID = messageOriginatorID;
    }


    /**
     * @return the messageSentDateTime
     */
    public Date getMessageSentDateTime() {
        return messageSentDateTime;
    }


    /**
     * @param messageSentDateTime the messageSentDateTime to set
     */
    public void setMessageSentDateTime(Date messageSentDateTime) {
        this.messageSentDateTime = messageSentDateTime;
    }


    /**
     * @return the originatorDateTime
     */
    public Date getOriginatorDateTime() {
        return originatorDateTime;
    }


    /**
     * @param originatorDateTime the originatorDateTime to set
     */
    public void setOriginatorDateTime(Date originatorDateTime) {
        this.originatorDateTime = originatorDateTime;
    }


    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }


    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }


    public boolean isProcessed() {
        return processed;
    }


    public void setProcessed(boolean processed) {
        this.processed = processed;
    }


}
