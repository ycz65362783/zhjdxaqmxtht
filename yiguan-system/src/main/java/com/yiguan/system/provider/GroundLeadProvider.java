package com.yiguan.system.provider;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.model.GroundLeadModel;
import com.yiguan.common.provider.SQL;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:04
  */
public class GroundLeadProvider {
    public String querySysInfoList(GroundLeadModel groundLeadModel) {
        return new SQL() {
            {SELECT("gl.id id"
                    , "gl.ground_lead_name groundLeadName"
                    ,"gl.ground_lead_type groundLeadType"
                    ,"gl.ground_lead_no groundLeadNo"
                    ,"gl.mount_point_name mountPointName"
                    ,"gl.bind_UWB bindUWB"
                    ,"gl.team_group teamGroup"
                    ,"gl.own_company ownCompany"
                    ,"gl.battery_voltage_level batteryVoltageLevel"
                    ,"gl.production_date productionDate"
                    ,"gl.trial_date trialDate"
                    ,"gl.next_trial_date nextTrialDate"
                    ,"gl.lifecycle lifecycle"
                    ,"gl.battery_voltage_threshold batteryVoltageThreshold"
                    ,"gl.hook_threshold hookThreshold"
                    ,"gl.create_by createBy"
                    ,"gl.create_time createTime"
                    ,"gl.update_by updateBy"
                    ,"gl.update_time updateTime"
                    ,"gl.is_deleted isDeleted"
                    ,"gl.online_status onlineStatus"
                    ,"ju.job_user_name jobUserName"
            );
                FROM("ground_lead gl");
                LEFT_OUTER_JOIN("job_user ju on ju.id = gl.job_user_id");
                LEFT_OUTER_JOIN("mount_point mp on mp.ground_lead_id = gl.id");
                WHERE_EQUAL_TO("gl.is_deleted", Constants.IS_DELETED.NO);
                WHERE_EQUAL_TO("gl.id",groundLeadModel.getId());
                WHERE_LIKE_ALL("gl.ground_lead_name", groundLeadModel.getGroundLeadName());
                WHERE_LIKE_ALL("gl.team_group", groundLeadModel.getTeamGroup());
                WHERE_LIKE_ALL("gl.own_company", groundLeadModel.getOwnCompany());

            }
        }.toString();
    }


    public String queryDeviceInfoList(GroundLeadModel groundLeadModel) {
        return new SQL() {
            {SELECT("gl.id id"
                    , "gl.ground_lead_name groundLeadName"
                    ,"gl.ground_lead_type groundLeadType"
                    ,"gl.ground_lead_no groundLeadNo"
                    ,"gl.mount_point_name mountPointName"
                    ,"gl.online_status onlineStatus"
                    ,"gl.job_user_id jobUserId"
                    ,"ju.job_user_name jobUserName"
                    ,"gl.own_company ownCompany"
                    ,"gl.team_group teamGroup"
                    ,"gl.battery_voltage_level batteryVoltageLevel"
                    ,"gl.remaining_electricity remainingElecticity"
            );
                FROM("ground_lead gl");
                LEFT_OUTER_JOIN("job_user ju on ju.id = gl.job_user_id");
                LEFT_OUTER_JOIN("mount_point mp on mp.ground_lead_id = gl.id");
                WHERE_EQUAL_TO("gl.id", groundLeadModel.getId());
                WHERE_LIKE_ALL("gl.ground_lead_name", groundLeadModel.getGroundLeadName());
                WHERE_EQUAL_TO("gl.ground_lead_no", groundLeadModel.getGroundLeadNo());
                WHERE_LIKE_ALL("gl.own_company", groundLeadModel.getOwnCompany());
                WHERE_LIKE_ALL("gl.team_group", groundLeadModel.getTeamGroup());

            }
        }.toString();
    }
}
