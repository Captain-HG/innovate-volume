package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ProviderMapper;
import com.qilinxx.innovatevolume.domain.mapper.UserInfoMapper;
import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.service.UserInfoService;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    ProviderMapper providerMapper;
    @Override
    public UserInfo selectByCode(String code) {
        return userInfoMapper.selectByCode(code);
    }

    @Override
    public String ifRegisterProvider(String account) {
       UserInfo userInfo = userInfoMapper.selectByAccount(account);
       if(userInfo==null){
           return "false";
       }
       else {
           List<Provider> providerList = providerMapper.selectByCode(userInfo.getOrgcode());
           if (providerList.size() > 0 || providerList != null) {
               return "false";
           } else {
               return "true";
           }
       }
    }

    @Override
    public String ifUserAccountAndOrgCode(String account, String orgCode) {
        if(account==null&&orgCode!=null){
            UserInfo userInfo = userInfoMapper.selectByCode(orgCode);
            if (userInfo==null){return "true";}
            else{
                return "商家码已被使用";
            }
        }
        if (account!=null&&orgCode==null){
            UserInfo userInfo = userInfoMapper.selectByAccount(account);
            if (userInfo==null){return "true";}
            else{
                return "账号已被使用";
            }
        }
        if (account!=null&&orgCode!=null){
            UserInfo userInfo1 = userInfoMapper.selectByCode(orgCode);
            UserInfo userInfo2 = userInfoMapper.selectByAccount(account);
            if (userInfo1==null&&userInfo2==null){
                return "true";
            }
            else{
                return "账号或者商家码已被使用";
            }
        }
        else {
            return "不能为空";
        }
        }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfo.setId(UUID.UU32());
        userInfo.setCreateTime((long) DateKit.getCurrentUnixTime());
        userInfo.setCreater(userInfo.getName());//创建人设置为用户名
        userInfo.setState(true);
        userInfo.setUpdater(userInfo.getName());//表中设置错误为非空
        userInfo.setIsUse("1");
        userInfoMapper.insert(userInfo);
    }
}
