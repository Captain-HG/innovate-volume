package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.UserInfoMapper;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo selectByCode(String code) {
        return userInfoMapper.selectByCode(code);
    }
}
