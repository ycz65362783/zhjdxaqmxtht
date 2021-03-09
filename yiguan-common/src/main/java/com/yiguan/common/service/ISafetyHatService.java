package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.SafetyHat;
import com.yiguan.common.core.domain.model.SafetyHatModel;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 10:19
  */
public interface ISafetyHatService
{
    public List<SafetyHatModel> querySafetyHatParamList(SafetyHat safetyHat);

    public int insertSafetyHat(SafetyHat safetyHat);

    public int updateSafetyHatByPrimaryKey(SafetyHat safetyHat);

    public int deleteSafetyHatByPrimaryKey(String id);

    public int insertSafetyHatList(List<SafetyHat> safetyHatList);

}
