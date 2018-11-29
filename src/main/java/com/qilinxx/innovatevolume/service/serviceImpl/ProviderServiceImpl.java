package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ProviderMapper;
import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.service.UserInfoService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    ProviderMapper providerMapper;
    @Autowired
    UserInfoService userInfoService;
    @Override
    public void insertProvider(Provider provider) {
        providerMapper.insert(provider);
    }

    @Override
    public List<Provider> selectAll() {
        return providerMapper.selectAll();
    }


    @Override
    public Provider updateProviderInfo(Provider provider) {
        providerMapper.updateByPrimaryKeySelective(provider);

        return providerMapper.selectByPrimaryKey(provider.getId());
    }

    @Override
    public Provider selectProviderBycode(String code) {
        ProviderExample providerExample = new ProviderExample();
        providerExample.createCriteria().andCodeEqualTo(code);
        providerMapper.selectByExample(providerExample);
        return providerMapper.selectByExample(providerExample).get(0);
    }

    @Override
    public Map<String, Provider> voucherListToProviderMap(List<Voucher> vouchers) {
        Map<String, Provider> providerMap = new HashMap<>();
        for (Voucher v : vouchers) {
            if (!providerMap.containsKey(v.getProviderId())) {
                providerMap.put(v.getProviderId(), providerMapper.selectByPrimaryKey(v.getProviderId()));
            }
        }
        return providerMap;
    }

    @Override
    public Map<String, Provider> voucherApplyListToProviderMap(List<VoucherApply> voucherApplyList) {
        Map<String, Provider> providerMap = new HashMap<>();
        for (VoucherApply v : voucherApplyList) {
            if (!providerMap.containsKey(v.getProviderId())) {
                providerMap.put(v.getProviderId(), providerMapper.selectByPrimaryKey(v.getProviderId()));
            }
        }
        return providerMap;
    }

    @Override
    public Map<String, Provider> contractListToProviderMap(List<Contract> contractList) {
        Map<String, Provider> providerMap = new HashMap<>();
        for (Contract c : contractList) {
            if (!providerMap.containsKey(c.getProviderId())) {
                providerMap.put(c.getProviderId(), providerMapper.selectByPrimaryKey(c.getProviderId()));
            }
        }
        return providerMap;
    }

    @Override
    public Provider selectById(String id) {

        return providerMapper.selectByPrimaryKey(id);

    }

    @Override
    public String examineProvider(String id) {
        Provider provider = providerMapper.selectByPrimaryKey(id);
        provider.setState("0");
        providerMapper.updateByPrimaryKeySelective(provider);
        return null;
    }

    @Override
    public String startProvider(String id) {
        Provider provider = providerMapper.selectByPrimaryKey(id);
        provider.setIsUse("1");
        providerMapper.updateByPrimaryKeySelective(provider);
        return null;
    }

    @Override
    public String noExamineProvider(String id) {
        Provider provider = providerMapper.selectByPrimaryKey(id);
        provider.setIsUse("0");
        providerMapper.updateByPrimaryKeySelective(provider);
        return null;
    }

    @Override
    public String ifCodeUse(String code) {
        List<Provider> providerList = providerMapper.selectByCode(code);
        if (providerList != null || providerList.size() > 0) {
            return "已被注册的商家码";
        }
        return "true";
    }

    @Override
    public void updateProvider(Provider provider) {
        provider.setUpdateTime((long) DateKit.getCurrentUnixTime());
        //provider.setUpdater();//这里相应的进行修改，如果管理员修改添加管理员的信息
        provider.setIsUse("0");
        providerMapper.updateByPrimaryKeySelective(provider);
        UserInfo userInfo = userInfoService.selectByCode(provider.getCode());
        userInfo.setOrgcode(provider.getCode());
        //userInfo.setUpdater();
        userInfo.setUpdateTime((long) DateKit.getCurrentUnixTime());
        userInfoService.updateUserInfo(userInfo);
    }

    @Override
    public List<Provider> selectByCode(String code) {
//        ProviderExample providerExample=new ProviderExample();
//        providerExample.createCriteria().andCodeEqualTo(code);
//        providerMapper.selectByExample(providerExample);
        return providerMapper.selectByCode(code);
    }
}
