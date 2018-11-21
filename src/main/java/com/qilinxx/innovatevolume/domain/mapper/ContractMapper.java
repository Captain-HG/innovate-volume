package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.Contract;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ContractMapper extends Mapper<Contract>{
    /** 根据商家id查询所有合同*/
    List<Contract> selectAllByProviderId(String id);
}