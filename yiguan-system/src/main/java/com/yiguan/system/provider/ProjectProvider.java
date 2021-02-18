package com.yiguan.system.provider;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.model.ProjectModel;
import com.yiguan.common.provider.SQL;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:04
  */
public class ProjectProvider {
    public String query(ProjectModel projectModel) {
        return new SQL() {
            {SELECT("p.id id"
                    ,"p.project_name projectName"
                    ,"p.manage_unit manageUnit"
                    ,"p.job_unit jobUnit"
                    ,"p.risk_level riskLevel"
                    ,"p.job_supervisor jobSupervisor"
                    ,"p.job_user jobUser"
                    ,"p.job_content jobContent"
                    ,"p.job_address jobAddress"
                    ,"p.plan_start_time planStartTime"
                    ,"p.plan_end_time planEndTime"
                    ,"p.create_time createTime"
                    ,"p.create_by   createBy"
                    ,"p.update_time updateTime"
                    ,"p.update_by updateBy"
                    ,"p.is_deleted isDeleted"
                    ,"ju.job_user_name jobUserName"
                    ,"jus.job_user_name jobSupervisorName"
            );
                FROM("project p");
                LEFT_OUTER_JOIN("job_user ju on ju.id = p.job_user");
                LEFT_OUTER_JOIN("job_user jus on jus.id = p.job_supervisor");
                WHERE_EQUAL_TO("p.is_deleted", Constants.IS_DELETED.NO);
                WHERE_LIKE_ALL("p.manage_unit",projectModel.getManageUnit());
                WHERE_LIKE_ALL("p.job_unit",projectModel.getJobUnit());
                WHERE_LIKE_ALL("ju.job_user_name", projectModel.getJobUserName());
                WHERE_LIKE_ALL("jus.job_user_name", projectModel.getJobSupervisorName());
                WHERE_EQUAL_TO("p.id", projectModel.getId());


            }
        }.toString();
    }

}
