package com.qilinxx.innovatevolume.vo;

import com.qilinxx.innovatevolume.domain.model.UserInfo;

/**
 * 封装user对象
 * 包含公司名，和其他信息
 */
public class UserInfoVo extends UserInfo {
  String companyName;//公司名

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
