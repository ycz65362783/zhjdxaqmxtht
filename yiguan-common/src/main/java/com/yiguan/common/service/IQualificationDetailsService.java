package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.QualificationDetails;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
public interface IQualificationDetailsService {

    QualificationDetails getQualificationByJobUserId(String jobUserId);
}
