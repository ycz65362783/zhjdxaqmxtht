package com.yiguan.system.service;

import com.yiguan.common.core.domain.entity.ApplianceStore;


/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
public interface IApplianceStoreService {

    ApplianceStore getApplianceStoreByGroundLeadId(String groundLeadId);

}
