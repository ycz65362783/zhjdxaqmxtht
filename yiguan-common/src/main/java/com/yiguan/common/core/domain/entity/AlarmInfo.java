package com.yiguan.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 报警信息
  *@Author 俞晨钟
  *@Date: Created in 2020/12/29 16:09
  */
@Table(name = "alarm_info")
public class AlarmInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="own_company")
    private String ownCompany;

    @Column(name="work_unit")
    private String workUnit;

    @Column(name="job_supervisor")
    private String jobSupervisor;

    @Column(name="alarm_picture")
    private String alarmPicture;

    @Column(name="alarm_content")
    private String alarmContent;

    @Column(name="alarm_time")
    private LocalDateTime alarmTime;

    @Column(name="alarm_source")
    private String alarmSource;

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
    private Integer projectId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnCompany() {
        return ownCompany;
    }

    public void setOwnCompany(String ownCompany) {
        this.ownCompany = ownCompany;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getJobSupervisor() {
        return jobSupervisor;
    }

    public void setJobSupervisor(String jobSupervisor) {
        this.jobSupervisor = jobSupervisor;
    }

    public String getAlarmPicture() {
        return alarmPicture;
    }

    public void setAlarmPicture(String alarmPicture) {
        this.alarmPicture = alarmPicture;
    }

    public String getAlarmContent() {
        return alarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }

    public LocalDateTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(LocalDateTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmSource() {
        return alarmSource;
    }

    public void setAlarmSource(String alarmSource) {
        this.alarmSource = alarmSource;
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
