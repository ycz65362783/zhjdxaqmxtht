package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.JobUser;
import com.yiguan.common.core.domain.entity.QualificationDetails;
import com.yiguan.common.core.domain.model.JobUserModel;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 10:19
  */
public interface IJobUserService
{
    public List<JobUserModel> query(JobUser jobUser);

    public int insertJobUser(JobUser jobUser);

    public int updateJobUserByPrimaryKey(JobUser jobUser);

    public int deleteJobUserByPrimaryKey(JobUser jobUser);

    public List<QualificationDetails> getQualificationDetailsByUserId(String jobUserId);

    public int countJobUsers();
}
