package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.AlarmInfo;
import com.yiguan.common.core.domain.entity.Tower;
import com.yiguan.common.core.domain.model.AlarmInfoModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.system.mapper.AlarmInfoMapper;
import com.yiguan.system.mapper.TowerMapper;
import com.yiguan.system.service.IAlarmInfoService;
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
public class TowerServiceImpl implements ITowerService
{
    private static final Logger log = LoggerFactory.getLogger(TowerServiceImpl.class);

    @Autowired
    private TowerMapper towerMapper;

    @Override
    public List<Tower> selectTowerList(Tower tower) {
        return towerMapper.select(tower);
    }

    @Override
    public int insertTowerInfo(Tower tower) {
        BeanUtils.initInsertProperty(tower);
        return towerMapper.insertSelective(tower);
    }

    @Override
    public int updateTowerByPrimaryKey(Tower tower) {
        BeanUtils.initUpdateProperty(tower);
        return towerMapper.updateByPrimaryKeySelective(tower);
    }


    @Override
    public int deleteTowerByPrimaryKey(Tower tower) {
        tower.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(tower);
        return towerMapper.updateByPrimaryKeySelective(tower);
    }
}
