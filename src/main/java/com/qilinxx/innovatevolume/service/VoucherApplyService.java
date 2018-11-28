package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.vo.VoucherApplyVo;

import java.util.List;

public interface VoucherApplyService {


    /** 根据主键id去查询，券的名字*/
    String selectVoucherNameById(String applyId);
    /** 根据主键id查询所有的申请记录，封装成Vo，包括双方企业名字,券名，继承VoucherApply*/
    List<VoucherApplyVo> selectAllByEnterpriseId(String id);
    /** 申请记录不通过，设为2*/
    void noExamineApply(String id);
    /** 申请记录通过，设为1*/
    void startApply(String id);
    /** 查询所有未审核的申请，并封装*/
    List<VoucherApplyVo> selectAllVoByIsUseNo();
    /** 通过主键id查询，封装好*/
    VoucherApplyVo selectVobyId(String id);
    /** 根据主键id查询对象*/
    VoucherApply selectById(String applyId);
    /** 重审此申请，设为0*/
    void examineApply(String id);
    /** 更新*/
    void update(VoucherApply voucherApply);
}
