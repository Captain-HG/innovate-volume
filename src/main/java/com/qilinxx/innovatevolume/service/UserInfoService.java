package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.UserInfo;

public interface UserInfoService  {
    /** 根据公司编号查询用户信息*/
    UserInfo selectByCode(String code);
    /** 通过user账号验证是否已经注册过提供商*/
    String  ifRegisterProvider(String account);
    /** 检验账号，商家码是否被使用*/
    String ifUserAccountAndOrgCode(String account, String orgCode);
    /** 增加用户*/
    void addUser(UserInfo userInfo);
}
