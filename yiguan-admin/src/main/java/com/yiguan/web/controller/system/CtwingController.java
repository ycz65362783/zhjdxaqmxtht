package com.yiguan.web.controller.system;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.ctg.ag.sdk.biz.AepDeviceManagementClient;
import com.ctg.ag.sdk.biz.AepProductManagementClient;
import com.ctg.ag.sdk.biz.aep_device_management.QueryDeviceRequest;
import com.ctg.ag.sdk.biz.aep_device_management.QueryDeviceResponse;
import com.ctg.ag.sdk.biz.aep_product_management.DeleteProductRequest;
import com.ctg.ag.sdk.biz.aep_product_management.QueryProductListRequest;
import com.ctg.ag.sdk.biz.aep_product_management.QueryProductListResponse;
import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.controller.BaseController;
import com.yiguan.common.core.domain.AjaxResult;
import com.yiguan.common.core.domain.aep.Product;
import com.yiguan.common.core.domain.aep.StockInfo;
import com.yiguan.common.core.domain.model.DeviceChangeReport;
import com.yiguan.common.core.domain.model.DeviceEventReport;
import com.yiguan.common.core.domain.model.DeviceOnlineReport;
import com.yiguan.common.utils.JsonUtils;
import com.yiguan.common.utils.StringUtils;
import com.yiguan.common.utils.uuid.IdUtils;
import com.yiguan.quartz.domain.SysJob;
import com.yiguan.quartz.mapper.SysJobMapper;
import com.yiguan.quartz.service.ISysJobService;
import com.yiguan.quartz.util.ScheduleUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.client.HttpClient;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * ctwing中国电信接口
  *@Author ycz
  *@Date: Created in 2020/12/30 10:29
  */

@Api(value = "ctwing",description = "中国电信接口")
@RestController
@RequestMapping("/ctwing")
public class CtwingController extends BaseController
{
    /**
     * http POST请求示例
     */
    @ApiOperation("测试")
    @RequestMapping(value = "/test.api", method = RequestMethod.POST)
    @ResponseBody
    public static void httpPostExample() throws Exception {
        AepProductManagementClient client = AepProductManagementClient.newClient().appKey("pEkFAjvrdh4").appSecret("nbHwqyy40h").build();
        QueryProductListRequest request = new QueryProductListRequest();
        QueryProductListResponse queryProductListResponse = client.QueryProductList(request);
        Map<String, Object> map = JsonUtils.toMap(new String(queryProductListResponse.getBody(), "UTF-8"));
        Map<String,Object>  zmap= (Map<String,Object>)map.get("result");
    }

    @ApiOperation("查询设备")
    @RequestMapping(value = "/testDevice.api", method = RequestMethod.POST)
    @ResponseBody
    public static void testDevice() throws Exception {
        AepDeviceManagementClient client = AepDeviceManagementClient.newClient().appKey("pEkFAjvrdh4").appSecret("nbHwqyy40h").build();
        QueryDeviceRequest request = new QueryDeviceRequest();
            request.setParamDeviceId(Constants.CWTING_INFO.PRODUCT_ID);
        request.setParamProductId(Long.valueOf(Constants.CWTING_INFO.PRODUCT_ID));
        request.setParamMasterKey(Constants.CWTING_INFO.MASTER_KEY);
        QueryDeviceResponse response = client.QueryDevice(request);
        Map<String, Object> device = JsonUtils.toMap(new String(response.getBody(), "UTF-8"));
        Map<String,Object>  deMap= (Map<String,Object>)device.get("result");
        List<Product> alist= (List<Product>) deMap.get("list");
        client.shutdown();


    }
    /**
     * http POST请求示例
     */
    @ApiOperation("删除产品")
    @RequestMapping(value = "/deleteProduct.api", method = RequestMethod.POST)
    @ResponseBody
    public static void addProduct() throws Exception {
        AepProductManagementClient client = AepProductManagementClient.newClient().appKey("pEkFAjvrdh4").appSecret("nbHwqyy40h").build();

        DeleteProductRequest request = new DeleteProductRequest();
         request.setParamMasterKey(Constants.CWTING_INFO.MASTER_KEY);	// single value
         request.setParamProductId(Constants.CWTING_INFO.PRODUCT_ID);	// single value
        System.out.println(client.DeleteProduct(request));
        client.shutdown();
    }


    /**
     * http POST请求示例
     */
    @ApiOperation("上下线接收通知")
    @RequestMapping(value = "/receiveInfo.api", method = RequestMethod.POST)
    @ResponseBody
    public  AjaxResult receiveInfo(HttpServletRequest request, HttpSession session) throws Exception {
            String result = readInputStream(request.getInputStream());

            JSONObject json = JSONObject.parseObject(result);
            DeviceOnlineReport deviceOnlineReport = JsonUtils.toBean(result, DeviceOnlineReport.class);

            logger.info(deviceOnlineReport+"------------------------------------------------------------------------------------------------");
            logger.info(deviceOnlineReport.getDeviceId()+"------------------------------------------------------------------------------------------------");
            logger.info(deviceOnlineReport.getEventType()+"------------------------------------------------------------------------------------------------");
            logger.info(deviceOnlineReport.getTimestamp()+"----------------------------");
            logger.info(json+"------------------------------------------------------------------------------------------------");
            logger.info("receive info ---------------------------------------------------------------------------------------");
        return AjaxResult.success("success");
    }

    /**
     * http POST请求示例
     */
    @ApiOperation("设备数据变化通知")
    @RequestMapping(value = "/changeDataReport.api", method = RequestMethod.POST)
    @ResponseBody
    public  AjaxResult changeDataReport(HttpServletRequest request, HttpSession session) throws Exception {
            String result = readInputStream(request.getInputStream());

            JSONObject json = JSONObject.parseObject(result);
            DeviceChangeReport deviceChangeReport = JsonUtils.toBean(result, DeviceChangeReport.class);

            logger.info(deviceChangeReport.getDeviceId()+"----------------changeDataReport--------------------------------------------------------------------------------");
            logger.info(deviceChangeReport.getEventType()+"---------------changeDataReport---------------------------------------------------------------------------------");
            logger.info(deviceChangeReport.getTimestamp()+"-------------changeDataReport---------------");
            logger.info(deviceChangeReport.getPayload()+"------changeDataReport-------------");
            logger.info(json+"-----------------------------------changeDataReport-------------------------------------------------------------");
        return AjaxResult.success("success");
    }

    /**
     * http POST请求示例
     */
    @ApiOperation("事件上报通知")
    @RequestMapping(value = "/eventReport.api", method = RequestMethod.POST)
    @ResponseBody
    public  AjaxResult eventReport(HttpServletRequest request, HttpSession session) throws Exception {
        String result = readInputStream(request.getInputStream());

        JSONObject json = JSONObject.parseObject(result);
        DeviceEventReport deviceEventReport = JsonUtils.toBean(result, DeviceEventReport.class);

        logger.info(deviceEventReport+"------------------------------eventReport------------------------------------------------------------------");
        logger.info(deviceEventReport.getDeviceId()+"----------------eventReport--------------------------------------------------------------------------------");
        logger.info(deviceEventReport.getEventType()+"---------------eventReport---------------------------------------------------------------------------------");
        logger.info(deviceEventReport.getTimestamp()+"-------------eventReport---------------");
        logger.info(deviceEventReport.getEventContent()+"------eventReport-------------");
        logger.info(json+"-----------------------------------eventReport-------------------------------------------------------------");
        return AjaxResult.success("success");
    }


    /**
     * 在线设备总数
     */
    @ApiOperation("在线设备总数")
    @RequestMapping(value = "/onlineDeviceCount.api", method = RequestMethod.POST)
    @ResponseBody
    public static AjaxResult onlineDeviceCount() throws Exception {
        AepProductManagementClient client = AepProductManagementClient.newClient().appKey("pEkFAjvrdh4").appSecret("nbHwqyy40h").build();
        QueryProductListRequest request = new QueryProductListRequest();
        QueryProductListResponse queryProductListResponse = client.QueryProductList(request);
        Map<String, Object> map = JsonUtils.toMap(new String(queryProductListResponse.getBody(), "UTF-8"));
        Map<String,Object>  zmap= (Map<String,Object>)map.get("result");
        List<Product> list = JsonUtils.toBeanList(zmap.get("list").toString(), Product.class);
        int total = list.stream().mapToInt(Product::getOnlineDeviceCount).sum();
        return AjaxResult.success("查询成功!",total);
    }



     public String readInputStream(ServletInputStream servletInputStream){
         String result="";
         try {
             BufferedReader br = new BufferedReader(new InputStreamReader(servletInputStream,"utf-8"));
             StringBuffer sb = new StringBuffer("");
             String temp;
             while ((temp = br.readLine()) != null) {
                 sb.append(temp);
             }
             result = sb.toString();
         }catch (Exception e){
             e.printStackTrace();
         }
         return result;
     }



    /**
     * http POST请求示例
     */
    @ApiOperation("createServe")
    @RequestMapping(value = "/createServe.api", method = RequestMethod.POST)
    @ResponseBody
    public static String createServe() throws Exception {
        List<String> list=new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        sb.append("http://qt.gtimg.cn/q=s_sz002145");
        String body = HttpRequest.get(sb.toString()).execute().body();
        StringBuilder sb1 = new StringBuilder();
        sb1.append("http://qt.gtimg.cn/q=s_sh601216");
        String body1 = HttpRequest.get(sb1.toString()).execute().body();
        StringBuilder sb2= new StringBuilder();
        sb2.append("http://qt.gtimg.cn/q=s_sh601127");
        String body2 = HttpRequest.get(sb2.toString()).execute().body();
        StringBuilder sb4= new StringBuilder();
        sb4.append("http://qt.gtimg.cn/q=s_sh000001");
        String body4 = HttpRequest.get(sb4.toString()).execute().body();
        StringBuilder sb5= new StringBuilder();
        sb5.append("http://qt.gtimg.cn/q=s_sh601901");
        String body5 = HttpRequest.get(sb5.toString()).execute().body();
        StringBuilder sb6= new StringBuilder();
        sb6.append("http://qt.gtimg.cn/q=s_sh600515");
        String body6 = HttpRequest.get(sb6.toString()).execute().body();
        StringBuilder sb7= new StringBuilder();
        sb7.append("http://qt.gtimg.cn/q=s_sh601015");
        String body7 = HttpRequest.get(sb7.toString()).execute().body();
        StringBuilder sb8= new StringBuilder();
        sb8.append("http://qt.gtimg.cn/q=s_sz003035");
        String body8 = HttpRequest.get(sb8.toString()).execute().body();
        StringBuilder sb9= new StringBuilder();
        sb9.append("http://qt.gtimg.cn/q=s_sh600844");
        String body9 = HttpRequest.get(sb9.toString()).execute().body();
        list.add(body);
        list.add(body1);
        list.add(body2);
        list.add(body5);
        list.add(body6);
        list.add(body7);
        list.add(body8);
        list.add(body4);
        list.add(body9);
        List<StockInfo> infos = splitString(list);
          return "";
    }

    public static List<StockInfo> splitString(List<String> list){
        List<StockInfo> infos= new ArrayList<>();
        for (String s : list) {
            String[] split = s.substring(s.indexOf("=")).split("~");
            StockInfo stockInfo=new StockInfo();
            stockInfo.setName(split[1]);
            stockInfo.setCode(split[2]);
            stockInfo.setPrice(split[3]);
            stockInfo.setIncrease(split[4]);
            stockInfo.setIncreasePercent(split[5]);
            stockInfo.setTurnover(split[6]);
            stockInfo.setVolumeOfTranscation(split[7]);
            infos.add(stockInfo);
        }
        return infos;
    }

    @Autowired
    private   Scheduler scheduler;

    /**
     * 手动创建定时任务
     */
    @ApiOperation("qrtzQuery")
    @RequestMapping(value = "/qrtzQuery.api", method = RequestMethod.POST)
    @ResponseBody
    public  String qrtzQuery() throws Exception {
        SysJob sysJob=new SysJob();
        sysJob.setJobId(101L);
        sysJob.setInvokeTarget("qrtzQueryTask.noParams");
        sysJob.setJobGroup("DEFAULT");
        sysJob.setJobName("test");
        sysJob.setCronExpression("1/2 * * * * ? *");
        sysJob.setMisfirePolicy("3");
        sysJob.setStatus("0");
        sysJob.setConcurrent("1");
        ScheduleUtils.createScheduleJob(scheduler,sysJob);
        return "";
    }




}
