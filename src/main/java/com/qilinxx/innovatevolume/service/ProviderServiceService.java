package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.ProviderService;

import java.util.List;

public interface ProviderServiceService {
    /** 根据商家id查询他的所有服务内容*/
    List<ProviderService> selectAllByProviderId(String id);
    /** 失效服务 主键id*/
    void noExamineService(String  id);
    /** 启用服务 主键id*/
    void startService(String id);
    /** 查询某个服务 主键id*/
    ProviderService selectById(String id);
    /** 更新服务*/
    void updateProviderService(ProviderService providerService);
}
