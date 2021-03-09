package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.EventInfo;
import com.yiguan.common.core.domain.model.EventInfoModel;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 10:19
  */
public interface IEventInfoService
{
    public List<EventInfoModel> selectEventInfoList(EventInfoModel eventInfoModel);

    public int insertEventInfo(EventInfo eventInfo);

    public int updateEventInfoByPrimaryKey(EventInfo eventInfo);

    public int deleteEventInfoByPrimaryKey(EventInfo eventInfo);

}
