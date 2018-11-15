package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Enterprise;

import java.util.List;

public interface EnterpriseService {
    /**查询所有的科技企业 */
 List<Enterprise> selectAll();
    /**通过组织机构代码得到该企业*/
 Enterprise selectEnterpriseByCode(String code);
}
