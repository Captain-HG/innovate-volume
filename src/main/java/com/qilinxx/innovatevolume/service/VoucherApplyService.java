package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.VoucherApply;

import java.util.List;

public interface VoucherApplyService {
    /**插入一条申请记录*/
    void insertVoucherApply(VoucherApply voucherApply);
    /**根据id，修改创新券申请的是否可用（isUse）*/
    void updateIsUseById(String id,String isUse);
    /**根据id，删除指定记录*/
    void deleteVoucherApply(String id);
    /**根据企业enterpriseId，查询出该企业的所有申请记录*/
    List<VoucherApply> selectVoucherApplyByEnterpriseId(String enterpriseId);
    /**根据服务商providerId，查询出该服务商的收到的所有申请记录*/
    List<VoucherApply> selectVoucherApplyByProviderId(String providerId);
}
