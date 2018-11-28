package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseFileMapper;
import com.qilinxx.innovatevolume.domain.model.EnterpriseFile;
import com.qilinxx.innovatevolume.service.EnterpriseFileService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @Auther: dqsdc
 * @Date: 2018-11-28 15:29
 * @Description:
 */
@Service
public class EnterpriseFileImpl implements EnterpriseFileService {

    @Autowired
    EnterpriseFileMapper enterpriseFileMapper;


    @Override
    public String addFile(String enterpriseId, String path, String filename, String create) {
        EnterpriseFile file=new EnterpriseFile();
        file.setEnterpriseId(enterpriseId);
        file.setType(path.substring(path.lastIndexOf(".") + 1));
        file.setName(filename);
        file.setCreater(create);
        file.setCreateTime(DateKit.getUnixTimeLong());
        file.setIsUse("0");
        enterpriseFileMapper.insert(file);
        return "已完成";
    }
}
