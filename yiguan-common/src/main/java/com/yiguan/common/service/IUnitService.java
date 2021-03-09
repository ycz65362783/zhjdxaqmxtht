package com.yiguan.common.service;

import com.yiguan.common.core.domain.entity.TeamGroup;

import java.util.List;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
public interface ITeamGroupService {

    List<TeamGroup> getTeamGroupList(TeamGroup teamGroup);

    public int insertTeamGroupInfo(TeamGroup teamGroup);

    public int updateTeamGroupByPrimaryKey(TeamGroup teamGroup);

    public int deleteTeamGroupByPrimaryKey(TeamGroup teamGroup);
}
