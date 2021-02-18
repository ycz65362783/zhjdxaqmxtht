package com.yiguan.web.controller.system;

import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * uwb定位系统接口
 * 
 * @author ycz
 */
@Api(description = "uwb定位信息")
@RestController
@RequestMapping("/uwb")
public class UWBController extends BaseController
{
    /**
     * UWB定位数据接收测试
     */
    @ApiOperation("UWB定位数据接收测试")
    @RequestMapping(value = "/test.api")
    @ResponseBody
    public  AjaxResult receiveInfo(HttpServletRequest request, HttpSession session) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            String result = sb.toString();

            logger.info("南京沃旭通讯---------------------------------------------------------------------------------------------");
            logger.info(result+"------------------------------------------------------------------------------------------------");
            logger.info(result+"------------------------------------------------------------------------------------------------");
            logger.info("南京沃旭通讯---------------------------------------------------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.success("success");
    }

}
