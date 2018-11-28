package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.configure.WebConst;
import com.qilinxx.innovatevolume.domain.mapper.UserInfoMapper;
import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.service.UserInfoService;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.util.UUID;
import com.qilinxx.innovatevolume.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    ProviderService providerService;

    @Autowired
    EnterpriseService enterpriseService;

    @Override
    public UserInfo selectByCode(String code) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andOrgcodeEqualTo(code);
        return userInfoMapper.selectByExample(userInfoExample).get(0);
    }


    @Override
    public List<UserInfoVo> selectVoAll() {
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        List<UserInfoVo> UserInfoVoList = new ArrayList<>();
        for (UserInfo userInfo:userInfoList){
            UserInfoVoList.add(copy(userInfo));
        }
        return UserInfoVoList;
    }

    private UserInfoVo copy(UserInfo userInfo) {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setId(userInfo.getId());
        userInfoVo.setAccount(userInfo.getAccount());
        userInfoVo.setCreater(userInfo.getCreater());
        userInfoVo.setCreateTime(userInfo.getCreateTime());
        userInfoVo.setEmail(userInfo.getEmail());
        userInfoVo.setIsUse(userInfo.getIsUse());
        userInfoVo.setOrgcode(userInfo.getOrgcode());
        userInfoVo.setName(userInfo.getName());
        userInfoVo.setPassword(userInfo.getPassword());
        userInfoVo.setPhone(userInfo.getPhone());
        userInfoVo.setUserType(userInfo.getUserType());
        userInfoVo.setUpdateTime(userInfo.getUpdateTime());
        userInfoVo.setUpdater(userInfo.getUpdater());
        userInfoVo.setTel(userInfo.getTel());
        userInfoVo.setState(userInfo.getState());
        userInfoVo.setRemark(userInfo.getRemark());
        if (userInfo.getUserType().equals(WebConst.USER_TYPE[0])){//判定他为那种企业
            //根据code获得对象
            List<Provider> providerList = providerService.selectByCode(userInfo.getOrgcode());
            if (providerList.size()==1){
                //设置名字
                userInfoVo.setCompanyName(providerList.get(0).getName());
            }
            else{
                userInfoVo.setCompanyName("null");
            }
        }
        else if (userInfo.getUserType().equals(WebConst.USER_TYPE[1])){//科技企业
            List<Enterprise> enterpriseList = enterpriseService.selectByCode(userInfo.getOrgcode());
            if(enterpriseList.size()==1){
                userInfoVo.setCompanyName(enterpriseList.get(0).getName());
            }
            else{
                userInfoVo.setCompanyName("null");
            }
        }
        else {
            userInfoVo.setCompanyName("null");
        }
        return userInfoVo;
    }

    @Override
    public UserInfo selectById(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        // userInfo.setUpdater();
        userInfo.setUpdateTime((long) DateKit.getCurrentUnixTime());
        userInfo.setIsUse("0");
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void noExamineUserInfo(String id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        userInfo.setUpdateTime((long) DateKit.getCurrentUnixTime());
        //userInfo.setUpdater();
        userInfo.setIsUse("0");
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void startUserInfo(String id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        userInfo.setUpdateTime((long) DateKit.getCurrentUnixTime());
        //userInfo.setUpdater();
        userInfo.setIsUse("1");
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
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
