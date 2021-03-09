package com.yiguan.common.core.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yiguan.common.constant.Constants;
import com.yiguan.common.utils.DictUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 地图
  *@Author 俞晨钟
  *@Date: Created in 2020/12/29 16:09
  */
@Setter
@Getter
public class MapInfoModel {

    private String id;

    private String mapInfoName;

    private Integer mapInfoType;

    private String ownCompany;

    private Integer jobSupervisor;

    private String jobSupervisorName;

    private String mapUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastEditTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updateBy;

    private String isDeleted;

    private String mapInfoTypeLabel;

    public String getMapInfoTypeLabel() {
        return DictUtils.getDictLabel(Constants.DICT_TYPE.MAP_INFO_TYPE, mapInfoType.toString());
    }


}
