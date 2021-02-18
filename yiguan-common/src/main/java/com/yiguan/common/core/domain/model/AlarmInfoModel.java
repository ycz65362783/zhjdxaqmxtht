package com.yiguan.common.core.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 报警信息
  *@Author 俞晨钟
  *@Date: Created in 2020/12/29 16:09
  */
@Getter
@Setter
public class AlarmInfoModel {

    private String id;

    private String ownCompany;

    private String workUnit;

    private String jobSupervisor;

    private String jobSupervisorName;

    private String alarmPicture;

    private String alarmContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime alarmTime;

    private String alarmSource;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updateBy;

    private String isDeleted;

    private Integer projectId;

    private String projectName;

}
