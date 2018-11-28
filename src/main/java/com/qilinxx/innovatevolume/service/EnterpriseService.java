package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.Provider;

import java.util.List;

public interface EnterpriseService {
    /**查询所有的科技企业 */
 List<Enterprise> selectAll();
    /** 根据主键id获取对象*/
    Enterprise selectById(String id);

    /** 重新审核该科技企业，设置状态为0 主键id*/
    String examineEnterprise(String id);
    /** 审核通过该科技企业 主键id*/
    String startEnterprise(String id);
    /** 审核未通过 主键id*/
    String noExamineEnterprise(String id);
    /** 检验商家码是否已经被使用*/
    String ifCodeUse(String code);
    /** 更新科技企业*/
    void updateEnterprise(Enterprise enterprise);
    /** 根据code查询对象*/
    List<Enterprise> selectByCode(String code);
}
