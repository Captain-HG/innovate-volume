package com.qilinxx.innovatevolume.controller.lzc;

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
        List<EnterPrise> enterPriseList=enterpriseService.selectAll();
        return "lzc/admin-enterprise-list";
    }

}
