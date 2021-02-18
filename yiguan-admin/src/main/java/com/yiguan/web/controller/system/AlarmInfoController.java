package com.yiguan.web.controller.system;

import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import com.yiguan.common.core.domain.entity.AlarmInfo;
import com.yiguan.common.core.domain.model.AlarmInfoModel;
import com.yiguan.common.core.page.TableDataInfo;
import com.yiguan.system.service.IAlarmInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报警信息
 * 
 * @author ycz
 */
@Api(value = "报警信息",description = "报警信息")
@RestController
@RequestMapping("/system/alarmInfo")
public class AlarmInfoController extends BaseController
{

    @Autowired
    private IAlarmInfoService alarmInfoService;
    /**
     * 获取报警详情
     */
    @ApiOperation("获取报警详情")
    @GetMapping("/list")
    public TableDataInfo list(AlarmInfo alarmInfo)
    {
        List<AlarmInfoModel> list = alarmInfoService.selectAlarmInfoList(alarmInfo);
        return getDataTable(list);
    }


    /**
     * 新增报警信息
     */
    @ApiOperation("新增报警信息")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody AlarmInfo alarmInfo)
    {
        if(alarmInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(alarmInfoService.insertAlarmInfoInfo(alarmInfo));
    }


    /**
     * 修改报警信息
     */
    @ApiOperation("修改报警信息")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody AlarmInfo alarmInfo)
    {
        if(alarmInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(alarmInfoService.updateAlarmInfoByPrimaryKey(alarmInfo));
    }


    /**
     * 删除报警信息
     */
    @ApiOperation("删除报警信息")
    @DeleteMapping
    public AjaxResult delete(@Validated @RequestBody AlarmInfo alarmInfo)
    {
        if(alarmInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(alarmInfoService.deleteAlarmInfoByPrimaryKey(alarmInfo));
    }

}
