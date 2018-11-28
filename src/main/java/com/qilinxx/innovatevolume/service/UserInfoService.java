package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.vo.UserInfoVo;

import java.util.List;

public interface UserInfoService  {
    /** 根据公司编号查询用户信息    这个功能没有实际用处，调试完可删除*/
    UserInfo selectByCode(String code);
    /**修改密码,并且返回完整用户信息*/
    UserInfo updateUserInfoPassword(UserInfo userInfo);
    /** 查询所有user*/
    List<UserInfoVo> selectVoAll();
    /** 根据id查找对象*/
    UserInfo selectById(String id);
    /** 更新用户*/
    void updateUserInfo(UserInfo userInfo);
   /** 失效用户*/
    void noExamineUserInfo(String id);
    /** 启用用户*/
    void startUserInfo(String id);
}
