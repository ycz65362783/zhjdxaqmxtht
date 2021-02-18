package com.yiguan.web.controller.system;

import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import com.yiguan.common.core.domain.entity.GroundLead;
import com.yiguan.common.core.domain.model.GroundLeadModel;
import com.yiguan.common.core.page.TableDataInfo;
import com.yiguan.common.core.redis.RedisCache;
import com.yiguan.system.service.IGroundLeadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接地线
 * 
 * @author ycz
 */
@Api(value = "接地线",description = "接地线信息")
@RestController
@RequestMapping("/system/groundLead")
public class GroundLeadController extends BaseController
{
    @Autowired
    private RedisCache redisCache;

    @Autowired
    private IGroundLeadService groundLeadService;
//    /**
//     * 系统参数界面 获取接地线详情
//     */
//    @ApiOperation("获取接地线参数详情")
//    @GetMapping("/querySysInfoList")
//    public TableDataInfo querySysInfoList(GroundLeadModel groundLeadModel)
//    {
//        List<GroundLeadModel> list = groundLeadService.querySysInfoList(groundLeadModel);
//        return getDataTable(list);
//    }


    /**
     * 查询界面 获取接地线详情
     */
    @ApiOperation("获取接地线设备详情select")
    @GetMapping("/selectGroundLeadList")
    public TableDataInfo selectGroundLeadList(GroundLeadModel groundLeadModel)
    {
        List<GroundLeadModel> list = groundLeadService.selectGroundLeadList(groundLeadModel);
        return getDataTable(list);
    }



    /**
     * 新增接地线
     */
    @ApiOperation("新增接地线")

//    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody GroundLead groundLead)
    {
        if(groundLead ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(groundLeadService.insertGroundLead(groundLead));
    }


    /**
     * 修改接地线
     */
    @ApiOperation("修改接地线")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody GroundLead groundLead)
    {
        if(groundLead ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(groundLeadService.updateGroundLeadByPrimaryKey(groundLead));
    }


    /**
     * 删除接地线
     */
    @ApiOperation("删除接地线")
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @DeleteMapping
    public AjaxResult delete(@Validated @RequestBody GroundLead groundLead)
    {
        if(groundLead ==null)
            return AjaxResult.error("参数为空!");

        return toAjax(groundLeadService.deleteGroundLeadBByPrimaryKey(groundLead));
    }


}
