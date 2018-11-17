package com.qilinxx.innovatevolume.controller.lzc;

import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.*;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.util.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminProviderController {
    @Autowired
    ProviderService providerService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    VoucherCashService voucherCashService;
    @Autowired
    ContractService contractService;
    @Autowired
    UserInfoService userInfoService;
    /**
     *跳转到管理员的
     * 提供者页面的list
     */
    @RequestMapping("admin-provider-list")
    public String adminProviderList(Model model){
      List<Provider> providerList = providerService.selectAll();
          model.addAttribute("providerList",providerList);
        model.addAttribute("commons",new Commons());
        return "lzc/admin-provider-list";
    }
    /**
     * 跳转到管理者的
     * 科技企业/创新团队的list页面
     */
    @RequestMapping("admin-enterprise-list")
    public String  adminEnterpriseList(Model model){
        List<Enterprise> enterPriseList=enterpriseService.selectAll();
        model.addAttribute("enterPriseList",enterPriseList);
        model.addAttribute("commons",new Commons());
        return "lzc/admin-enterprise-list";
    }

    /**
     * 兑付的申请list页面
     * @return 页面跳转
     */
    @RequestMapping("admin-voucherCash-list")
    public String  adminVoucherCashList(Model model){
        List<VoucherCash> voucherCashList = voucherCashService.selectAll();
        model.addAttribute("voucherCashList",voucherCashList);
        model.addAttribute("commons",new Commons());
        return "lzc/admin-voucherCash-list";
    }

    /**
     * 管理员的合同list
     * @param model 传递
     * @return 页面
     */
    @RequestMapping("admin-contract-list")
    public  String adminContractList(Model model){
       List<Contract>  contractList = contractService.selectAll();
        model.addAttribute("contractList",contractList);
        model.addAttribute("commons",new Commons());
       return "lzc/admin-contract-list";
    }

    /**
     * 根据code公司编号查询，显示用户创建者的信息
     * @param code 公司编号
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-creater-show")
    public String providerCreaterShow(String code,Model model){
       UserInfo userInfo = userInfoService.selectByCode(code);
        model.addAttribute("commons",new Commons());
       model.addAttribute("userInfo",userInfo);
        return "lzc/admin-provider-creater-show";
    }
    /**
     * 查看提供商的基本信息
     * @param code 提供商id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-show")
    public String providerShow(String code,Model model){
        Provider provider = providerService.selectById(code);
        model.addAttribute("provider",provider);
        model.addAttribute("commons",new Commons());
        return "lzc/admin-provider-show";
    }
    /**
     * 查看提供商的联系人基本信息
     * @param code 提供商id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-contacter-show")
    public String providerContacterShow(String code,Model model){
        Provider provider = providerService.selectById(code);
        model.addAttribute("provider",provider);
        return "lzc/admin-provider-contacter-show";
    }
    /**
     * 查看提供商的基本信息
     * @param code 提供商id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-admin-show")
    public String providerAdminShow(String code,Model model){
        Provider provider = providerService.selectById(code);
        model.addAttribute("provider",provider);
        return "lzc/admin-provider-admin-show";
    }
    /**
     * 重新审核此提供商
     * @param id  提供商id
     * @return 成功
     */
    @RequestMapping("admin-examine-provider")
    @ResponseBody
    public String examineProvider(String id, HttpServletRequest request) {
        providerService.examineProvider(id);
        // System.out.println("传过来的语句："+str);
        //  logService.insertLog(str,userId(request),userIp(request));
        return "success";
    }
    /**
     * 审核此商家未通过
     * @param id  商家id
     * @return 成功
     */
    @RequestMapping("admin-noExamine-provider")
    @ResponseBody
    public String noExamineProvider(String id, HttpServletRequest request) {
         providerService.noExamineProvider(id);
        // System.out.println("传过来的语句："+str);
        //  logService.insertLog(str,userId(request),userIp(request));
        return "success";
    }
    /**
     * 审核通过
     * @param id  商家id
     * @return 成功
     */
    @RequestMapping("admin-start-provider")
    @ResponseBody
    public String startProvide(String id, HttpServletRequest request) {
        String str = providerService.startProvider(id);
        // System.out.println("传过来的语句："+str);
        //  logService.insertLog(str,userId(request),userIp(request));
        return "success";
    }


    /**
     * 通过用户账号查找对象，通过user的公司编码测试是否已经注册过提供商
     * @param account
     * @return
     */
    @RequestMapping("admin-ajaxRegister")
    @ResponseBody
    public String userAjaxRegister(String account){
        return userInfoService.ifRegisterProvider(account);
    }
    /**
     * 修改提供商页面跳转
     * @return 修改页面
     */
    @RequestMapping("admin-provider-update.html")
    public String providerAddUI(){
        return "admin-provider-update";
    }

    /**
     * 添加商家的实现
     * @return
     */
    @RequestMapping("admin-provider-add")
    @ResponseBody
    public String providerAdd(Provider provider){
   System.out.println(provider.toString());

        return "success";
    }
//    khkjhl
}
