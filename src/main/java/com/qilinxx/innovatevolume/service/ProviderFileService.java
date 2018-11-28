package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.ProviderFile;
import jdk.nashorn.internal.ir.IdentNode;

import java.util.List;

public interface ProviderFileService {
    /** 根据商家id，查询所有文件*/
    List<ProviderFile> selectAllByProviderId(String id);
    /** 使某个文件失效*/
    void noExamineFile(Integer id);
    /** 启用某个文件*/
    void startFile(Integer id);

}
