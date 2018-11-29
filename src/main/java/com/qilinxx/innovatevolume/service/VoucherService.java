package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Voucher;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;

import java.util.List;
import java.util.Map;

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
    /**企业查询所有状态为1(isUse=1),即可用的创新券  */
    List<Voucher> selectAll();
    /**插入一个新的创新券*/
    void insertVoucher(Voucher voucher);
    /**删除指定id的记录*/
    void deleteVoucher(String id);
    /** 由id得到所需要的创新券*/
    Voucher selectVoucherById(String id);
    /**由服务商的providerId，得到该服务商的所有已发布创新券*/
    List<Voucher> selectVoucherByProviderId(String providerId);
    /**由创新券申请记录list中，找到创新券id，存为Map，其中存储创新券名称*/
    Map<String ,Voucher> voucherApplyListToVoucherMap(List<VoucherApply> voucherApplyList);
}
