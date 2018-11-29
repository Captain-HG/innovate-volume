package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.vo.UserInfoVo;

import java.util.List;

public interface UserInfoService {
    /**
     * 根据公司编号查询用户信息    这个功能没有实际用处，调试完可删除
     */
    UserInfo selectByCode(String code);

    /**
     * 修改密码,并且返回完整用户信息
     */
    UserInfo updateUserInfoPassword(UserInfo userInfo);

    /**
     * 添加服务提供商或创新企业的user基本信息
     *
     * @param account  账号
     * @param password 密码
     * @param name     机构名称
     * @return 当前操作详情
     */
    String addRegisterUser(String account, String password, String name);

    String updateRegisterUser(String account, String orgCode, String type);

    /**
     * 为添加用户绑定手机号
     *
     * @param account 账号
     * @param phone   手机号
     * @return 当前操作详情
     */
    String updateUserPhone(String account, String phone);

    /**
     * 查询所有user
     */
    List<UserInfoVo> selectVoAll();

    /**
     * 根据id查找对象
     */
    UserInfo selectById(String id);

    /**
     * 更新用户
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 失效用户
     */
    void noExamineUserInfo(String id);

    /**
     * 启用用户
     */
    void startUserInfo(String id);

    /**
     * 验证用户登录信息
     * @param name 用户名
     * @param pwd 密码
     * @param type 用户类型
     * @return 验证状态，success未成功，其他为错误信息
     */
    String loginUser(String name,String pwd,String type);
}
