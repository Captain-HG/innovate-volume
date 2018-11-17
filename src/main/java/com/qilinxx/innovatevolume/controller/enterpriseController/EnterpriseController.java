package com.qilinxx.innovatevolume.controller.enterpriseController;

import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 创新卷企业页面
 * enterpriseController
 * 2018/11/15
 */
@Controller
public class EnterpriseController {
    private Enterprise enterprise;
    private UserInfo userInfo;
    /**
     * 来到创新卷科技企业的页面
     * @param userIfo  用户表传来的对象
     * @return 跳转企业主页面
     */
    @Autowired
    private EnterpriseService enterpriseService;
    @GetMapping("/")
    public String enterpriseHome(UserInfo userInfo,Model model){
        this.userInfo=userInfo;
        //测试数据
        userInfo.setOrgcode("111111111");
        this.enterprise= enterpriseService.selectEnterpriseByCode(userInfo.getOrgcode());
        model.addAttribute("enterprise",enterprise);
        return "fys/enterprise-home";
    }
    //后台的迎接页面
    /**
     * 来到创新卷科技企业的迎接面
     * @return 欢迎页面
     */
    @GetMapping("enterprise-welcome")
    public String enterpriseWelcome(){
        return "fys/enterprise-welcome";
    }

    /**
     * 企业个人资料
     * @return 个人资料页面
     */
    @GetMapping("enterprise-info.html")
    public String enterpriseInfo(Model model){
        model.addAttribute("dateKit",new DateKit());
        model.addAttribute("enterprise",enterprise);
        return "fys/enterprise-info";
    }
    /**
     * 修改个人资料
     * @return 修改个人资料页面
     */
    @GetMapping("enterprise-change-info.html")
    public String enterpriseChangeInfo(Model model){
        model.addAttribute("dateKit",new DateKit());
        model.addAttribute("enterprise",enterprise);
        return "fys/enterprise-change-info";
    }
}
