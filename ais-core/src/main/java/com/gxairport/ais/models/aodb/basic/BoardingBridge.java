package com.gxairport.ais.models.aodb.basic;


import com.gxairport.ais.enums.aodb.ResourceStatusCode;
import com.gxairport.ais.models.DefaultEntity;


import javax.persistence.*;
import java.util.Date;

/**
 * FileName      BoardingBridge.java
 * Description  TODO 廊桥的实体类
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2017年6月13日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月13日      ZhangYu    1.0   create
 * Why  What is modified:
 */

@Entity
@Table(name = "BoardingBridge")
public class BoardingBridge extends DefaultEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 各个数据字段名,用来调用点用字段名
     */
    public static final String BRIDGE_ID = "bridgeID";
    public static final String DESCRIPTION = "description";
    public static final String TERMINAL = "terminal";
    public static final String STATUS_GENERAL = "statusGeneral";
    public static final String STATUS_GENERAL_START_DATETIME = "statusGeneralStartDateTime";
    public static final String STATUS_GENERAL_END_DATETIME = "statusGeneralEndDateTime";
    public static final String STATUS_PCA = "statusPCA;";
    public static final String STATUS_PCA_START_DATETIME = "statusPCAStartDateTime";
    public static final String STATUS_PCA_END_DATETIME = "statusPCAEndDateTime";
    public static final String STATUS_POWER = "statusPower";
    public static final String STATUS_POWER_START_DATETIME = "statusPowerStartDateTime";
    public static final String STATUS_POWER_END_DATETIME = "statusPowerEndDateTime";

    /**
     * 廊桥ID
     */
    @Id
    @Column(length = 15)
    private String bridgeID;
    /**
     * 廊桥描述
     */
    @Column(length = 64)
    private String description;
    /**
     * 所属航站楼
     */
    @ManyToOne
    private Terminal terminal;
    /**
     * 廊桥状态
     */
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private ResourceStatusCode statusGeneral;
    /**
     * 廊桥状态开始时间
     */
    private Date statusGeneralStartDateTime;
    /**
     * 廊桥状态结束时间
     */
    private Date statusGeneralEndDateTime;
    /**
     * 廊桥PCA状态
     */
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private ResourceStatusCode statusPCA;
    /**
     * 廊桥PCA状态开始时间
     */
    private Date statusPCAStartDateTime;
    /**
     * 廊桥PCA状态结束时间
     */
    private Date statusPCAEndDateTime;
    /**
     * 廊桥Power状态
     */
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private ResourceStatusCode statusPower;
    /**
     * 廊桥Power状态开始时间
     */
    private Date statusPowerStartDateTime;
    /**
     * 廊桥Power状态结束时间
     */
    private Date statusPowerEndDateTime;

    public String getBridgeID() {
        return bridgeID;
    }

    public void setBridgeID(String bridgeID) {
        this.bridgeID = bridgeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public ResourceStatusCode getStatusGeneral() {
        return statusGeneral;
    }

    public void setStatusGeneral(ResourceStatusCode statusGeneral) {
        this.statusGeneral = statusGeneral;
    }

    public Date getStatusGeneralStartDateTime() {
        return statusGeneralStartDateTime;
    }

    public void setStatusGeneralStartDateTime(Date statusGeneralStartDateTime) {
        this.statusGeneralStartDateTime = statusGeneralStartDateTime;
    }

    public Date getStatusGeneralEndDateTime() {
        return statusGeneralEndDateTime;
    }

    public void setStatusGeneralEndDateTime(Date statusGeneralEndDateTime) {
        this.statusGeneralEndDateTime = statusGeneralEndDateTime;
    }

    public ResourceStatusCode getStatusPCA() {
        return statusPCA;
    }

    public void setStatusPCA(ResourceStatusCode statusPCA) {
        this.statusPCA = statusPCA;
    }

    public Date getStatusPCAStartDateTime() {
        return statusPCAStartDateTime;
    }

    public void setStatusPCAStartDateTime(Date statusPCAStartDateTime) {
        this.statusPCAStartDateTime = statusPCAStartDateTime;
    }

    public Date getStatusPCAEndDateTime() {
        return statusPCAEndDateTime;
    }

    public void setStatusPCAEndDateTime(Date statusPCAEndDateTime) {
        this.statusPCAEndDateTime = statusPCAEndDateTime;
    }

    public ResourceStatusCode getStatusPower() {
        return statusPower;
    }

    public void setStatusPower(ResourceStatusCode statusPower) {
        this.statusPower = statusPower;
    }

    public Date getStatusPowerStartDateTime() {
        return statusPowerStartDateTime;
    }

    public void setStatusPowerStartDateTime(Date statusPowerStartDateTime) {
        this.statusPowerStartDateTime = statusPowerStartDateTime;
    }

    public Date getStatusPowerEndDateTime() {
        return statusPowerEndDateTime;
    }

    public void setStatusPowerEndDateTime(Date statusPowerEndDateTime) {
        this.statusPowerEndDateTime = statusPowerEndDateTime;
    }

    @Override
    public Object getIdValue() {
        // TODO Auto-generated method stub
        return this.bridgeID;
    }


}
