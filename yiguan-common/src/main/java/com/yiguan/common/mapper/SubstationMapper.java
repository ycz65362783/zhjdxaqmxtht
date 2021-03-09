package com.yiguan.common.mapper;

import com.yiguan.common.core.domain.entity.Substation;
import com.yiguan.common.core.domain.entity.Tower;
import com.yiguan.common.core.domain.model.GroundLeadModel;
import com.yiguan.common.core.domain.model.SubstationModel;
import com.yiguan.system.Base.YiGuanMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 变电站信息
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
@Component
public interface SubstationMapper extends YiGuanMapper<Substation>
{
    List<SubstationModel> query(SubstationModel substationModel);

}
