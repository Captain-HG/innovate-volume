package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ContractMapper;
import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.ContractExample;
import com.qilinxx.innovatevolume.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
     @Autowired
    ContractMapper contractMapper;
    @Override
    public List<Contract> selectAll() { return contractMapper.selectAll();
    }

    @Override
    public List<Contract> selectContractByProviderId(String providerId) {
        ContractExample contractExample=new ContractExample();
        contractExample.createCriteria().andProviderIdEqualTo(providerId);
        return contractMapper.selectByExample(contractExample);
    }

    @Override
    public List<Contract> selectContractByEnterpriseId(String enterpriseId) {
        ContractExample contractExample=new ContractExample();
        contractExample.createCriteria().andEnterpriseIdEqualTo(enterpriseId);
        contractExample.setOrderByClause("create_time desc");
        return contractMapper.selectByExample(contractExample);
    }
}
