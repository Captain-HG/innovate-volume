package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.ProviderService;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProviderServiceMapper extends Mapper<ProviderService>{
    /** 根据商家id查询所有服务内容*/
    List<ProviderService> selectAllByProviderId(String id);
}