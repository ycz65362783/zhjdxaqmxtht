package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.GroundLead;
import com.yiguan.common.core.domain.model.GroundLeadModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.system.mapper.GroundLeadMapper;
import com.yiguan.system.service.IGroundLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/28 16:13
  */
@Service
public class GroundLeadServiceImpl implements IGroundLeadService
{
    @Autowired
    private GroundLeadMapper groundLeadMapper;

    @Override
    public List<GroundLeadModel> querySysInfoList(GroundLeadModel groundLeadModel) {
        return groundLeadMapper.querySysInfoList(groundLeadModel);
    }

    @Override
    public List<GroundLeadModel> selectGroundLeadList(GroundLeadModel groundLeadModel) {
        return groundLeadMapper.selectGroundLeadList(groundLeadModel);
    }

    @Override
    public int insertGroundLead(GroundLead groundLead) {
        BeanUtils.initInsertProperty(groundLead);
        return groundLeadMapper.insertSelective(groundLead);
    }


    @Override
    public int updateGroundLeadByPrimaryKey(GroundLead groundLead) {
        BeanUtils.initUpdateProperty(groundLead);
        return groundLeadMapper.updateByPrimaryKeySelective(groundLead);
    }


    @Override
    public int deleteGroundLeadBByPrimaryKey(String id) {
        GroundLead groundLead=new GroundLead();
        groundLead.setId(id);
        groundLead.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(groundLead);
        return groundLeadMapper.updateByPrimaryKeySelective(groundLead);
    }
}
