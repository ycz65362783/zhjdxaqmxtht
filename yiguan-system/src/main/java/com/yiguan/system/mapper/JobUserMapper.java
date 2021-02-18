package com.yiguan.system.mapper;

import com.yiguan.common.annotation.DataCollect;
import com.yiguan.common.core.domain.entity.JobUser;
import com.yiguan.common.core.domain.model.JobUserModel;
import com.yiguan.system.Base.YiGuanMapper;
import com.yiguan.system.provider.JobUserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;


/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:03
  */
@Mapper
@Component
public interface JobUserMapper extends YiGuanMapper<JobUser>
{
    @SelectProvider(type = JobUserProvider.class, method = "query")
    List<JobUserModel> query(JobUser jobUser);

    @SelectProvider(type = JobUserProvider.class, method = "countJobUsers")
    int countJobUsers();
}
