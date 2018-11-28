package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Enterprise;

import java.math.BigDecimal;
import java.util.List;

public interface EnterpriseService {
    /**查询所有的科技企业 */
 List<Enterprise> selectAll();
    /**通过组织机构代码得到该企业*/
 Enterprise selectEnterpriseByCode(String code);
    /**更新企业信息，并且取出最新的企业信息*/
    Enterprise updateEnterpriseInfo(Enterprise enterprise);
    /** 插入注册用户信息*/
    String addEnterpriseUser(String txtCompanyName, String txtOrganizationCode, String txtRegDate,
                    String txtCreateTime, BigDecimal txtRegisteredCapital,
                    BigDecimal txtLastYearIncome, int txtEmployeesNum,
                    String txtLegalPerson, String txtContactName, String txtContactPhone,
                    String txtContactMail, String field, String txtAccountName, String txtBankName,
                    String txtBankID, String txtBankAccount, String txtRegAddress,
                    String txtCompanyAddress, String Area2, String txtIntroduce, String txtTechCertificate);
}
