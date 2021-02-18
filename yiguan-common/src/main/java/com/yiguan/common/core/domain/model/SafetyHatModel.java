package com.yiguan.common.core.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 安全帽
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 9:56
  */
@Setter
@Getter
public class SafetyHatModel {
    private String id;

    private String safetyHatName;

    private String safetyHatNo;

    private String bindUserId;

    private String bindUserName;

    private String ownCompany;

    private String teamGroup;

    private Integer onlineStatus;

    private String bindRFID;

    private String bindUWB;

    private String batteryVoltage;

    private String remainingElectricity;

    private String batteryThreshold;

    private String deviceParam;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updateBy;

    private String isDeleted;

}
