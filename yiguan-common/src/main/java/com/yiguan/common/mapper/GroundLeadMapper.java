package com.yiguan.common.mapper;

import com.yiguan.common.annotation.DataCollect;
import com.yiguan.common.core.domain.entity.GroundLead;
import com.yiguan.common.core.domain.entity.MountPoint;
import com.yiguan.common.core.domain.model.GroundLeadModel;
import com.yiguan.system.Base.YiGuanMapper;
import com.yiguan.system.provider.GroundLeadProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 *@Author 俞晨钟
 *@Date: Created in 2020/12/10 10:11
 */
@Component
public interface GroundLeadMapper extends YiGuanMapper<GroundLead>
{
    @SelectProvider(type = GroundLeadProvider.class, method = "querySysInfoList")
    List<GroundLeadModel> querySysInfoList(GroundLeadModel groundLeadModel);

    List<GroundLeadModel> selectGroundLeadList(GroundLeadModel groundLeadModel);

}
