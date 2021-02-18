package com.yiguan.common.core.domain.aep;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/22 9:20
  */
@Getter
@Setter
public class Product {

    private Integer productId;

    private String productName;

    private String tenantId;

    private String productDesc;

    private Integer productType;

    private Integer secondaryType;

    private Integer thirdType;

    private Integer productProtocol;

    private Integer authType;

    private Integer payloadFomart;

    private Integer networkType;

    private Integer endpointFormat;

    private Integer powerModel;

    private String apiKey;

    private Integer onlineCount;

    private Integer deviceConut;

    private String productTypeValue;

    private String secondaryTypeValue;

    private String thirdTypeValue;

    private Integer encryptionType;

    private String rootCert;

    private String createBy;

    private String updateBy;

    private String tupDeviceModel;

    private Integer nodeType;

    private Integer accsessType;

    private Integer onlineDeviceCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
