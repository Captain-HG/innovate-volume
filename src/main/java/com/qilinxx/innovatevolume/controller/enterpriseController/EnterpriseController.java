package com.qilinxx.innovatevolume.controller.enterpriseController;

import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.*;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.util.UUID;
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
    @Autowired
    private ProviderService providerService;
    @Autowired
    private ProviderServiceService providerServiceService;
    @Autowired
    private VoucherApplyService voucherApplyService;
    @Autowired
    private ContractService contractService;
    /**
     * 来到创新券科技企业的页面
     * @return 跳转企业主页面
     */
    @GetMapping({"/1","enterprise-home"})
    public String enterpriseHome(Model model, HttpSession session){
        //以下是测试代码（回来删除）
        String code="654321";
        UserInfo userInfo = userInfoService.selectByCode(code);
        session.setAttribute("user",userInfo);
        //以上是测试代码

        this.userInfo= (UserInfo) session.getAttribute("user");
        this.enterprise= enterpriseService.selectEnterpriseByCode(this.userInfo.getOrgcode());
        model.addAttribute("user",this.userInfo);
        model.addAttribute("enterprise",this.enterprise);
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
     * providerMap中存储着发放过创新卷的提供商的所有信息
     * @return 来到查询券页面
     */
    @GetMapping("enterprise-voucher-list.html")
    public String enterpriseVoucher(Model model){
        List<Voucher> vouchers = voucherService.selectAll();
        if(vouchers.size()!=0){
            Map<String, Provider> providerMap = providerService.voucherListToProviderMap(vouchers);
            model.addAttribute("providerMap",providerMap);
        }
        model.addAttribute("vouchers",vouchers);
        model.addAttribute("dateKit",new DateKit());
        return "enterprise/enterprise-voucher-list";
    }
    /**
     * 企业申请创新券
     * id 为创新券表的id
     * @return 来到创新券申请页面
     */
    @GetMapping("enterprise-voucher-apply.html")
    public String enterpriseVoucherApply( String id,Model model){
        Voucher voucher = voucherService.selectVoucherById(id);
        Provider provider = providerService.selectById(voucher.getProviderId());
        model.addAttribute("enterprise",this.enterprise);
        model.addAttribute("voucher",voucher);
        model.addAttribute("provider",provider);
        model.addAttribute("providerServices",providerServiceService.selectAllByProviderId(provider.getId()));
        return "enterprise/enterprise-voucher-apply";
    }
    /**
     * 企业填好了创新券申请信息
     * @return 来到创新券申请记录列表
     */
    //@PostMapping("enterprise-voucher-apply-list.html")
    //public String enterpriseVoucherApplyList(VoucherApply voucherApply){
    //    System.out.println(voucherApply);
    //    return "enterprise/enterprise-voucher-apply-list";
    //}
    /**
     * 企业填好了创新券申请信息
     * ajax方式
     * @return
     */
    @PostMapping("ajax-enterprise-voucher-apply-list.html")
    @ResponseBody
    public Map<String ,String > enterpriseVoucherApplyList(VoucherApply voucherApply){
        Map<String ,String > map=new HashMap<>();
        voucherApply.setId(UUID.UU32());
        voucherApply.setEnterpriseId(this.enterprise.getId());
        voucherApply.setIsUse("0");
        voucherApply.setCreater(this.userInfo.getName());
        voucherApply.setCreateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
        voucherApplyService.insertVoucherApply(voucherApply);
        map.put("msg","提交成功(待审核)");
        return map;
    }
    /**
     * 企业查看申请记录
     * @return 来到企业申请记录页面
     */
    @GetMapping("enterprise-voucher-apply-list.html")
    public String enterpriseVoucherApplyList(Model model){
        List<VoucherApply> voucherApplyList = voucherApplyService.selectVoucherApplyByEnterpriseId(this.enterprise.getId());
        if(voucherApplyList.size()!=0){
            Map<String, Provider> providerMap = providerService.voucherApplyListToProviderMap(voucherApplyList);
            Map<String, String> providerServiceMap = providerServiceService.voucherApplyListToProviderServiceMap(voucherApplyList);
            model.addAttribute("providerMap",providerMap);
            model.addAttribute("providerServiceMap",providerServiceMap);
        }
        model.addAttribute("voucherApplyList",voucherApplyList);
        model.addAttribute("enterprise",this.enterprise);
        model.addAttribute("dateKit",new DateKit());
        return "enterprise/enterprise-voucher-apply-list";
    }
    /**
     * 企业删除创新券申请记录
     * ajax方式
     * @return
     */
    @PostMapping("ajax-enterprise-delete-apply")
    @ResponseBody
    public Map<String ,String > ajaxEnterpriseDeleteApply(String id){
        voucherApplyService.deleteVoucherApply(id);
        Map<String,String> map=new HashMap<>();
        map.put("msg","删除成功!");
        return map;
    }
    @GetMapping("enterprise-contract.html")
    public String enterpriseContract(Model model){
        List<Contract> contractList = contractService.selectContractByEnterpriseId(this.enterprise.getId());
        if(contractList.size()!=0){
            Map<String,Provider> providerMap=providerService.contractListToProviderMap(contractList);
            Map<String,VoucherApply> voucherApplyMap=voucherApplyService.contractListToVoucherApplyMap(contractList);
            model.addAttribute("providerMap",providerMap);
            model.addAttribute("voucherApplyMap",voucherApplyMap);
        }
        model.addAttribute("contractList",contractList);
        model.addAttribute("enterprise",this.enterprise);
        model.addAttribute("dateKit",new DateKit());
        return "enterprise/enterprise-contract";
    }
}
