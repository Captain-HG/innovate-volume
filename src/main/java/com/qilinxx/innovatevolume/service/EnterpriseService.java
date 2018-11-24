package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;

import java.util.List;
import java.util.Map;

public interface EnterpriseService {
    /**查询所有的科技企业 */
 List<Enterprise> selectAll();
    /**通过组织机构代码得到该企业*/
 Enterprise selectEnterpriseByCode(String code);
    /**更新企业信息，并且取出最新的企业信息*/
    Enterprise updateEnterpriseInfo(Enterprise enterprise);
    /**根据voucherApplyList中的enterpriseId,找到指定的所有企业信息，存入Map中*/
    Map<String,Enterprise> voucherApplyListToEnterpriseMap(List<VoucherApply> voucherApplyList);
}
