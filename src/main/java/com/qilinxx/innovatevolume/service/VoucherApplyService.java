package com.qilinxx.innovatevolume.service;

public interface VoucherApplyService {
    /** 根据主键id去查询，券的名字*/
    String selectVoucherNameById(String applyId);
}
