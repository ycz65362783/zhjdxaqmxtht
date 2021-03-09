package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.MapInfo;
import com.yiguan.common.core.domain.model.MapInfoModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.system.mapper.MapInfoMapper;
import com.yiguan.system.service.IMapInfoService;
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
public class MapInfoServiceImpl implements IMapInfoService
{
    private static final Logger log = LoggerFactory.getLogger(MapInfoServiceImpl.class);

    @Autowired
    private MapInfoMapper mapInfoMapper;

    @Override
    public List<MapInfoModel> selectMapInfoList(MapInfoModel mapInfoModel) {
        return mapInfoMapper.query(mapInfoModel);
    }

    @Override
    public int insertMapInfo(MapInfo mapInfo) {
        BeanUtils.initInsertProperty(mapInfo);
        return mapInfoMapper.insertSelective(mapInfo);
    }

    @Override
    public int updateMapInfoByPrimaryKey(MapInfo mapInfo) {
        BeanUtils.initUpdateProperty(mapInfo);
        return mapInfoMapper.updateByPrimaryKeySelective(mapInfo);
    }


    @Override
    public int deleteMapInfoByPrimaryKey(MapInfo mapInfo) {
        mapInfo.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(mapInfo);
        return mapInfoMapper.updateByPrimaryKeySelective(mapInfo);
    }
}
