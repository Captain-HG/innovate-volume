package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.Provider;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProviderMapper extends Mapper<Provider>{
    /** 通过编码查询提供商*/
    List<Provider> selectByCode(String code);
}