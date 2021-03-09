package com.yiguan.common.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.PlatformParam;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.common.mapper.PlatformParamMapper;
import com.yiguan.common.service.IPlatformParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
@Service
public class PlatfromParamService implements IPlatformParamService {

    @Autowired
    private PlatformParamMapper platformParamMapper;

    @Override
    public List<PlatformParam> query(PlatformParam platformParam){
        return platformParamMapper.select(platformParam);
    }

    @Override
    public PlatformParam getParamByCode(String paramCode){
        PlatformParam platformParam=new PlatformParam();
        platformParam.setIsDeleted(Constants.IS_DELETED.NO);
        platformParam.setParamCode(paramCode);
        return platformParamMapper.selectOne(platformParam);
    }

    @Override
    public int insertPlatformParam(PlatformParam platformParam){
        BeanUtils.initInsertProperty(platformParam);
        return platformParamMapper.insertSelective(platformParam);
    }

    @Override
    public int updatePlatformParamByPrimaryKey(PlatformParam platformParam){
        BeanUtils.initUpdateProperty(platformParam);
        return platformParamMapper.updateByPrimaryKeySelective(platformParam);
    }

    @Override
    public int deletePlatformParamByPrimaryKey(PlatformParam platformParam){
        platformParam.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(platformParam);
        return platformParamMapper.updateByPrimaryKeySelective(platformParam);
    }


}
