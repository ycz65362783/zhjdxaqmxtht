package com.yiguan.common.core.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.MountPoint;
import com.yiguan.common.core.redis.RedisCache;
import com.yiguan.common.utils.DictUtils;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 接地线
  *@Author 俞晨钟
  *@Date: Created in 2020/12/28 14:56
  */
@Getter
@Setter
public class GroundLeadModel {

    private String id;

    private String groundLeadName;

    private Integer groundLeadType;

    private String groundLeadNo;

    private String mountPointName;

    private Integer onlineStatus;

    /**
     * 接地线操作员
     */
    private Integer jobUserId;

    private String jobUserName;

    private String bindUWB;

    private String ownCompany;

    private String teamGroup;

    /**
     * 电压等级
     */
    private String batteryVoltageLevel;

    /**
     *  生命周期
     */
    private String lifecycle;

    /**
     * 剩余电量
     */
    private String remainingElectricity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime productionDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime trialDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime nextTrialDate;
    /**
     * 电池欠压门槛
     */
    private String batteryVoltageThreshold;
    /**
     * 挂接偏差门槛
     */
    private String hookThreshold;

    private String batteryVoltage;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updateBy;

    private String isDeleted;

    private String projectId;

    private String projectName;

    private List<MountPoint> mountPointList;

    private String groundLeadTypeLabel;

    private String onlineStatusLabel;

    public String getGroundLeadTypeLabel() {
        return DictUtils.getDictLabel(Constants.DICT_TYPE.GROUND_LEAD_TYPE, groundLeadType.toString());
    }

    public String getOnlineStatusLabel(){
        return DictUtils.getDictLabel(Constants.DICT_TYPE.ONLINE_STATUS, onlineStatus.toString());
    }
}
