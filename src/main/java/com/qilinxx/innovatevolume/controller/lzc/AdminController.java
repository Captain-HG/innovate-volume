package com.qilinxx.innovatevolume.controller.lzc;

import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.VoucherCash;
import com.qilinxx.innovatevolume.service.ContractService;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.service.VoucherCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ProviderService providerService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    VoucherCashService voucherCashService;
    @Autowired
    ContractService contractService;
    /**
     *跳转到管理员的
     * 提供者页面的list
     */
    @RequestMapping("admin-provider-list")
    public String adminProviderList(Model model){
      List<Provider> providerList = providerService.selectAll();
          model.addAttribute("providerList",providerList);
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
        return "lzc/admin-voucherCash-list";
    }
    @RequestMapping("admin-contract-list")
    public  String adminContractList(Model model){
       List<Contract>  contractList = contractService.selectAll();
        model.addAttribute("contractList",contractList);
       return "lzc/admin-contract-list";
    }
}
