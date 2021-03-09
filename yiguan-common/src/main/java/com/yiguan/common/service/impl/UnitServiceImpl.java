package com.yiguan.common.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.TeamGroup;
import com.yiguan.common.core.domain.entity.Tower;
import com.yiguan.common.mapper.TeamGroupMapper;
import com.yiguan.common.mapper.TowerMapper;
import com.yiguan.common.service.ITeamGroupService;
import com.yiguan.common.service.ITowerService;
import com.yiguan.common.utils.BeanUtils;
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
public class TeamGroupServiceImpl implements ITeamGroupService
{
    private static final Logger log = LoggerFactory.getLogger(TeamGroupServiceImpl.class);

    @Autowired
    private TeamGroupMapper teamGroupMapper;

    @Override
    public List<TeamGroup> getTeamGroupList(TeamGroup teamGroup) {
        return teamGroupMapper.select(teamGroup);
    }

    @Override
    public int insertTeamGroupInfo(TeamGroup teamGroup) {
        BeanUtils.initInsertProperty(teamGroup);
        return teamGroupMapper.insertSelective(teamGroup);
    }

    @Override
    public int updateTeamGroupByPrimaryKey(TeamGroup teamGroup) {
        BeanUtils.initUpdateProperty(teamGroup);
        return teamGroupMapper.updateByPrimaryKeySelective(teamGroup);
    }


    @Override
    public int deleteTeamGroupByPrimaryKey(TeamGroup teamGroup) {
        teamGroup.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(teamGroup);
        return teamGroupMapper.updateByPrimaryKeySelective(teamGroup);
    }
}
