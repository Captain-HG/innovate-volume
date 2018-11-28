package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.ProviderService;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;

import java.util.List;
import java.util.Map;

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
    /**插入一条服务记录*/
    void insertProviderService(ProviderService providerService);
    /**删除一条服务记录*/
    void deleteProviderService(String id);
    /** 由创新券申请表list的中提供商的id找到提供商的服务内容，转换为Map，其中存储服务内容*/
    Map<String,String> voucherApplyListToProviderServiceMap(List<VoucherApply> voucherApplyList);
}
