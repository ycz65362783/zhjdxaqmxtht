package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.EventInfo;
import com.yiguan.common.core.domain.model.EventInfoModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.system.mapper.EventInfoMapper;
import com.yiguan.system.service.IEventInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/28 16:13
  */
@Service
public class EventInfoServiceImpl implements IEventInfoService
{
    private static final Logger log = LoggerFactory.getLogger(EventInfoServiceImpl.class);

    @Autowired
    private EventInfoMapper eventInfoMapper;

    @Override
    public List<EventInfoModel> selectEventInfoList(EventInfoModel eventInfoModel) {
        return eventInfoMapper.queryEventInfoList(eventInfoModel);
    }

    @Override
    public int insertEventInfo(EventInfo eventInfo) {
        BeanUtils.initInsertProperty(eventInfo);
        return eventInfoMapper.insertSelective(eventInfo);
    }

    @Override
    public int updateEventInfoByPrimaryKey(EventInfo eventInfo) {
        BeanUtils.initUpdateProperty(eventInfo);
        return eventInfoMapper.updateByPrimaryKeySelective(eventInfo);
    }


    @Override
    public int deleteEventInfoByPrimaryKey(EventInfo eventInfo) {
        eventInfo.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(eventInfo);
        return eventInfoMapper.updateByPrimaryKeySelective(eventInfo);
    }
}
