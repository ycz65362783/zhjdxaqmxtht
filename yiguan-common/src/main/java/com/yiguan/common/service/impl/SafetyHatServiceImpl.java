package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.SafetyHat;
import com.yiguan.common.core.domain.model.SafetyHatModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.system.mapper.*;
import com.yiguan.system.service.ISafetyHatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 业务层处理
 * 
 * @author ycz
 */
@Service
public class SafetyHatServiceImpl implements ISafetyHatService
{
    private static final Logger log = LoggerFactory.getLogger(SafetyHatServiceImpl.class);

    @Autowired
    private SafetyHatMapper safetyHatMapper;

    @Override
    public List<SafetyHatModel> querySafetyHatParamList(SafetyHat safetyHat)
    {
        return safetyHatMapper.querySafetyHatParamList(safetyHat);
    }


    @Override
    public int insertSafetyHat(SafetyHat safetyHat)
    {
        BeanUtils.initInsertProperty(safetyHat);
        return safetyHatMapper.insertSelective(safetyHat);
    }

    @Override
    public int updateSafetyHatByPrimaryKey(SafetyHat safetyHat)
    {
        BeanUtils.initUpdateProperty(safetyHat);
        return safetyHatMapper.updateByPrimaryKeySelective(safetyHat);
    }

    @Override
    public int deleteSafetyHatByPrimaryKey(String id)
    {
        SafetyHat safetyHat=new SafetyHat();
        safetyHat.setId(id);
        safetyHat.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(safetyHat);
        return safetyHatMapper.updateByPrimaryKeySelective(safetyHat);
    }

    @Override
    public int insertSafetyHatList(List<SafetyHat> safetyHatList)
    {
        return safetyHatMapper.batchInsertSelective(safetyHatList);
    }


}
