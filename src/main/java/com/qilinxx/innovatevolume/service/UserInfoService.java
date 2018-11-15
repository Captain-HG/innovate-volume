package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.UserInfo;

public interface UserInfoService  {
    /** 根据公司编号查询用户信息*/
    UserInfo selectByCode(String code);
}
