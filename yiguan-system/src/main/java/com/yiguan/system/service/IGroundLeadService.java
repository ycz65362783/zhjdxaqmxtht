package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.GroundLead;
import com.yiguan.common.core.domain.model.GroundLeadModel;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 10:19
  */
public interface IGroundLeadService
{
     List<GroundLeadModel> querySysInfoList(GroundLeadModel groundLeadModel);

     List<GroundLeadModel> selectGroundLeadList(GroundLeadModel groundLeadModel);

     int insertGroundLead(GroundLead groundLead);

     int updateGroundLeadByPrimaryKey(GroundLead groundLead);

     int deleteGroundLeadBByPrimaryKey(String id);

}
