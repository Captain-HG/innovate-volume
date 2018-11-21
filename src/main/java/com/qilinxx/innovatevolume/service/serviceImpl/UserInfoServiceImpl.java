package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.UserInfoMapper;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.domain.model.UserInfoExample;
import com.qilinxx.innovatevolume.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public UserInfo selectByCode(String code) {
        UserInfoExample userInfoExample=new UserInfoExample();
        userInfoExample.createCriteria().andOrgcodeEqualTo(code);
        return  userInfoMapper.selectByExample(userInfoExample).get(0);
    }

    @Override
    public UserInfo updateUserInfoPassword(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return userInfoMapper.selectByPrimaryKey(userInfo.getId());
    }
}
