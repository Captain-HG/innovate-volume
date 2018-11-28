package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ProviderMapper;
import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.ProviderExample;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    ProviderMapper providerMapper;
    @Override
    public List<Provider> selectAll() {
        return  providerMapper.selectAll();
    }

    @Override
    public Provider selectById(String  id) {

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
        if (providerList!=null||providerList.size()>0)
        {
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
    }

    @Override
    public List<Provider> selectByCode(String code) {
//        ProviderExample providerExample=new ProviderExample();
//        providerExample.createCriteria().andCodeEqualTo(code);
//        providerMapper.selectByExample(providerExample);
        return   providerMapper.selectByCode(code);
    }
}
