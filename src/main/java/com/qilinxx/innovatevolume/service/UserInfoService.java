package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.UserInfo;

public interface UserInfoService  {
    /** 根据公司编号查询用户信息    这个功能没有实际用处，调试完可删除*/
    UserInfo selectByCode(String code);
    /**修改密码,并且返回完整用户信息*/
    UserInfo updateUserInfoPassword(UserInfo userInfo);
}
