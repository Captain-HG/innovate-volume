package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.configure.WebConst;
import com.qilinxx.innovatevolume.domain.mapper.UserInfoMapper;
import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.service.UserInfoService;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.vo.UserInfoVo;
import com.qilinxx.innovatevolume.vo.VoucherApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private EnterpriseService enterpriseService;
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
}
