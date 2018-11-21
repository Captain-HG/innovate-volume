package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Provider;

import java.util.List;

public interface ProviderService {
    /**查询所有的提供商 */
    List<Provider> selectAll();
    /** 根据主键id查询提供商的信息*/
    Provider selectById(String  id);
     /** 重新审核该提供商，设置状态为0 主键id*/
    String examineProvider(String id);
    /** 审核通过该商家 主键id*/
    String startProvider(String id);
    /** 审核未通过 主键id*/
    String noExamineProvider(String id);
    /** 检验商家码是否已经被使用*/
    String ifCodeUse(String code);
    /** 更新商家*/
    void updateProvider(Provider provider);
}
