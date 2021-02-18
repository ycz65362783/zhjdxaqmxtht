package com.yiguan.web.controller.system;

import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import com.yiguan.common.core.domain.entity.JobUser;
import com.yiguan.common.core.domain.entity.QualificationDetails;
import com.yiguan.common.core.domain.model.JobUserModel;
import com.yiguan.common.utils.StringUtils;
import com.yiguan.system.service.IJobUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门信息
 * 
 * @author ycz
 */
@Api(description = "作业人员信息")
@RestController
@RequestMapping("/system/jobUser")
public class JobUserController extends BaseController
{
    @Autowired
    private IJobUserService jobUserService;

    /**
     * 获取作业人员数据
     */
    @ApiOperation("作业人员表")
//    @PreAuthorize("@ss.hasPermi('system:dept:list')")
    @GetMapping("/list")
    public AjaxResult list(JobUser jobUser){
        List<JobUserModel> jobUserList = jobUserService.query(jobUser);
        return AjaxResult.success(jobUserList);
    }


    /**
     * 新增作业人员
     */
    @ApiOperation("新增作业人员")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody JobUser jobUser)
    {
        if(jobUser ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(jobUserService.insertJobUser(jobUser));
    }


    /**
     * 修改人员信息
     */
    @ApiOperation("修改人员信息")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody JobUser jobUser)
    {
        if(jobUser ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(jobUserService.updateJobUserByPrimaryKey(jobUser));
    }


    /**
     * 删除人员信息
     */
    @ApiOperation("删除人员信息")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @DeleteMapping
    public AjaxResult delete(@Validated @RequestBody JobUser jobUser)
    {
        if(jobUser ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(jobUserService.deleteJobUserByPrimaryKey(jobUser));
    }

    /**
     * 根据作业人员id获取资质详情
     */
    @ApiOperation("根据作业人员id获取资质详情")
    @GetMapping("/getQualificationDetailsByUserId")
    public AjaxResult getQualificationDetailsByUserId(String jobUserId){

        if(StringUtils.isEmpty(jobUserId))
            return AjaxResult.error("参数为空!");

        return AjaxResult.success(jobUserService.getQualificationDetailsByUserId(jobUserId));
    }

    /**
     * 获取作业人员总数
     */
    @ApiOperation("获取作业人员总数")
    @GetMapping("/countJobUsers")
    public AjaxResult countJobUsers(){

        return AjaxResult.success(jobUserService.countJobUsers());
    }

}
