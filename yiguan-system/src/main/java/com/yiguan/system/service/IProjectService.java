package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.Project;
import com.yiguan.common.core.domain.model.ProjectModel;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/10 10:19
  */
public interface IProjectService
{
    public List<ProjectModel> selectProjectList(ProjectModel projectModel);

    public int insertProject(Project project);

    public int updateProjectByPrimaryKey(Project project);

    public int deleteProjectByPrimaryKey(String id);

}
