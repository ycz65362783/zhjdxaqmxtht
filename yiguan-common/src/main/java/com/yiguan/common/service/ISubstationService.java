package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.Substation;
import com.yiguan.common.core.domain.model.SubstationModel;

import java.util.List;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
public interface ISubstationService {

    public List<SubstationModel> selectSubstationList(SubstationModel substationModel);

    public int insertSubstation(SubstationModel substationModel);

    public int updateSubstationByPrimaryKey(Substation substation);

    public int deleteSubstationByPrimaryKey(Substation substation);
}
