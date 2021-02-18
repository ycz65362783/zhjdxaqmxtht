package com.yiguan.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 作业用户
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 16:14
  */
@Table(name = "job_user")
public class JobUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="job_user_name")
    private String jobUserName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "join_job_date")
    private Date joinJobDate;

    @Column(name = "national")
    private String national;

    @Column(name = "native_place")
    private String nativePlace;

    @Column(name = "school_record")
    private String school_record;

    @Column(name = "political_landspace")
    private String politicalLandSpace;

    @Column(name = "professional_title")
    private String professionalTitle;

    @Column(name = "post")
    private String post;

    @Column(name = "team_group")
    private String teamGroup;

    @Column(name = "work_unit")
    private String workUnit;

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

    public String getJobUserName() {
        return jobUserName;
    }

    public void setJobUserName(String jobUserName) {
        this.jobUserName = jobUserName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getJoinJobDate() {
        return joinJobDate;
    }

    public void setJoinJobDate(Date joinJobDate) {
        this.joinJobDate = joinJobDate;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getSchool_record() {
        return school_record;
    }

    public void setSchool_record(String school_record) {
        this.school_record = school_record;
    }

    public String getPoliticalLandSpace() {
        return politicalLandSpace;
    }

    public void setPoliticalLandSpace(String politicalLandSpace) {
        this.politicalLandSpace = politicalLandSpace;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTeamGroup() {
        return teamGroup;
    }

    public void setTeamGroup(String teamGroup) {
        this.teamGroup = teamGroup;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
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
