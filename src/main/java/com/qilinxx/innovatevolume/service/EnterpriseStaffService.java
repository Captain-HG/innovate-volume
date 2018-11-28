package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.EnterpriseStaff;

import java.util.List;

public interface EnterpriseStaffService {
    /** 根据科技企业id，查询所有的人员*/
    List<EnterpriseStaff> selectAllByEnterpriseId(String id);
    /** 使其失效*/
    void noExamineStaff(Integer id);
    /** 启用该人员*/
    void startStaff(Integer id);
    /** 根据id查询*/
    EnterpriseStaff selectById(Integer id);
    /** 更新人员*/
    void updateEnterpriseStaff(EnterpriseStaff enterpriseStaff);
    /**添加一条记录*/
    void insertEnterpriseStaff(EnterpriseStaff enterpriseStaff);
    /**根据id删除一条记录*/
    void deleteEnterpriseStaff(String id);

}
