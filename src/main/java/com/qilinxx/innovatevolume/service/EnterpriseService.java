package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface EnterpriseService {
    /**查询所有的科技企业 */
 List<Enterprise> selectAll();
    /** 根据主键id获取对象*/
    Enterprise selectById(String id);
    /** 重新审核该科技企业，设置状态为0 主键id*/
    String examineEnterprise(String id);
    /** 审核通过该科技企业 主键id*/
    String startEnterprise(String id);
    /** 审核未通过 主键id*/
    String noExamineEnterprise(String id);
    /** 检验商家码是否已经被使用*/
    String ifCodeUse(String code);
    /** 更新科技企业*/
    void updateEnterprise(Enterprise enterprise);
    /** 根据code查询对象*/
    List<Enterprise> selectByCode(String code);
    /**通过组织机构代码得到该企业*/
    Enterprise selectEnterpriseByCode(String code);
    /**更新企业信息，并且取出最新的企业信息*/
    Enterprise updateEnterpriseInfo(Enterprise enterprise);
    /**通过contractList中的EnterpriseId，存为Map，其中存储企业信息*/
    Map<String, Enterprise> contractListToEnterpriseMap(List<Contract> contractList);
   /**通过id查找查找该企业*/
   Enterprise selectEnterpriseById(String id);
   /**通过voucherApplyList中的EnterpriseId，存为Map，其中存储企业信息*/
   Map<String, Enterprise> voucherApplyListToEnterpriseMap(List<VoucherApply> voucherApplyList);
   /** 插入注册用户信息*/
    String addEnterpriseUser(String txtCompanyName, String txtOrganizationCode, String txtRegDate,
                    String txtCreateTime, BigDecimal txtRegisteredCapital,
                    BigDecimal txtLastYearIncome, int txtEmployeesNum,
                    String txtLegalPerson, String txtContactName, String txtContactPhone,
                    String txtContactMail, String field, String txtAccountName, String txtBankName,
                    String txtBankID, String txtBankAccount, String txtRegAddress,
                    String txtCompanyAddress, String Area2, String txtIntroduce, String txtTechCertificate);
}
