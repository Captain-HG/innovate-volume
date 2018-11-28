package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.configure.WebConst;
import com.qilinxx.innovatevolume.domain.mapper.UserInfoMapper;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.domain.model.UserInfoExample;
import com.qilinxx.innovatevolume.service.UserInfoService;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectByCode(String code) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andOrgcodeEqualTo(code);
        return userInfoMapper.selectByExample(userInfoExample).get(0);
    }

    @Override
    public UserInfo updateUserInfoPassword(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return userInfoMapper.selectByPrimaryKey(userInfo.getId());
    }

    @Override
    public String addRegisterUser(String account, String password, String name) {
        UserInfo user = userInfoMapper.selectByAccount(account);
        if (user != null) return "用户名已被注册";
        UserInfo userInfo = new UserInfo();
        userInfo.setId(UUID.UU32());
        userInfo.setAccount(account);
        userInfo.setPassword(password);
        userInfo.setIsUse("0");
        userInfo.setName(name);
        userInfo.setCreater(account);
        userInfo.setCreateTime(DateKit.getUnixTimeLong());
        userInfoMapper.insert(userInfo);
        return "注册成功";
    }

    @Override
    public String updateRegisterUser(String account,String orgCode, String type) {
        UserInfo userInfo=userInfoMapper.selectByAccount(account);
        if (userInfo==null) return "无此用户";
        userInfo.setUserType(type);
        userInfo.setOrgcode(orgCode);
        userInfoMapper.updateByPrimaryKey(userInfo);
        return "success";
    }

    @Override
    public String updateUserPhone(String account, String phone) {
        UserInfo userInfo=userInfoMapper.selectByAccount(account);
        if(userInfo==null) return "非法操作";
        userInfo.setPhone(phone);
        userInfoMapper.updateByPrimaryKey(userInfo);
        return "更新完成";
    }


}
