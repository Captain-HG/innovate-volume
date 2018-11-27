package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Contract;

import java.util.List;

public interface ContractService {
    /** 查询所有合同*/
    List<Contract> selectAll();
    /**查询该提供商id的合同*/
    List<Contract> selectContractByProviderId(String providerId);
    /**查询该企业id的合同*/
    List<Contract> selectContractByEnterpriseId(String enterpriseId);
}
