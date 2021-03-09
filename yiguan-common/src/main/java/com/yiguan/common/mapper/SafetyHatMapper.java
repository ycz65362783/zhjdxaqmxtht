package com.yiguan.common.mapper;

import com.yiguan.common.core.domain.entity.SafetyHat;
import com.yiguan.common.core.domain.model.SafetyHatModel;
import com.yiguan.system.Base.YiGuanMapper;
import com.yiguan.system.provider.SafetyHatProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;


/**
 *@Author 俞晨钟
 *@Date: Created in 2020/12/10 10:11
 */
@Component
public interface SafetyHatMapper extends YiGuanMapper<SafetyHat>
{
        @SelectProvider(type = SafetyHatProvider.class, method = "querySafetyHatParamList")
        List<SafetyHatModel> querySafetyHatParamList(SafetyHat safetyHat);

}
