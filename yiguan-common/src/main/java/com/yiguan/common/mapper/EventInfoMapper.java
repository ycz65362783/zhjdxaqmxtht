package com.yiguan.common.mapper;

import com.yiguan.common.core.domain.entity.EventInfo;
import com.yiguan.common.core.domain.model.EventInfoModel;
import com.yiguan.system.Base.YiGuanMapper;
import com.yiguan.system.provider.EventInfoProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@Author 俞晨钟
 *@Date: Created in 2020/12/10 10:11
 */
@Component
public interface EventInfoMapper extends YiGuanMapper<EventInfo>
{
    @SelectProvider(type = EventInfoProvider.class, method = "queryEventInfoList")
    List<EventInfoModel> queryEventInfoList(EventInfoModel eventInfoModel);
}
