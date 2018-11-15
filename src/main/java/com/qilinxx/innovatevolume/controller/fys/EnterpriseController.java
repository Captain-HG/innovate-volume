package com.qilinxx.innovatevolume.controller.fys;

import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 创新卷企业页面
 * fys
 * 2018/11/15
 */
@Controller
public class EnterpriseController {
    private Enterprise enterprise;
    private UserInfo userInfo;
    //来到创新卷科技企业的页面
    @Autowired
    private EnterpriseService enterpriseService;
    @GetMapping("/")
    public String enterpriseHome(UserInfo userInfo,Model model){
        this.userInfo=userInfo;
        //测试数据
        userInfo.setOrgcode("111111111");
        this.enterprise= enterpriseService.selectEnterpriseByCode(userInfo.getOrgcode());
        model.addAttribute("enterprise",enterprise);
        return "fys/enterprise_home";
    }
    //后台的迎接页面
    @GetMapping("enterprise_welcome")
    public String enterpriseWelcome(){
        return "fys/enterprise_welcome";
    }
}
