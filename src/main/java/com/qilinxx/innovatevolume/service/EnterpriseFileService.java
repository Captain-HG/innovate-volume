package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.EnterpriseFile;

import java.util.List;

public interface EnterpriseFileService {
    /** 根据科技企业id查询所有文件*/
    List<EnterpriseFile> selectAllByEnterpriseId(String id);
    /** 失效文件*/
    void noExamineFile(Integer id);
    /** 启用文件*/
    void startFile(Integer id);
}
