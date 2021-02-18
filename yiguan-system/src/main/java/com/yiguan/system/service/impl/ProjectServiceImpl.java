package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.Project;
import com.yiguan.common.core.domain.model.ProjectModel;
import com.yiguan.common.utils.BeanUtils;
import com.yiguan.system.mapper.ProjectMapper;
import com.yiguan.system.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:59
  */
@Service
public class ProjectServiceImpl implements IProjectService
{
    private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectModel> selectProjectList(ProjectModel projectModel)
    {
        return projectMapper.query(projectModel);
    }


    @Override
    public int insertProject(Project project)
    {
        BeanUtils.initInsertProperty(project);
        return projectMapper.insertSelective(project);
    }

    @Override
    public int updateProjectByPrimaryKey(Project project)
    {
        BeanUtils.initUpdateProperty(project);
        return projectMapper.updateByPrimaryKeySelective(project);
    }


    //逻辑删除，不采用物理删除
    @Override
    public int deleteProjectByPrimaryKey(Project project)
    {
        project.setIsDeleted(Constants.IS_DELETED.YES);
        BeanUtils.initUpdateProperty(project);
        return projectMapper.updateByPrimaryKeySelective(project);
    }


}
