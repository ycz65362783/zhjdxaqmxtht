package com.yiguan.common.core.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.SubstationPic;
import com.yiguan.common.utils.DictUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *  变电站model类
  *@Author 俞晨钟
  *@Date: Created in 2020/12/29 16:09
  */
@Getter
@Setter
public class SubstationModel {

    private String id;

    private String name;

    //中心点x
    private String centerx;

    //中心点y
    private String centery;

    //图层级别
    private String zoom;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updateBy;

    private String isDeleted;

    private String mapInfoId;

    private List<SubstationPic> picList;

}
