package com.yiguan.system.provider;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.AlarmInfo;
import com.yiguan.common.core.domain.entity.MapInfo;
import com.yiguan.common.core.domain.model.MapInfoModel;
import com.yiguan.common.provider.SQL;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/16 16:04
  */
public class MapInfoProvider {
    public String query(MapInfoModel mapInfoModel) {
        return new SQL() {
            {SELECT("mi.id id"
                    ,"mi.map_info_name mapInfoName"
                    ,"mi.map_info_type mapInfoType"
                    ,"mi.own_company ownCompany"
                    ,"mi.map_url mapUrl"
                    ,"mi.last_edit_time lastEditTime"
                    ,"mi.create_time createTime"
                    ,"mi.create_by createBy"
                    ,"mi.update_time updateTime"
                    ,"mi.update_by updateBy"
                    ,"mi.is_deleted isDeleted"
                    ,"mi.job_supervisor jobSuperVisor"
                    ,"ju.job_user_name jobSupervisorName"
            );
                FROM("map_info mi");
                LEFT_OUTER_JOIN("job_user ju on ju.id = mi.job_supervisor");
                WHERE_EQUAL_TO("mi.is_deleted", Constants.IS_DELETED.NO);
                WHERE_LIKE_ALL("mi.map_info_name",mapInfoModel.getMapInfoName());
                WHERE_EQUAL_TO("mi.id",mapInfoModel.getId());
                WHERE_LIKE_ALL("mi.own_company", mapInfoModel.getOwnCompany());
                WHERE_EQUAL_TO("mi.job_supervisor", mapInfoModel.getJobSupervisor());
                WHERE_LIKE_ALL("ju.job_user_name", mapInfoModel.getJobSupervisorName());
            }
        }.toString();
    }

}
