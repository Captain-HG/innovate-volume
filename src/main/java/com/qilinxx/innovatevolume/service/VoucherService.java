package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Voucher;

import java.util.List;

public interface VoucherService {
     /** 根据商家id查找他的所有券*/
    List<Voucher> selectAllByProviderId(String id);
    /** 使某个券失效，主键id*/
    void noExamineVoucher(String id);
    /** 启用某个券，主键id*/
    void startVoucher(String id);
    /**根据券的id查找对象*/
    Voucher selectById(String id);
    /**根据券的id更新对象*/
    void updateVoucher(Voucher voucher);
}
