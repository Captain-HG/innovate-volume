package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.vo.VoucherApplyVo;

import java.util.List;
import java.util.Map;

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
    /**插入一条申请记录*/
    void insertVoucherApply(VoucherApply voucherApply);
    /**通过企业id查找所有创新券申请记录*/
    List<VoucherApply> selectVoucherApplyByEnterpriseId(String enterpriseId);
    /**通过id删除记录*/
    void deleteVoucherApply(String id);
    /**合同列表中的创业申请的id ，转为map ，其中存储申请记录所有信息*/
    Map<String,VoucherApply> contractListToVoucherApplyMap(List<Contract> contractList);
    /**由提供商的id，查找出所有的创新券申请记录*/
    List<VoucherApply> selectVoucherApplyByProviderId(String id);
    /**把指定id的记录的isUse更改*/
    void updateIsUseById(String id,String isUse);
}
