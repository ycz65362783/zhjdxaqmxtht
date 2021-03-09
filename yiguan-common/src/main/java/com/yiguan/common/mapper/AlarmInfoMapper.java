package com.yiguan.common.mapper;

import com.yiguan.common.core.domain.entity.AlarmInfo;
import com.yiguan.common.core.domain.model.AlarmInfoModel;
import com.yiguan.system.Base.YiGuanMapper;
import com.yiguan.system.provider.AlarmInfoProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 *@Author 俞晨钟
 *@Date: Created in 2020/12/10 10:11
 */
@Component
public interface AlarmInfoMapper extends YiGuanMapper<AlarmInfo>
{
    @SelectProvider(type = AlarmInfoProvider.class, method = "query")
    List<AlarmInfoModel> query(AlarmInfoModel alarmInfoModel);
}
