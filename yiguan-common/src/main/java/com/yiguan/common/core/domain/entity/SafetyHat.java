package com.yiguan.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 安全帽
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 9:56
  */
@Table(name = "safety_hat")
public class SafetyHat {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "safety_hat_name")
    private String safetyHatName;

    @Column(name = "safety_hat_no")
    private String safetyHatNo;

    @Column(name="bind_user_id")
    private String bindUserId;

    @Column(name = "own_company")
    private String ownCompany;

    @Column(name = "team_group")
    private String teamGroup;

    @Column(name = "online_status")
    private Integer onlineStatus;

    @Column(name = "bind_RFID")
    private String bindRFID;

    @Column(name = "bind_UWB")
    private String bindUWB;

    @Column(name = "battery_voltage")
    private String batteryVoltage;

    @Column(name = "remaining_electricity")
    private String remainingElectricity;
    /**
     * 电压欠压门槛
     */
    @Column(name = "battery_threshold")
    private String batteryThreshold;

    @Column(name = "device_param")
    private String deviceParam;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_by")
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "is_deleted")
    private String isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBindUserId() {
        return bindUserId;
    }

    public void setBindUserId(String bindUserId) {
        this.bindUserId = bindUserId;
    }

    public String getSafetyHatName() {
        return safetyHatName;
    }

    public void setSafetyHatName(String safetyHatName) {
        this.safetyHatName = safetyHatName;
    }


    public String getOwnCompany() {
        return ownCompany;
    }

    public void setOwnCompany(String ownCompany) {
        this.ownCompany = ownCompany;
    }

    public String getTeamGroup() {
        return teamGroup;
    }

    public void setTeamGroup(String teamGroup) {
        this.teamGroup = teamGroup;
    }

    public String getBindRFID() {
        return bindRFID;
    }

    public void setBindRFID(String bindRFID) {
        this.bindRFID = bindRFID;
    }

    public String getBindUWB() {
        return bindUWB;
    }

    public void setBindUWB(String bindUWB) {
        this.bindUWB = bindUWB;
    }

    public String getBatteryThreshold() {
        return batteryThreshold;
    }

    public void setBatteryThreshold(String batteryThreshold) {
        this.batteryThreshold = batteryThreshold;
    }

    public String getDeviceParam() {
        return deviceParam;
    }

    public void setDeviceParam(String deviceParam) {
        this.deviceParam = deviceParam;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getSafetyHatNo() {
        return safetyHatNo;
    }

    public void setSafetyHatNo(String safetyHatNo) {
        this.safetyHatNo = safetyHatNo;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(String batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public String getRemainingElectricity() {
        return remainingElectricity;
    }

    public void setRemainingElectricity(String remainingElectricity) {
        this.remainingElectricity = remainingElectricity;
    }


}
