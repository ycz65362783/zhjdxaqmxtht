package com.yiguan.web.controller.system;

import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import com.yiguan.common.core.domain.entity.MapInfo;
import com.yiguan.common.core.domain.model.MapInfoModel;
import com.yiguan.common.core.page.TableDataInfo;
import com.yiguan.system.service.IMapInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地图信息
 * 
 * @author ycz
 */
@Api(value = "地图信息",description = "地图信息")
@RestController
@RequestMapping("/system/mapInfo")
public class MapInfoController extends BaseController
{

    @Autowired
    private IMapInfoService mapInfoService;
    /**
     * 获取地图详情
     */
//    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @ApiOperation("获取地图详情")
    @GetMapping("/list")
    public TableDataInfo list(MapInfo mapInfo)
    {
        List<MapInfoModel> list = mapInfoService.selectMapInfoList(mapInfo);
        return getDataTable(list);
    }


    /**
     * 新增地图
     */
    @ApiOperation("新增地图")
//    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody MapInfo mapInfo)
    {
        if(mapInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(mapInfoService.insertMapInfo(mapInfo));
    }


    /**
     * 修改地图
     */
    @ApiOperation("修改地图")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody MapInfo mapInfo)
    {
        if(mapInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(mapInfoService.updateMapInfoByPrimaryKey(mapInfo));
    }


    /**
     * 删除地图
     */
    @ApiOperation("删除地图")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @DeleteMapping
    public AjaxResult delete(@Validated @RequestBody MapInfo mapInfo)
    {
        if(mapInfo ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(mapInfoService.deleteMapInfoByPrimaryKey(mapInfo));
    }


}
