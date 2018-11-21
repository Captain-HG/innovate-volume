package com.qilinxx.innovatevolume.vo;

import com.qilinxx.innovatevolume.domain.model.Contract;

public class ContractVo extends Contract {
    private String providerName;//提供商名
    private String enterpriseName;//科技企业名
    private String voucherName;//券名

    @Override
    public String toString() {
        return "ContractVo{" +
                "providerName='" + providerName + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", voucherName='" + voucherName + '\'' +
                '}';
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }
}
