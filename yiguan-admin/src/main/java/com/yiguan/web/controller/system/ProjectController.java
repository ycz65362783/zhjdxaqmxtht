package com.yiguan.web.controller.system;

import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import com.yiguan.common.core.domain.entity.Project;
import com.yiguan.common.core.domain.model.ProjectModel;
import com.yiguan.common.core.page.TableDataInfo;
import com.yiguan.system.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目信息
  *@Author 俞晨钟
  *@Date: Created in 2020/12/11 10:17
  */
@Api(value = "项目信息",description = "项目信息")
@RestController
@RequestMapping("/system/project")
public class ProjectController extends BaseController
{
    @Autowired
    private IProjectService projectService;
    /**
     * 获取项目信息
     */
//    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @ApiOperation("获取项目信息")
    @GetMapping("/list")
    public TableDataInfo list(ProjectModel projectModel)
    {
        List<ProjectModel> list = projectService.selectProjectList(projectModel);
        return getDataTable(list);
    }


    /**
     * 新增项目信息
     */
    @ApiOperation("新增项目信息")
//    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Project project)
    {
        if(project ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(projectService.insertProject(project));
    }


    /**
     * 修改项目信息
     */
    @ApiOperation("修改项目信息")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Project project)
    {
        if(project ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(projectService.updateProjectByPrimaryKey(project));
    }


    /**
     * 删除项目信息
     */
    @ApiOperation("删除项目信息")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @DeleteMapping
    public AjaxResult delete(@Validated @RequestBody Project project)
    {
        if(project ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(projectService.deleteProjectByPrimaryKey(project));
    }

}
