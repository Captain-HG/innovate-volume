package com.qilinxx.innovatevolume.domain.mapper;


import com.qilinxx.innovatevolume.domain.model.EnterpriseFile;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface EnterpriseFileMapper extends Mapper<EnterpriseFile> {
     /** 根据科技企业的id查询所有文件*/
    List<EnterpriseFile> selectAllByEnterpriseId(String id);
}