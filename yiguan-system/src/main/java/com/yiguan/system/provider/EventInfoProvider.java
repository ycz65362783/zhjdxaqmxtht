package com.yiguan.system.provider;

import com.yiguan.common.core.domain.entity.EventInfo;
import com.yiguan.common.provider.SQL;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:04
  */
public class EventInfoProvider {
    public String queryEventInfoList(EventInfo eventInfo) {
        return new SQL() {
            {SELECT("mi.id id"
                    ,"mi.map_info_name mapInfoName"
                    ,"mi.map_info_type mapInfoType"
                    ,"mi.own_company ownCompany"
                    ,"mi.last_edit_time lastEditTime"
                    ,"mi.create_time createTime"
                    ,"mi.create_by createBy"
                    ,"mi.update_time updateTime"
                    ,"mi.update_by updateBy"
                    ,"mi.is_deleted isDeleted"
                    ,"mi.job_supervisor jobSuperVisor"
                    ,"ju.job_user_name jobSupervisorName"
            );
                FROM("event_info ei");
            }
        }.toString();
    }

}
