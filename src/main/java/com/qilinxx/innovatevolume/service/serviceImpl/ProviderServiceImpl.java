package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ProviderMapper;
import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.service.ProviderService;
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
    public Provider selectById(String code) {
        return providerMapper.selectByPrimaryKey(code);
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
        provider.setState("1");
        providerMapper.updateByPrimaryKeySelective(provider);
        return null;
    }

    @Override
    public String noExamineProvider(String id) {
        Provider provider = providerMapper.selectByPrimaryKey(id);
        provider.setState("2");
        providerMapper.updateByPrimaryKeySelective(provider);
        return null;
    }
}
