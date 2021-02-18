package com.yiguan.common.core.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 16:14
  */
@Getter
@Setter
public class ProjectModel {

    private String id;

    private String projectName;

    private String manageUnit;

    private String jobUnit;

    private String riskLevel;

    private String jobSupervisor;

    private String jobSupervisorName;

    private String jobUser;

    private String jobUserName;

    private String jobContent;

    private String jobAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planEndTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updateBy;

    private String isDeleted;

}
