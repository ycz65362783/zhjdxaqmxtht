package com.yiguan.system.service.impl;

import com.yiguan.common.constant.Constants;
import com.yiguan.common.core.domain.entity.ApplianceStore;
import com.yiguan.system.mapper.ApplianceStoreMapper;
import com.yiguan.system.service.IApplianceStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
@Service
public class ApplianceStoreServiceImpl implements IApplianceStoreService {

    @Autowired
    private ApplianceStoreMapper applianceStoreMapper;

    @Override
    public ApplianceStore getApplianceStoreByGroundLeadId(String groundLeadId){
        ApplianceStore applianceStore=new ApplianceStore();
        applianceStore.setGroundLeadId(groundLeadId);
        applianceStore.setIsDeleted(Constants.IS_DELETED.NO);
        return applianceStoreMapper.selectOne(applianceStore);
    }

}
