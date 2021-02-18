package com.yiguan.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 工器具库房
  *@Author 俞晨钟
  *@Date: Created in 2020/12/28 14:56
  */
@Table(name = "appliance_store")
public class ApplianceStore {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "ground_lead_id")
    private String groundLeadId;

    @Column(name="status")
    private String status;

    @Column(name="voltage_level")
    private Integer voltageLevel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="production_date")
    private LocalDateTime productionDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "trial_date")
    private LocalDateTime trialDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "next_trial_date")
    private LocalDateTime nextTrialDate;

    @Column(name = "lifecycle")
    private String lifecycle;

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

    public String getGroundLeadId() {
        return groundLeadId;
    }

    public void setGroundLeadId(String groundLeadId) {
        this.groundLeadId = groundLeadId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(Integer voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDateTime getTrialDate() {
        return trialDate;
    }

    public void setTrialDate(LocalDateTime trialDate) {
        this.trialDate = trialDate;
    }

    public LocalDateTime getNextTrialDate() {
        return nextTrialDate;
    }

    public void setNextTrialDate(LocalDateTime nextTrialDate) {
        this.nextTrialDate = nextTrialDate;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
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
}
