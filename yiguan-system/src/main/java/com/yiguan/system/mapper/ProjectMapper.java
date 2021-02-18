package com.yiguan.system.mapper;

import com.yiguan.common.core.domain.entity.Project;
import com.yiguan.common.core.domain.model.ProjectModel;
import com.yiguan.system.Base.YiGuanMapper;
import com.yiguan.system.provider.ProjectProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;


/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 17:32
  */
@Mapper
public interface ProjectMapper extends YiGuanMapper<Project>
{
    @SelectProvider(type = ProjectProvider.class, method = "query")
     List<ProjectModel> query(ProjectModel projectModel);

}
