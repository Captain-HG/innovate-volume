package com.qilinxx.innovatevolume.domain.mapper;


import com.qilinxx.innovatevolume.domain.model.ProviderFile;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProviderFileMapper extends Mapper<ProviderFile>{
    /** 通过商家id查找所有相关的文件*/
    List<ProviderFile> selectAllByProviderId(String id);
    /** 来了鬼的根据id查询*/
    ProviderFile selectById(Integer id);
}