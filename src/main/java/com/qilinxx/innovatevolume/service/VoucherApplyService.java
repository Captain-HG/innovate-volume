package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.vo.VoucherApplyVo;

import java.util.List;

public interface VoucherApplyService {
    /** 根据主键id去查询，券的名字*/
    String selectVoucherNameById(String applyId);
    /** 根据主键id查询所有的申请记录，封装成Vo，包括双方企业名字,券名，继承VoucherApply*/
    List<VoucherApplyVo> selectAllByEnterpriseId(String id);
    /** 申请记录不通过*/
    void noExamineApply(String id);
    /** 申请记录通过*/
    void startApply(String id);
}
