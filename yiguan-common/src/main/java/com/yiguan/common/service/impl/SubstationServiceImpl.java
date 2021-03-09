package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.Substation;
import com.yiguan.common.core.domain.entity.SubstationPic;
import com.yiguan.common.core.domain.entity.Tower;
import com.yiguan.common.core.domain.model.SubstationModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.common.utils.CollectionUtil;
import com.yiguan.common.utils.StringUtils;
import com.yiguan.system.mapper.SubstationMapper;
import com.yiguan.system.mapper.SubstationPicMapper;
import com.yiguan.system.mapper.TowerMapper;
import com.yiguan.system.service.ISubstationService;
import com.yiguan.system.service.ITowerService;
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
public class SubstationServiceImpl implements ISubstationService
{
    private static final Logger log = LoggerFactory.getLogger(SubstationServiceImpl.class);

    @Autowired
    private SubstationMapper substationMapper;

    @Autowired
    private SubstationPicMapper substationPicMapper;

    @Override
    public List<SubstationModel> selectSubstationList(SubstationModel substationModel) {
        return substationMapper.query(substationModel);
    }

    @Override
    public int insertSubstation(SubstationModel substationModel) {
        Substation substation=new Substation();
        substation.setCenterx(StringUtils.isNotEmpty(substationModel.getCenterx())?substationModel.getCenterx():"");
        substation.setCentery(StringUtils.isNotEmpty(substationModel.getCentery())?substationModel.getCentery():"");
        substation.setName(StringUtils.isNotEmpty(substationModel.getName())?substationModel.getName():"");
        substation.setZoom(StringUtils.isNotEmpty(substationModel.getZoom())?substationModel.getZoom():"");
        BeanUtils.initInsertProperty(substation);

        if(CollectionUtil.isNotNullList(substationModel.getPicList())){
            for (SubstationPic substationPic : substationModel.getPicList()) {
                substationPic.setSubstationId(substation.getId());
                BeanUtils.initInsertProperty(substationPic);
            }
            substationPicMapper.batchInsertSelective(substationModel.getPicList());
        }

        return substationMapper.insertSelective(substation);
    }

    @Override
    public int updateSubstationByPrimaryKey(Substation substation) {
        BeanUtils.initUpdateProperty(substation);
        return substationMapper.updateByPrimaryKeySelective(substation);
    }


    @Override
    public int deleteSubstationByPrimaryKey(Substation substation) {
        substation.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(substation);
        return substationMapper.updateByPrimaryKeySelective(substation);
    }
}
