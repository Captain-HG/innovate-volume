package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.vo.ContractVo;

import java.util.List;

public interface ContractService {
    /** 查询所有合同*/
    List<Contract> selectAll();
    /** 查询封装的合同vo*/
    List<ContractVo> selectAllByProviderId(String id);
    /** 启用合同，主键id*/
    void startContract(String id);
    /** 使某个合同失效，主键id*/
    void noExamineContract(String id);
}
