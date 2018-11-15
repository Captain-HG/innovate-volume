package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Provider;

import java.util.List;

public interface ProviderService {
    /**查询所有的提供商 */
    List<Provider> selectAll();
    /** 根据id查询提供商的信息*/
    Provider selectById(String code);
     /** 重新审核该提供商，设置状态为0*/
    String examineProvider(String id);
    /** 审核通过该商家*/
    String startActivity(String id);
    /** 审核未通过*/
    String noExamineProvider(String id);
}
