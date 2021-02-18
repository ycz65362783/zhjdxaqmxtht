package com.yiguan.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 接地线
  *@Author 俞晨钟
  *@Date: Created in 2020/12/28 14:56
  */
@Table(name = "ground_lead")
public class GroundLead {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="ground_lead_name")
    private String groundLeadName;

    @Column(name = "ground_lead_type")
    private Integer groundLeadType;

    @Column(name = "ground_lead_no")
    private String groundLeadNo;

    //挂接点名称
    @Column(name = "mount_point_id")
    private Integer mountPointId;

    @Column(name = "mount_point_name")
    private String mountPointName;

    @Column(name = "online_status")
    private Integer onlineStatus;

    /**
     * 接地线操作员
     */
    @Column(name = "job_user_id")
    private Integer jobUserId;

    @Column(name = "bind_UWB")
    private String bindUWB;

    @Column(name = "own_company")
    private String ownCompany;

    @Column(name = "team_group")
    private String teamGroup;

    /**
     * 电压等级
     */
    @Column(name = "battery_voltage_level")
    private String batteryVoltageLevel;

    @Column(name = "lifecycle")
    private String lifecycle;

    /**
     * 剩余电量
     */
    @Column(name = "remaining_electricity")
    private String remainingElecticity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "production_date")
    private Date productionDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "trial_date")
    private Date trialDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "next_trial_date")
    private Date nextTrialDate;

    /**
     * 电池欠压门槛
     */
    @Column(name = "battery_voltage_threshold")
    private String batteryVoltageThreshold;
    /**
     * 挂接偏差门槛
     */
    @Column(name = "hook_threshold")
    private String hookThreshold;

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

    @Column(name = "project_id")
    private String projectId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroundLeadName() {
        return groundLeadName;
    }

    public void setGroundLeadName(String groundLeadName) {
        this.groundLeadName = groundLeadName;
    }

    public Integer getGroundLeadType() {
        return groundLeadType;
    }

    public void setGroundLeadType(Integer groundLeadType) {
        this.groundLeadType = groundLeadType;
    }

    public String getGroundLeadNo() {
        return groundLeadNo;
    }

    public void setGroundLeadNo(String groundLeadNo) {
        this.groundLeadNo = groundLeadNo;
    }

    public Integer getMountPointId() {
        return mountPointId;
    }

    public void setMountPointId(Integer mountPointId) {
        this.mountPointId = mountPointId;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Integer getJobUserId() {
        return jobUserId;
    }

    public void setJobUserId(Integer jobUserId) {
        this.jobUserId = jobUserId;
    }

    public String getBindUWB() {
        return bindUWB;
    }

    public void setBindUWB(String bindUWB) {
        this.bindUWB = bindUWB;
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

    public String getBatteryVoltageLevel() {
        return batteryVoltageLevel;
    }

    public void setBatteryVoltageLevel(String batteryVoltageLevel) {
        this.batteryVoltageLevel = batteryVoltageLevel;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getRemainingElecticity() {
        return remainingElecticity;
    }

    public void setRemainingElecticity(String remainingElecticity) {
        this.remainingElecticity = remainingElecticity;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getTrialDate() {
        return trialDate;
    }

    public void setTrialDate(Date trialDate) {
        this.trialDate = trialDate;
    }

    public Date getNextTrialDate() {
        return nextTrialDate;
    }

    public void setNextTrialDate(Date nextTrialDate) {
        this.nextTrialDate = nextTrialDate;
    }

    public String getHookThreshold() {
        return hookThreshold;
    }

    public void setHookThreshold(String hookThreshold) {
        this.hookThreshold = hookThreshold;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getBatteryVoltageThreshold() {
        return batteryVoltageThreshold;
    }

    public void setBatteryVoltageThreshold(String batteryVoltageThreshold) {
        this.batteryVoltageThreshold = batteryVoltageThreshold;
    }

    public String getMountPointName() {
        return mountPointName;
    }

    public void setMountPointName(String mountPointName) {
        this.mountPointName = mountPointName;
    }

}
