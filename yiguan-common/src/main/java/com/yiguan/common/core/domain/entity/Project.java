package com.yiguan.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 16:14
  */
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="project_name")
    private String projectName;

    @Column(name = "manage_unit")
    private String manageUnit;

    @Column(name = "job_unit")
    private String jobUnit;

    @Column(name = "risk_level")
    private String riskLevel;

    @Column(name = "job_supervisor")
    private String jobSupervisor;

    @Column(name = "job_user")
    private String jobUser;

    @Column(name = "job_content")
    private String jobContent;

    @Column(name = "job_address")
    private String jobAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "plan_start_time")
    private Date planStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "plan_end_time")
    private Date planEndTime;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getManageUnit() {
        return manageUnit;
    }

    public void setManageUnit(String manageUnit) {
        this.manageUnit = manageUnit;
    }

    public String getJobUnit() {
        return jobUnit;
    }

    public void setJobUnit(String jobUnit) {
        this.jobUnit = jobUnit;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getJobSupervisor() {
        return jobSupervisor;
    }

    public void setJobSupervisor(String jobSupervisor) {
        this.jobSupervisor = jobSupervisor;
    }

    public String getJobUser() {
        return jobUser;
    }

    public void setJobUser(String jobUser) {
        this.jobUser = jobUser;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
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
