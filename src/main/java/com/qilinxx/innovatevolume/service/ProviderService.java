package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.Voucher;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;

import java.util.List;
import java.util.Map;

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
    /** 根据商家码查询*/
    List<Provider> selectByCode(String code);

    /**更新商家信息，并且返回商家信息*/
    Provider updateProviderInfo(Provider provider);
    /**根据组织代码code，查找商家*/
    Provider selectProviderBycode(String code);
    /** 由创新券list的中提供商的id找到提供商，转换为Map，其中存储提供商所有信息*/
    Map<String,Provider> voucherListToProviderMap(List<Voucher> vouchers);
    /** 由创新券申请表list的中提供商的id找到提供商，转换为Map，其中存储提供商所有信息*/
    Map<String,Provider> voucherApplyListToProviderMap(List<VoucherApply> voucherApplyList);
    /** 由合同表list的中提供商的id找到提供商，转换为Map，其中存储提供商所有信息*/
    Map<String,Provider> contractListToProviderMap(List<Contract> contractList);
}
