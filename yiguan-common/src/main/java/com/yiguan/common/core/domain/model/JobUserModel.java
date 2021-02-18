package com.yiguan.common.core.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yiguan.common.constant.Constants;
import com.yiguan.common.utils.DictUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 作业用户
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 16:14
  */
@Getter
@Setter
public class JobUserModel {

    private String id;

    private String jobUserName;

    private String gender;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date joinJobDate;

    private Integer age;

    private Integer workAge;

    private String national;

    private String nativePlace;

    private String schoolRecord;

    private String politicalLandSpace;

    private String professionalTitle;

    private String post;

    private String teamGroup;

    private String workUnit;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updateBy;

    private String isDeleted;

    public String getSchoolRecordLabel() {
        return DictUtils.getDictLabel(Constants.DICT_TYPE.SCHOOL_RECORD_TYPE, schoolRecord);
    }
}
