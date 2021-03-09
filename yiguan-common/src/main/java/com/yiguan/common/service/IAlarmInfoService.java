package com.yiguan.system.service;


import com.yiguan.common.core.domain.entity.AlarmInfo;
import com.yiguan.common.core.domain.model.AlarmInfoModel;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 10:19
  */
public interface IAlarmInfoService
{
    public List<AlarmInfoModel> selectAlarmInfoList(AlarmInfoModel alarmInfoModel);

    public int insertAlarmInfoInfo(AlarmInfo alarmInfo);

    public int updateAlarmInfoByPrimaryKey(AlarmInfo alarmInfo);

    public int deleteAlarmInfoByPrimaryKey(AlarmInfo alarmInfo);

}
