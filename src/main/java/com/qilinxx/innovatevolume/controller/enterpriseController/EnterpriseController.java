package com.qilinxx.innovatevolume.controller.enterpriseController;

import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.domain.model.Voucher;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.service.UserInfoService;
import com.qilinxx.innovatevolume.service.VoucherService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创新券企业页面
 * enterpriseController
 * 2018/11/15
 */
@Controller
public class EnterpriseController {

    private Enterprise enterprise;
    private UserInfo userInfo;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private VoucherService voucherService;
    /**
     * 来到创新券科技企业的页面
     * @return 跳转企业主页面
     */
    @GetMapping({"/","enterprise-home"})
    public String enterpriseHome(Model model, HttpSession session){
        //以下是测试代码（回来删除）
        String code="654321";
        UserInfo userInfo = userInfoService.selectByCode(code);
        session.setAttribute("user",userInfo);
        //以上是测试代码

        UserInfo user = (UserInfo) session.getAttribute("user");
        this.userInfo=user;
        this.enterprise= enterpriseService.selectEnterpriseByCode(this.userInfo.getOrgcode());
        model.addAttribute("user",this.userInfo);
        model.addAttribute("enterprise",enterprise);
        return "enterprise/enterprise-home";
    }
    //后台的迎接页面
    /**
     * 来到创新券科技企业的迎接面
     * @return 欢迎页面
     */
    @GetMapping("enterprise-welcome")
    public String enterpriseWelcome(){
        return "enterprise/enterprise-welcome";
    }

    /**
     * 企业个人资料
     * @return 个人资料页面
     */
    @GetMapping("enterprise-info.html")
    public String enterpriseInfo(Model model){
        model.addAttribute("dateKit",new DateKit());
        model.addAttribute("enterprise",enterprise);
        return "enterprise/enterprise-info";
    }
    /**
     * 修改个人资料
     * @return 修改个人资料页面
     */
    @GetMapping("enterprise-change-info.html")
    public String enterpriseChangeInfo(Model model){
        model.addAttribute("dateKit",new DateKit());
        model.addAttribute("enterprise",enterprise);
        return "enterprise/enterprise-change-info";
    }
    /**
     * 一般post请求提交修改个人资料
     * @return 修改个人资料页面
     */
    //@PostMapping("enterprise-change-info")
    //public String enterpriseChangeInfo(Enterprise enterprise,String  formatRegDate,String  formatFoundDate){
    //    enterprise.setRegDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatRegDate)))));
    //    enterprise.setFoundDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatFoundDate)))));
    //    enterprise.setUpdateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
    //    System.out.println(enterprise);
    //    return "redirect:enterprise-info.html";
    //}
    /**
     * ajax提交修改个人资料
     *
     */
    @PostMapping("ajax-enterprise-change-info")
    @ResponseBody
    public Map<String, String> ajaxEnterpriseChangeInfo(Enterprise enterprise, String  formatRegDate, String  formatFoundDate){
        enterprise.setRegDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatRegDate)))));
        enterprise.setFoundDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatFoundDate)))));
        enterprise.setUpdateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
        enterprise.setId(this.enterprise.getId());
        this.enterprise=enterpriseService.updateEnterpriseInfo(enterprise);
        Map<String ,String > map=new HashMap<>();
        map.put("msg","修改成功");
        return map;
    }
    /**
     * 修改个人密码
     * @return 来到修改个人密码页面
     */
    @GetMapping("enterprise-change-password.html")
    public String enterpriseChangePassword(Model model){
        model.addAttribute("userName",this.userInfo.getName());
        return "enterprise/enterprise-change-password";
    }
    /**
     * ajax提交更改个人密码
     */
    @ResponseBody
    @PostMapping("ajax-enterprise-change-password")
    public Map<String,String> enterpriseChangePassword(UserInfo userInfo,HttpSession session){
        userInfo.setId(this.userInfo.getId());
        userInfo.setUpdateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
        this.userInfo= userInfoService.updateUserInfoPassword(userInfo);
        session.setAttribute("user",this.userInfo);
        Map<String ,String > map=new HashMap<>();
        map.put("msg","修改成功！");
        return map;
    }
    /**
     * 从企业角度查询可用创新券
     * @return 来到查询券页面
     */
    @GetMapping("enterprise-voucher.html")
    public String enterpriseVoucher(Model model){
        List<Voucher> vouchers = voucherService.selectAll();
        if(vouchers.size()!=0){

        }
        return "enterprise/enterprise-voucher";
    }

}
