package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.MapInfo;
import com.yiguan.common.core.domain.model.MapInfoModel;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 10:19
  */
public interface IMapInfoService
{
    public List<MapInfoModel> selectMapInfoList(MapInfo mapInfo);

    public int insertMapInfo(MapInfo mapInfo);

    public int updateMapInfoByPrimaryKey(MapInfo mapInfo);

    public int deleteMapInfoByPrimaryKey(MapInfo mapInfo);

}
