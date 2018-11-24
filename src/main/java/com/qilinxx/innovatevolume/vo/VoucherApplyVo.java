package com.qilinxx.innovatevolume.vo;

import com.qilinxx.innovatevolume.domain.model.VoucherApply;

public class VoucherApplyVo extends VoucherApply {
   private  String enterpriseName;//科技企业的名字
   private  String providerName;//提供商的名字
   private  String voucherName;//创新卷的名字

    public VoucherApplyVo() {
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    @Override
    public String toString() {
        return "VoucherApplyVo{" +
                "enterpriseName='" + enterpriseName + '\'' +
                ", providerName='" + providerName + '\'' +
                ", voucherName='" + voucherName + '\'' +
                '}';
    }
}
