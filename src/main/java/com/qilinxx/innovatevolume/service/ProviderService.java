package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.Voucher;

import java.util.List;
import java.util.Map;

public interface ProviderService {
    /**查询所有的提供商 */
    List<Provider> selectAll();
    /** 根据id查询提供商的信息*/
    Provider selectById(String  id);
     /** 重新审核该提供商，设置状态为0*/
    String examineProvider(String id);
    /** 审核通过该商家*/
    String startProvider(String id);
    /** 审核未通过*/
    String noExamineProvider(String id);
    /** 检验商家码是否已经被使用*/
    String ifCodeUse(String code);
    /** 更新商家*/
    void updateProvider(Provider provider);
    /** 由创新券list的中提供商的id找到提供商的名字，转换为Map，其中存储提供商所有信息*/
    Map<String,Provider> voucherListToProviderMap(List<Voucher> vouchers);
}
