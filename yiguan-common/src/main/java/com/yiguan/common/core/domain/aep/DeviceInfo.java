package com.yiguan.common.core.domain.aep;

public class DeviceInfo
{
    private String deviceId;  //设备ID

    private String deviceSn;  //设备No

    private String imei;  //设备imei
    
    private String deviceName; //设备名称

    private String tenantId; //租户id,必填

    private Integer productId; //产品id,必填 
    
    private Integer deviceStatus; //设备状态
    
    private String firmwareVersion; //版本号

    public String getDeviceId()
    {
        return deviceId;
    }
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    public String getDeviceSn()
    {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn)
    {
        this.deviceSn = deviceSn;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }
    
    public String getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(String tenantId)
    {
        this.tenantId = tenantId;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public Integer getDeviceStatus()
    {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus)
    {
        this.deviceStatus = deviceStatus;
    }

    public String getFirmwareVersion()
    {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion)
    {
        this.firmwareVersion = firmwareVersion;
    }

    
//    @Override
//    public String toString()
//    {
//        StringBuffer logStr = new StringBuffer();
//        logStr.append("deviceId = [")
//            .append(deviceId)
//            .append("],deviceSn = [")
//            .append(deviceSn)
//            .append("],deviceName = [")
//            .append(deviceName)
//            .append("].")
//            .append("tenantId = [")
//            .append(tenantId)
//            .append("],productId = [")
//            .append(productId)
//            .append("],deviceStatus = [")
//            .append(deviceStatus)
//            .append("],firmwareVersion = [")
//            .append(firmwareVersion)
//            .append("].") ;  
//        return logStr.toString();
//    }  
    
}
