package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Voucher;

import java.util.List;

public interface VoucherService {
    /**企业查询所有状态为1(isUse=1),即可用的创新券  */
    List<Voucher> selectAll();
    /**插入一个新的创新券*/
    void insertVoucher(Voucher voucher);
    /** 由id得到所需要的创新券*/
    Voucher selectVoucherById(String id);
    /**由服务商的providerId，得到该服务商的所有已发布创新券*/
    List<Voucher> selectVoucherByProviderId(String providerId);
}
