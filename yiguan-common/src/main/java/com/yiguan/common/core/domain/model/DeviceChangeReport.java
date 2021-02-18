package com.yiguan.common.core.domain.model;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据变化上报
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
@Getter
@Setter
public class DeviceChangeReport {

    private String tenantId;

    private String productId;

    private String deviceId;

    private String messageType;

    private String eventType;

    private String imei;

    private String imsi;

    private String deviceType;

    private String topic;

    private String assocAssetId;

    private String upPacketSN;

    private String upDataSN;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private JSON payload;

    private String serviceId;

    private String protocol;

}

