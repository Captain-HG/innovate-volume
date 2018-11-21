package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.ProviderStaff;

import java.util.List;

public interface ProviderStaffService {
    /** 根据商家id查询商家的领军人物*/
    List<ProviderStaff> selectAllByProviderId(String id);
    /** 失效人员 主键id*/
    void noExamineStaff(Integer id);
    /** 启用人员 主键id*/
    void startStaff(Integer id);
    /** 根据id查询对象*/
    ProviderStaff selectById(Integer id);
    /** 修改人员*/
    void updateProviderStaff(ProviderStaff providerStaff);
}
