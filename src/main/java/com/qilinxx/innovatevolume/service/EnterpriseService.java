package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Enterprise;

import java.util.List;

public interface EnterpriseService {
    /**查询所有的科技企业 */
 List<Enterprise> selectAll();
}
