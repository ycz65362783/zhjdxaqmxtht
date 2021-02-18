package com.yiguan.quartz.task;

import cn.hutool.http.HttpRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务调度测试
 * 
 * @author ycz
 */
@Component("qrtzQueryTask")
public class QrtzQueryTask
{

    public void noParams()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("http://qt.gtimg.cn/q=s_sz002145");
        String body = HttpRequest.get(sb.toString()).execute().body();
        System.out.println(new Date()+":::::::::::"+body.toString());

    }
}
