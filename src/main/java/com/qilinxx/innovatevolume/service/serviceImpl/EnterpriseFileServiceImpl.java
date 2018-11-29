package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseFileMapper;
import com.qilinxx.innovatevolume.domain.model.EnterpriseFile;
import com.qilinxx.innovatevolume.service.EnterpriseFileService;
import com.qilinxx.innovatevolume.util.DateKit;
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
    @Override
    public String addFile(String enterpriseId, String path, String filename, String create) {
        EnterpriseFile file=new EnterpriseFile();
        file.setEnterpriseId(enterpriseId);
        file.setType(path.substring(path.lastIndexOf(".") + 1));
        file.setPath(path);
        file.setName(filename);
        file.setCreater(create);
        file.setCreateTime(DateKit.getUnixTimeLong());
        file.setIsUse("0");
        enterpriseFileMapper.insert(file);
        return "已完成";
    }

    @Override
    public EnterpriseFile selectById(Integer id) {
        return enterpriseFileMapper.selectByPrimaryKey(id);
    }
}
