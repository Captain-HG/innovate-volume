package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.vo.ContractVo;

import java.util.List;

public interface ContractService {
    /** 查询所有合同*/
    List<Contract> selectAll();
    /** 查询封装的合同vo，包括双方企业名字,券名，继承Contract*/
    List<ContractVo> selectAllByProviderId(String id);
    /** 启用合同，主键id*/
    void startContract(String id);
    /** 使某个合同失效，主键id*/
    void noExamineContract(String id);
    /** 根据科技企业id，查询所有合同*/
    List<ContractVo> selectAllByEnterpriseId(String id);
    /** 查询所有合同，生成VoList*/
    List<ContractVo> selectAllVo();
    /** 根据主键id查询对象*/
    Contract selectById(String id);
    /** 更新*/
    void updateContract(Contract contract);
    /** 根据主键id查询，封装好的vo*/
    ContractVo selectVoById(String id);
    /** 增加合同*/
    void insert(Contract contract);
    /**查询该提供商id的合同*/
    List<Contract> selectContractByProviderId(String providerId);
    /**查询该企业id的合同*/
    List<Contract> selectContractByEnterpriseId(String enterpriseId);

}
