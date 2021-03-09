package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.Tower;

import java.util.List;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
public interface ITowerService {

    public List<Tower> selectTowerList(Tower tower);

    public int insertTowerInfo(Tower tower);

    public int updateTowerByPrimaryKey(Tower tower);

    public int deleteTowerByPrimaryKey(Tower tower);
}
