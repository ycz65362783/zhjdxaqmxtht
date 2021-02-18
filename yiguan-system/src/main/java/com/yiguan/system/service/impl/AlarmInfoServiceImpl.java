package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.AlarmInfo;
import com.yiguan.common.core.domain.model.AlarmInfoModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.common.utils.SecurityUtils;
import com.yiguan.common.utils.StringUtils;
import com.yiguan.system.mapper.AlarmInfoMapper;
import com.yiguan.system.service.IAlarmInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/28 16:13
  */
@Service
public class AlarmInfoServiceImpl implements IAlarmInfoService
{
    private static final Logger log = LoggerFactory.getLogger(AlarmInfoServiceImpl.class);

    @Autowired
    private AlarmInfoMapper alarmInfoMapper;

    @Override
    public List<AlarmInfoModel> selectAlarmInfoList(AlarmInfo alarmInfo) {
        return alarmInfoMapper.query(alarmInfo);
    }

    @Override
    public int insertAlarmInfoInfo(AlarmInfo alarmInfo) {
        BeanUtils.initInsertProperty(alarmInfo);
        return alarmInfoMapper.insertSelective(alarmInfo);
    }

    @Override
    public int updateAlarmInfoByPrimaryKey(AlarmInfo alarmInfo) {
        BeanUtils.initUpdateProperty(alarmInfo);
        return alarmInfoMapper.updateByPrimaryKeySelective(alarmInfo);
    }


    @Override
    public int deleteAlarmInfoByPrimaryKey(AlarmInfo alarmInfo) {
        alarmInfo.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(alarmInfo);
        return alarmInfoMapper.updateByPrimaryKeySelective(alarmInfo);
    }
}
