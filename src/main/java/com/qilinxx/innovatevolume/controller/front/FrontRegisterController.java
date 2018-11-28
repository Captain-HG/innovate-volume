package com.qilinxx.innovatevolume.controller.front;

import com.qilinxx.innovatevolume.configure.WebConst;
import com.qilinxx.innovatevolume.service.EnterpriseFileService;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.service.UserInfoService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * @Auther: dqsdc
 * @Date: 2018-11-21 16:28
 * @Description: 注册信息服务类
 */
@Controller
@RequestMapping("/register")
public class FrontRegisterController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    EnterpriseFileService enterpriseFileService;

    /**
     * 注册科技中小型企业
     *
     * @param txtUserName          用户名
     * @param txtPwd               登录密码
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
     * @param filename9            企业营业执照副本
     * @param filename10           组织机构代码证副本
     * @param filename11           法定代表人身份证
     * @param filename1            企业管理制度和财务管理制度
     * @param filename2            近两年的财务报表（包括资产负债表、损益表）
     * @param filename3            高新技术企业认证
     * @param filename12           其他材料
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/addEnterpriseUser")
    @ResponseBody
    public JSONObject addEnterpriseUser(String txtUserName, String txtPwd, String txtCompanyName,
                                        String txtOrganizationCode, String txtRegDate,
                                        String txtCreateTime, BigDecimal txtRegisteredCapital,
                                        BigDecimal txtLastYearIncome, int txtEmployeesNum,
                                        String txtLegalPerson, String txtContactName, String txtContactPhone,
                                        String txtContactMail, String field, String txtAccountName, String txtBankName,
                                        String txtBankID, String txtBankAccount, String txtRegAddress,
                                        String txtCompanyAddress, String Area2, String txtIntroduce, String txtTechCertificate,
                                        String filename9, String filename10, String filename11, String filename1, String filename2,
                                        String filename3, String filename12) {
        JSONObject json = new JSONObject();
        String msg = userInfoService.addRegisterUser(txtUserName, txtPwd, txtCompanyName);
        if (msg.equals("用户名已被注册")) {
            json.put("message", 0);
            json.put("content", msg);
            return json;
        }
        String uuid = enterpriseService.addEnterpriseUser(txtCompanyName, txtOrganizationCode, txtRegDate, txtCreateTime, txtRegisteredCapital, txtLastYearIncome, txtEmployeesNum, txtLegalPerson, txtContactName, txtContactPhone, txtContactMail, field, txtAccountName, txtBankName, txtBankID, txtBankAccount, txtRegAddress, txtCompanyAddress, Area2, txtIntroduce, txtTechCertificate);
        String msg2 = userInfoService.updateRegisterUser(txtUserName, txtOrganizationCode, WebConst.USER_TYPE_ENTERPRISE);

        if (msg2.equals("无此用户")) {
            json.put("message", 0);
            json.put("content", msg2);
            return json;
        }

        enterpriseFileService.addFile(uuid, filename9, "企业营业执照副本", txtUserName);
        enterpriseFileService.addFile(uuid, filename11, "法定代表人身份证", txtUserName);
        enterpriseFileService.addFile(uuid, filename1, "企业管理制度和财务管理制度", txtUserName);
        enterpriseFileService.addFile(uuid, filename2, "近两年的财务报表（包括资产负债表、损益表）", txtUserName);

        if (filename10 != null) enterpriseFileService.addFile(uuid, filename10, "组织机构代码证副本", txtUserName);
        if (filename3 != null) enterpriseFileService.addFile(uuid, filename3, "高新技术企业认证", txtUserName);
        if (filename12 != null) enterpriseFileService.addFile(uuid, filename12, "其他材料", txtUserName);

        json.put("message", 1);
        json.put("content", msg2);
        return json;
    }


    @RequestMapping("/addProviderUser")
    @ResponseBody
    public JSONObject addProviderUser(String txtServiceUser2, String txtPwd3, String txtServiceName2) {
        JSONObject json = new JSONObject();
        String msg = userInfoService.addRegisterUser(txtServiceUser2, txtPwd3, txtServiceName2);
        if (msg.equals("用户名已被注册")) {
            json.put("message", 0);
            json.put("content", msg);
        } else {
            json.put("message", 1);
            json.put("content", msg);
        }
        return json;
    }

    @RequestMapping("/addRegisterPhone")
    @ResponseBody
    public JSONObject addRegisterPhone(String username, String type, String code, String phone) {
        JSONObject json = new JSONObject();
        System.out.println(username + "  " + type + "  " + code + "  " + phone);
        String msg = userInfoService.updateUserPhone(username, phone);
        if (msg.equals("非法操作")) {
            json.put("message", 0);
            json.put("content", msg);
        } else {
            json.put("message", 1);
            json.put("content", msg);
        }
        return json;
    }

    @RequestMapping("/getSmsCode")
    @ResponseBody
    public JSONObject getSmsCode(HttpSession session, String code, String phone) {
        JSONObject json = new JSONObject();
        String identify = (String) session.getAttribute(WebConst.SESSION_IDENTIFY_CODE);
        if (!identify.toLowerCase().equals(code.toLowerCase())) {
            json.put("message", 0);
            json.put("content", "验证码错误");
            return json;
        } else {
            json.put("message", 1);
            json.put("content", "短信已发送");
            //发短信接口
            return json;
        }
    }
}
