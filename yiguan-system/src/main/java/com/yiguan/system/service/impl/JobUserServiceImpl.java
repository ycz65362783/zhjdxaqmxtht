package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.JobUser;
import com.yiguan.common.core.domain.entity.QualificationDetails;
import com.yiguan.common.core.domain.model.JobUserModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.system.mapper.JobUserMapper;
import com.yiguan.system.mapper.QualificationDetailsMapper;
import com.yiguan.system.service.IJobUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:29
  */
@Service
public class JobUserServiceImpl implements IJobUserService
{
    private static final Logger log = LoggerFactory.getLogger(JobUserServiceImpl.class);

    @Autowired
    private JobUserMapper jobUserMapper;

    @Autowired
    private QualificationDetailsMapper qualificationDetailsMapper;

    @Override
    public List<JobUserModel> query(JobUser jobUser)
    {
        return jobUserMapper.query(jobUser);
    }


    @Override
    public int insertJobUser(JobUser jobUser)
    {
        BeanUtils.initInsertProperty(jobUser);
        return jobUserMapper.insertSelective(jobUser);
    }

    @Override
    public int updateJobUserByPrimaryKey(JobUser jobUser)
    {
        BeanUtils.initUpdateProperty(jobUser);
        return jobUserMapper.updateByPrimaryKeySelective(jobUser);
    }


    //逻辑删除，不采用物理删除
    @Override
    public int deleteJobUserByPrimaryKey(String id)
    {
        JobUser jobUser=new JobUser();
        jobUser.setId(id);
        jobUser.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(jobUser);
        return jobUserMapper.updateByPrimaryKeySelective(jobUser);
    }

    //逻辑删除，不采用物理删除
    @Override
    public List<QualificationDetails> getQualificationDetailsByUserId(String jobUserId)
    {
        QualificationDetails qualificationDetails=new QualificationDetails();
        qualificationDetails.setJobUserId(jobUserId);
        qualificationDetails.setIsDeleted(Constants.IS_DELETED.NO);
        return qualificationDetailsMapper.select(qualificationDetails);
    }

    @Override
    public int countJobUsers()
    {
        return jobUserMapper.countJobUsers();
    }

}
