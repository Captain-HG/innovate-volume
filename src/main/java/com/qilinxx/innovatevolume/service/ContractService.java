package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Contract;

import java.util.List;

public interface ContractService {
    /** 查询所有合同*/
    List<Contract> selectAll();
}
