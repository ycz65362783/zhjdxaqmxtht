package com.yiguan.web.controller.system;

import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import com.yiguan.common.core.domain.entity.SafetyHat;
import com.yiguan.common.core.domain.model.SafetyHatModel;
import com.yiguan.common.core.page.TableDataInfo;
import com.yiguan.system.service.ISafetyHatService;
import com.yiguan.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息
 * 
 * @author ycz
 */
@Api(value = "安全帽信息",description = "安全帽信息")
@RestController
@RequestMapping("/system/hat")
public class SafetyHatController extends BaseController
{
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISafetyHatService safetyHatService;
    /**
     *  系统界面 获取安全帽参数信息
     */
//    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @ApiOperation("获取安全帽参数信息")
    @GetMapping("/querySafetyHatParamlist")
    public TableDataInfo querySafetyHatParamlist(SafetyHat safetyHat)
    {
        List<SafetyHatModel> list = safetyHatService.querySafetyHatParamList(safetyHat);
        return getDataTable(list);
    }

    /**
     * 新增用户
     */
    @ApiOperation("新增安全帽")
//    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SafetyHat safetyHat)
    {
        if(safetyHat ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(safetyHatService.insertSafetyHat(safetyHat));
    }


    /**
     * 修改安全帽
     */
    @ApiOperation("修改安全帽")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SafetyHat safetyHat)
    {
        if(safetyHat ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(safetyHatService.updateSafetyHatByPrimaryKey(safetyHat));
    }


    /**
     * 删除安全帽
     */
    @ApiOperation("删除安全帽")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @DeleteMapping
    public AjaxResult delete(@Validated @RequestBody SafetyHat safetyHat)
    {
        if(safetyHat ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(safetyHatService.deleteSafetyHatByPrimaryKey(safetyHat));
    }


}
