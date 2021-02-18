package com.yiguan.system.mapper;

import com.yiguan.common.core.domain.entity.MapInfo;
import com.yiguan.common.core.domain.model.MapInfoModel;
import com.yiguan.system.Base.YiGuanMapper;
import com.yiguan.system.provider.MapInfoProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;


/**
 *@Author 俞晨钟
 *@Date: Created in 2020/12/10 10:11
 */
@Component
public interface MapInfoMapper extends YiGuanMapper<MapInfo>
{
    @SelectProvider(type = MapInfoProvider.class, method = "query")
    List<MapInfoModel> query(MapInfo mapInfo);
}
