package com.yiguan.system.provider;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.JobUser;
import com.yiguan.common.core.domain.entity.SafetyHat;
import com.yiguan.common.provider.SQL;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:04
  */
public class SafetyHatProvider {
    public String querySafetyHatParamList(SafetyHat safetyHat) {
        return new SQL() {
            {SELECT("sh.id id"
                    ,"sh.safety_hat_name safetyHatName"
                    ,"sh.safety_hat_no safetyHatNo"
                    ,"ju.job_user_name bindUserName"
                    ,"sh.own_company ownCompany"
                    ,"sh.team_group teamGroup"
                    ,"sh.online_status onlineStatus"
                    ,"sh.battery_voltage batteryVoltage"
                    ,"sh.remaining_electricity remainingElectricity"
                    ,"sh.bind_RFID bindRFID"
                    ,"sh.bind_UWB bindUWB"
                    ,"sh.battery_threshold batteryThreshold"
                    ,"sh.create_time createTime"
                    ,"sh.create_by createBy"
                    ,"sh.update_time updateTime"
                    ,"sh.update_by updateBy"
                    ,"sh.is_deleted isDeleted"
                    ,"sh.enabled enabled"
                    ,"sh.model_type modelType"
                    ,"sh.model_name modelName"
                    ,"sh.remark remark"
                    ,"sh.description description"
                    ,"sh.longitude longitude"
                    ,"sh.latitude latitude"
                    ,"sh.PUID PUID"
            );
                FROM("safety_hat sh");
                LEFT_OUTER_JOIN("job_user ju on ju.id = sh.bind_user_id");
                WHERE_EQUAL_TO("sh.is_deleted", Constants.IS_DELETED.NO);
                WHERE_EQUAL_TO("sh.id", safetyHat.getId());
                WHERE_LIKE_ALL("sh.safety_hat_name",safetyHat.getSafetyHatName());
                WHERE_LIKE_ALL("sh.own_company", safetyHat.getOwnCompany());
                WHERE_LIKE_ALL("sh.team_group", safetyHat.getTeamGroup());
                WHERE_EQUAL_TO("sh.online_status", safetyHat.getOnlineStatus());
                WHERE_LIKE_ALL("sh.safety_hat_no",safetyHat.getSafetyHatNo());
            }
        }.toString();
    }
}
