package com.yiguan.common.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.QualificationDetails;
import com.yiguan.common.mapper.QualificationDetailsMapper;
import com.yiguan.common.service.IQualificationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
public class QualificationDetailsService implements IQualificationDetailsService {

    @Autowired
    private QualificationDetailsMapper qualificationDetailsMapper;

    @Override
    public QualificationDetails getQualificationByJobUserId(String jobUserId){
        QualificationDetails qualificationDetails=new QualificationDetails();
        qualificationDetails.setJobUserId(jobUserId);
        qualificationDetails.setIsDeleted(Constants.IS_DELETED.NO);
        return qualificationDetailsMapper.selectOne(qualificationDetails);
    }
}
