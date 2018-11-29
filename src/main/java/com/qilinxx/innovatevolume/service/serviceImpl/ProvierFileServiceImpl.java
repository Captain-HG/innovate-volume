package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ProviderFileMapper;
import com.qilinxx.innovatevolume.domain.model.ProviderFile;
import com.qilinxx.innovatevolume.service.ProviderFileService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvierFileServiceImpl implements ProviderFileService {
    @Autowired
    ProviderFileMapper providerFileMapper;
    @Override
    public List<ProviderFile> selectAllByProviderId(String id) {
        return providerFileMapper.selectAllByProviderId(id);
    }

    @Override
    public void noExamineFile(Integer id) {
        ProviderFile providerFile = providerFileMapper.selectById(id);
        providerFile.setUpdateTime((long) DateKit.getCurrentUnixTime());
        providerFile.setIsUse("0");
        //providerFile.setUpdater();相应取修改者
        providerFileMapper.updateByPrimaryKeySelective(providerFile);
    }

    @Override
    public void startFile(Integer id) {
        ProviderFile providerFile = providerFileMapper.selectById(id);
        providerFile.setUpdateTime((long) DateKit.getCurrentUnixTime());
        //providerFile.setUpdater();相应取修改者
        providerFile.setIsUse("1");
        providerFileMapper.updateByPrimaryKeySelective(providerFile);
    }

    @Override
    public ProviderFile selectById(Integer id) {
        return providerFileMapper.selectByPrimaryKey(id);
    }
}
