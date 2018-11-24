package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseFileMapper;
import com.qilinxx.innovatevolume.domain.model.EnterpriseFile;
import com.qilinxx.innovatevolume.service.EnterpriseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseFileServiceImpl implements EnterpriseFileService {
    @Autowired
    EnterpriseFileMapper enterpriseFileMapper;

    @Override
    public List<EnterpriseFile> selectAllByEnterpriseId(String id) {
        return enterpriseFileMapper.selectAllByEnterpriseId(id);
    }

    @Override
    public void noExamineFile(Integer id) {
        EnterpriseFile enterpriseFile = enterpriseFileMapper.selectByPrimaryKey(id);
        enterpriseFile.setIsUse("0");
        enterpriseFileMapper.updateByPrimaryKeySelective(enterpriseFile);
    }

    @Override
    public void startFile(Integer id) {
        EnterpriseFile enterpriseFile = enterpriseFileMapper.selectByPrimaryKey(id);
        enterpriseFile.setIsUse("1");
        enterpriseFileMapper.updateByPrimaryKeySelective(enterpriseFile);
    }
}
