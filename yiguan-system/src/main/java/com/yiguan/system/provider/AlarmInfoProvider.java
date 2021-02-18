package com.yiguan.system.provider;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.AlarmInfo;
import com.yiguan.common.core.domain.model.ProjectModel;
import com.yiguan.common.provider.SQL;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:04
  */
public class AlarmInfoProvider {
    public String query(AlarmInfo alarmInfo) {
        return new SQL() {
            {SELECT("ai.id id"
                    ,"ai.own_company ownCompany"
                    ,"ai.work_unit workUnit"
                    ,"ai.job_supervisor jobSupervisor"
                    ,"ju.job_user_name jobSupervisorName"
                    ,"ai.alarm_picture alarmPicture"
                    ,"ai.alarm_content alarmContent"
                    ,"ai.alarm_time alarmTime"
                    ,"ai.alarm_source alarmSource"
                    ,"ai.create_time createTime"
                    ,"ai.create_by createBy"
                    ,"ai.update_time updateTime"
                    ,"ai.update_by updateBy"
                    ,"ai.is_deleted isDeleted"
                    ,"ai.project_id projectId"
                    ,"pro.project_name projectName"

            );
                FROM("alarm_info ai");
                LEFT_OUTER_JOIN("job_user ju on ju.id = ai.job_supervisor");
                LEFT_OUTER_JOIN("project pro on pro.id = ai.project_id");
                WHERE_EQUAL_TO("ai.is_deleted", Constants.IS_DELETED.NO);
                WHERE_LIKE_ALL("ai.alarm_content",alarmInfo.getAlarmContent());
                WHERE_EQUAL_TO("ai.alarm_time", alarmInfo.getAlarmTime());
                WHERE_EQUAL_TO("ai.alarm_source", alarmInfo.getAlarmSource());
                WHERE_EQUAL_TO("ai.id", alarmInfo.getId());

            }
        }.toString();
    }

}
