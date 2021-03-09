package com.yiguan.system.provider;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.EventInfo;
import com.yiguan.common.core.domain.model.EventInfoModel;
import com.yiguan.common.provider.SQL;

import java.text.SimpleDateFormat;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:04
  */
public class EventInfoProvider {
    public String queryEventInfoList(EventInfoModel eventInfoModel) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return new SQL() {
            {SELECT("ei.id id"
                    ,"ei.event_type eventType"
                    ,"ei.device_name deviceName"
                    ,"ei.job_supervisor jobSupervisor"
                    ,"ei.hook_time hookTime"
                    ,"ei.online_time onlineTime"
                    ,"ei.offline_time offlineTime"
                    ,"ei.demolition_time demolitionTime"
                    ,"ei.create_time createTime"
                    ,"ei.create_by createBy"
                    ,"ei.update_by updateBy"
                    ,"ei.update_time updateTime"
                    ,"ei.is_deleted isDeleted"
                    ,"ju.job_user_name jobSupervisorName"
            );
                FROM("event_info ei");
                LEFT_OUTER_JOIN("job_user ju on ju.id = ei.job_supervisor");
                WHERE_EQUAL_TO("ei.is_deleted", Constants.IS_DELETED.NO);
                WHERE_LIKE_ALL("ei.device_name", eventInfoModel.getDeviceName());
                WHERE_EQUAL_TO("ei.event_type", eventInfoModel.getEventType());
                if(eventInfoModel.getOnlineTime()!=null){
                    String time = simpleDateFormat.format(eventInfoModel.getOnlineTime());
                    WHERE_EQUAL_TO("Date(ei.online_time)", time);
                }
                if(eventInfoModel.getOfflineTime()!=null){
                    String time = simpleDateFormat.format(eventInfoModel.getOfflineTime());
                    WHERE_EQUAL_TO("Date(ei.offline_time)", time);
                }
            }
        }.toString();
    }

}
