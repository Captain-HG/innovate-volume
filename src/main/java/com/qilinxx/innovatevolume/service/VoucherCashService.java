package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.VoucherCash;

import java.util.List;

public interface VoucherCashService {
    /** 查询所有的兑付申请*/
    List<VoucherCash> selectAll();
}
