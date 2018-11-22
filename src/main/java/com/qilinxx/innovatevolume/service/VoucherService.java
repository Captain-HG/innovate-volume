package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Voucher;

import java.util.List;

public interface VoucherService {
    /**企业查询所有状态为1(isUse=1),即可用的创新券  */
    List<Voucher> selectAll();
    /** 由id得到所需要的创新券*/
    Voucher selectVoucherById(String id);

}
