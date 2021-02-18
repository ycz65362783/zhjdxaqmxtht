package com.yiguan.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 地图
  *@Author 俞晨钟
  *@Date: Created in 2020/12/29 16:09
  */
@Table(name = "map_info")
public class MapInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="map_info_name")
    private String mapInfoName;

    @Column(name = "map_info_type")
    private Integer mapInfoType;

    @Column(name = "own_company")
    private String ownCompany;

    @Column(name = "job_supervisor")
    private String jobSupervisor;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_edit_time")
    private Date lastEditTime;

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

    public String getMapInfoName() {
        return mapInfoName;
    }

    public void setMapInfoName(String mapInfoName) {
        this.mapInfoName = mapInfoName;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
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

    public Integer getMapInfoType() {
        return mapInfoType;
    }

    public void setMapInfoType(Integer mapInfoType) {
        this.mapInfoType = mapInfoType;
    }

    public String getOwnCompany() {
        return ownCompany;
    }

    public void setOwnCompany(String ownCompany) {
        this.ownCompany = ownCompany;
    }

    public String getJobSupervisor() {
        return jobSupervisor;
    }

    public void setJobSupervisor(String jobSupervisor) {
        this.jobSupervisor = jobSupervisor;
    }
}
