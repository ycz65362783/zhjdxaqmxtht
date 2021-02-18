package com.yiguan.web.controller.system;

import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import com.yiguan.common.core.domain.entity.AlarmInfo;
import com.yiguan.common.core.domain.entity.EventInfo;
import com.yiguan.common.core.domain.model.AlarmInfoModel;
import com.yiguan.common.core.page.TableDataInfo;
import com.yiguan.system.service.IAlarmInfoService;
import com.yiguan.system.service.IEventInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 事件信息记录
 * 
 * @author ycz
 */
@Api(value = "事件信息记录",description = "事件信息记录")
@RestController
@RequestMapping("/system/eventInfo")
public class EventInfoController extends BaseController
{

    @Autowired
    private IEventInfoService eventInfoService;
    /**
     * 获取事件信息记录
     */
    @ApiOperation("获取事件信息记录")
    @GetMapping("/list")
    public TableDataInfo list(EventInfo eventInfo)
    {
        List<EventInfo> list = eventInfoService.selectEventInfoList(eventInfo);
        return getDataTable(list);
    }


    /**
     * 新增报警信息
     */
    @ApiOperation("新增事件信息记录")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody EventInfo eventInfo)
    {
        if(eventInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(eventInfoService.insertEventInfo(eventInfo));
    }


    /**
     * 修改报警信息
     */
    @ApiOperation("修改事件信息记录")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody EventInfo eventInfo)
    {
        if(eventInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(eventInfoService.updateEventInfoByPrimaryKey(eventInfo));
    }


    /**
     * 删除报警信息
     */
    @ApiOperation("删除事件信息记录")
    @DeleteMapping
    public AjaxResult delete(@Validated @RequestBody EventInfo eventInfo)
    {
        if(eventInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(eventInfoService.deleteEventInfoByPrimaryKey(eventInfo));
    }

}
