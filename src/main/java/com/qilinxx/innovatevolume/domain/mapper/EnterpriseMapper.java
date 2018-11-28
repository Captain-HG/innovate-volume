package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.Enterprise;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface EnterpriseMapper extends Mapper<Enterprise>{
    /** 查询对象根据商家码*/
    List<Enterprise> selectByCode(String code);
}