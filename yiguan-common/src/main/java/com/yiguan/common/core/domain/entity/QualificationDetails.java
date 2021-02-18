package com.yiguan.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
@Table(name = "qualification_details")
public class QualificationDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "job_user_id")
    private String jobUserId;

    @Column(name="safety_certificate")
    private String safetyCertificate;

    @Column(name="special_work_certificate")
    private String specialWorkCertificate;

    @Column(name = "safety_event")
    private String safetyEvent;

    @Column(name = "endorsement")
    private String endorsement;

    @Column(name = "safety_record")
    private String safetyRecord;

    @Column(name = "create_by")
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

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

    public String getJobUserId() {
        return jobUserId;
    }

    public void setJobUserId(String jobUserId) {
        this.jobUserId = jobUserId;
    }

    public String getSafetyCertificate() {
        return safetyCertificate;
    }

    public void setSafetyCertificate(String safetyCertificate) {
        this.safetyCertificate = safetyCertificate;
    }

    public String getSpecialWorkCertificate() {
        return specialWorkCertificate;
    }

    public void setSpecialWorkCertificate(String specialWorkCertificate) {
        this.specialWorkCertificate = specialWorkCertificate;
    }

    public String getSafetyEvent() {
        return safetyEvent;
    }

    public void setSafetyEvent(String safetyEvent) {
        this.safetyEvent = safetyEvent;
    }

    public String getEndorsement() {
        return endorsement;
    }

    public void setEndorsement(String endorsement) {
        this.endorsement = endorsement;
    }

    public String getSafetyRecord() {
        return safetyRecord;
    }

    public void setSafetyRecord(String safetyRecord) {
        this.safetyRecord = safetyRecord;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
