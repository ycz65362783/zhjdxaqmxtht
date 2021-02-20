package com.yiguan.system.provider;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.JobUser;
import com.yiguan.common.provider.SQL;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:04
  */
public class JobUserProvider {
    public String query(JobUser jobUser) {
        return new SQL() {
            {SELECT("ju.id id"
                    , "ju.job_user_name jobUserName"
                    , "ju.gender gender "
                    ,"ju.phone phone"
                    ,"ju.birth_date birthDate"
                    ,"concat(ju.birth_date,'  ',TIMESTAMPDIFF(YEAR,ju.birth_date,CURDATE()),'年') age"
                    ,"ju.join_job_date joinJobDate"
                    ,"concat(ju.join_job_date,'  ',TIMESTAMPDIFF(YEAR,ju.join_job_date,CURDATE()),'年') workAge"
                    ,"ju.national national"
                    ,"ju.native_place nativePlace"
                    ,"ju.school_record schoolRecord"
                    ,"ju.political_landscape politicalLandspace"
                    ,"ju.professional_title professionalTitle"
                    ,"ju.post post"
                    ,"ju.team_group teamGroup"
                    ,"ju.work_unit workUnit"
                    ,"ju.create_by createBy"
                    ,"ju.create_time createTime"
                    ,"ju.update_by updateBy"
                    ,"ju.update_time updateTime"
                    ,"ju.is_deleted isDeleted"
            );
                FROM("job_user ju");
                WHERE_EQUAL_TO("ju.is_deleted", Constants.IS_DELETED.NO);
                WHERE_LIKE_ALL("ju.job_user_name",jobUser.getJobUserName());
                WHERE_LIKE_ALL("ju.phone", jobUser.getPhone());
                WHERE_LIKE_ALL("ju.work_unit",jobUser.getWorkUnit());
                WHERE_LIKE_ALL("ju.team_group",jobUser.getTeamGroup());
                WHERE_EQUAL_TO("ju.professionalTitle",jobUser.getProfessionalTitle());
                WHERE_EQUAL_TO("ju.school_record", jobUser.getSchool_record());
                WHERE_EQUAL_TO("ju.id", jobUser.getId());

            }
        }.toString();
    }


    public String countJobUsers() {
        return new SQL() {
            {SELECT("count(*)"
            );
                FROM("job_user ju");
                WHERE_EQUAL_TO("ju.is_deleted", Constants.IS_DELETED.NO);

            }
        }.toString();
    }
}
