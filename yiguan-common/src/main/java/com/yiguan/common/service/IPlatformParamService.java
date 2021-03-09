package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.PlatformParam;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 10:19
  */
public interface IPlatformParamService
{

    public List<PlatformParam> query(PlatformParam platformParam);

    public PlatformParam getParamByCode(String paramCode);

    public int insertPlatformParam(PlatformParam platformParam);

    public int updatePlatformParamByPrimaryKey(PlatformParam platformParam);

    public int deletePlatformParamByPrimaryKey(PlatformParam platformParam);

}
