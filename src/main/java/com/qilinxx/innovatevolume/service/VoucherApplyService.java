package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.VoucherApply;

import java.util.List;

public interface VoucherApplyService {
    /**插入一条申请记录*/
    void insertVoucherApply(VoucherApply voucherApply);
    /**根据id，删除指定记录*/
    void deleteVoucherApply(String id);
    /**根据企业enterpriseId，查询出该企业的所有申请记录*/
    List<VoucherApply> selectVoucherApplyByEnterpriseId(String enterpriseId);
}
