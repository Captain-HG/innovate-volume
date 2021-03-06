package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.configure.WebConst;
import com.qilinxx.innovatevolume.domain.mapper.EnterpriseMapper;
import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.service.UserInfoService;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    EnterpriseMapper enterpriseMapper;
    @Autowired
    UserInfoService userInfoService;

    @Override
    public Enterprise selectById(String id) {
        return enterpriseMapper.selectByPrimaryKey(id);
    }


    @Override
    public String examineEnterprise(String id) {
        Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
        enterprise.setIsUse("0");
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        return null;
    }

    @Override
    public String startEnterprise(String id) {
        Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
        enterprise.setIsUse("1");
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        return null;
    }

    @Override
    public String noExamineEnterprise(String id) {
        Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
        enterprise.setIsUse("2");
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        return null;
    }

    @Override
    public String ifCodeUse(String code) {
        List<Enterprise> enterpriseList = enterpriseMapper.selectByCode(code);
        if (enterpriseList!=null||enterpriseList.size()>0)
        {
            return "已被注册的商家码";
        }
        return "true";
    }

    @Override
    public void updateEnterprise(Enterprise enterprise) {
        //enterprise.setUpdater();//相对应的设置修改者
        enterprise.setUpdateTime((long) DateKit.getCurrentUnixTime());
        enterprise.setIsUse("0");
        UserInfo userInfo = userInfoService.selectByCode(enterprise.getCode());
        userInfo.setOrgcode(enterprise.getCode());
        //userInfo.setUpdater();
        userInfo.setUpdateTime((long) DateKit.getCurrentUnixTime());
        userInfoService.updateUserInfo(userInfo);
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
    }

    @Override
    public List<Enterprise> selectByCode(String code) {
        return enterpriseMapper.selectByCode(code);
    }
    @Override
    public Map<String, Enterprise> contractListToEnterpriseMap(List<Contract> contractList) {
        Map<String, Enterprise> enterpriseMap=new HashMap<>();
        for(Contract c:contractList){
            if(!enterpriseMap.containsKey(c.getEnterpriseId())){
                enterpriseMap.put(c.getEnterpriseId(),enterpriseMapper.selectByPrimaryKey(c.getEnterpriseId()));
            }
        }
        return enterpriseMap;
    }
    @Override
    public Enterprise selectEnterpriseById(String id) {
        return enterpriseMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Enterprise> voucherApplyListToEnterpriseMap(List<VoucherApply> voucherApplyList) {
        Map<String, Enterprise> enterpriseMap=new HashMap<>();
        for(VoucherApply v:voucherApplyList){
            if(!enterpriseMap.containsKey(v.getEnterpriseId())){
                enterpriseMap.put(v.getEnterpriseId(),enterpriseMapper.selectByPrimaryKey(v.getEnterpriseId()));
            }
        }
        return enterpriseMap;
    }

    @Override
    public List<Enterprise> selectAll() {
        return enterpriseMapper.selectAll();
    }

    @Override
    public Enterprise selectEnterpriseByCode(String code) {
        EnterpriseExample enterpriseExample = new EnterpriseExample();
        enterpriseExample.createCriteria().andCodeEqualTo(code);
        return enterpriseMapper.selectByExample(enterpriseExample).get(0);
    }

    @Override
    public Enterprise updateEnterpriseInfo(Enterprise enterprise) {
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        return enterpriseMapper.selectByPrimaryKey(enterprise.getId());
    }

    /**
     * 注册科技中小型企业
     *
     * @param txtCompanyName       企业名称
     * @param txtOrganizationCode  组织机构代码
     * @param txtRegDate           注册时间
     * @param txtCreateTime        成立时间
     * @param txtRegisteredCapital 注册资本
     * @param txtLastYearIncome    上一年度收入
     * @param txtEmployeesNum      职工总数
     * @param txtLegalPerson       法人代表
     * @param txtContactName       联系人
     * @param txtContactPhone      联系人手机
     * @param txtContactMail       联系人邮箱
     * @param field                技术领域
     * @param txtAccountName       开户名称
     * @param txtBankName          开户银行
     * @param txtBankID            开户银行行号
     * @param txtBankAccount       账号
     * @param txtRegAddress        注册地址
     * @param txtCompanyAddress    企业地址
     * @param Area2                企业区域
     * @param txtIntroduce         企业简介
     * @param txtTechCertificate   科技型中小企业认证编号
     */
    @Override
    public String addEnterpriseUser(String txtCompanyName, String txtOrganizationCode, String txtRegDate, String txtCreateTime, BigDecimal txtRegisteredCapital, BigDecimal txtLastYearIncome, int txtEmployeesNum, String txtLegalPerson, String txtContactName, String txtContactPhone, String txtContactMail, String field, String txtAccountName, String txtBankName, String txtBankID, String txtBankAccount, String txtRegAddress, String txtCompanyAddress, String Area2, String txtIntroduce, String txtTechCertificate) {
        Enterprise enterprise = new Enterprise();
        String uuid=UUID.UU32();
        enterprise.setId(uuid);
        enterprise.setName(txtCompanyName);
        enterprise.setCode(txtOrganizationCode);
        enterprise.setAdmin(txtLegalPerson);
        enterprise.setRegDate(DateKit.getUnixTimeLong(DateKit.dateFormat(txtRegDate,"yyyy-MM-dd")));
        enterprise.setFoundDate(DateKit.getUnixTimeLong(DateKit.dateFormat(txtCreateTime,"yyyy-MM-dd")));
        enterprise.setRegMoney(txtRegisteredCapital);
        enterprise.setRegAddr(txtRegAddress);
        enterprise.setContactAddr(txtCompanyAddress);
        enterprise.setSales(txtLastYearIncome);
        enterprise.setAmount(txtEmployeesNum);
        enterprise.setType(WebConst.ENTERPRISE_UNIT_SCIENCE);
        enterprise.setDomain(field);
        enterprise.setIdentify(WebConst.ENTERPRISE_IDENTIFY_YES);
        enterprise.setIdentifyNo(txtTechCertificate);
        enterprise.setDetail(txtIntroduce);
        enterprise.setBank(txtBankName);
        enterprise.setCardNo(txtBankAccount);
        enterprise.setCardOwner(txtAccountName);
        enterprise.setContacter(txtContactName);
        enterprise.setContactPhone(txtContactPhone);
        enterprise.setContactEmail(txtContactMail);
        enterprise.setIsUse("0");
        enterprise.setCreater(txtCompanyName);
        enterprise.setCreateTime(DateKit.getUnixTimeLong());
        System.out.println(enterprise);
        enterpriseMapper.insert(enterprise);
        return uuid;
    }

}
