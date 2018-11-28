package com.qilinxx.innovatevolume.controller.providerController;

import com.qilinxx.innovatevolume.configure.WebConst;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务商页面
 * providerController
 * 2018/11/23
 */
@Controller
public class providerController {
    private UserInfo userInfo;
    private Provider provider;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ProviderServiceService providerServiceService;
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private VoucherApplyService voucherApplyService;
    @Autowired
    private ProviderStaffService providerStaffService;
    /**
     * 来到创新券科技企业的页面
     * @return 跳转企业主页面
     */
    @GetMapping({"/2","provider-home"})
    public String providerHome(Model model, HttpSession session){
        //以下是测试代码（回来删除）
        String code="123456789012345678";
        UserInfo userInfo = userInfoService.selectByCode(code);
        session.setAttribute("user",userInfo);
        //以上是测试代码

        this.userInfo= (UserInfo) session.getAttribute("user");
        this.provider= providerService.selectProviderBycode(this.userInfo.getOrgcode());
        model.addAttribute("user",this.userInfo);
        model.addAttribute("provider",this.provider);
        return "provider/provider-home";
    }
    //后台的迎接页面
    /**
     * 来到提供商的欢迎接面
     * @return 欢迎页面
     */
    @GetMapping("provider-welcome")
    public String providerWelcome(){
        return "provider/provider-welcome";
    }
    /**
     * 来到服务商的信息页面
     * @return 展示服务商的信息列表
     */
    @GetMapping("provider-info.html")
    public String Info (Model model){
        model.addAttribute("provider",this.provider);
        model.addAttribute("dateKit",new DateKit());
        return "provider/provider-info";
    }
    /**
     * 修改个人资料
     * @return 来到修改个人资料页面
     */
    @GetMapping("provider-change-info.html")
    public String providerChangeInfo(Model model){
        model.addAttribute("provider",this.provider);
        model.addAttribute("dateKit",new DateKit());
        return "provider/provider-change-info";
    }
    @PostMapping("ajax-provider-change-info")
    @ResponseBody
    public Map<String,String> ajaxProviderChangeInfo(String formatEstablishDate,Provider provider){
        provider.setEstablishDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatEstablishDate)))));
        provider.setUpdateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
        provider.setUpdater(this.provider.getName());
        provider.setId(this.provider.getId());
        this.provider=providerService.updateProviderInfo(provider);
        Map<String,String> map=new HashMap<>();
        if(this.provider.getIsUse().equals("0")){
            map.put("msg","修改成功(待审核)！");
        }else {
            map.put("msg","修改成功！");
        }
        return map;
    }
    /**
     * 修改个人密码
     * @return 来到修改个人密码页面
     */
    @GetMapping ("provider-change-password.html")
    public String  providerChangePassword(Model model){
        model.addAttribute("userName",this.userInfo.getName());
        return "provider/provider-change-password";
    }
    /**
     * ajax修改个人密码
     */
    @PostMapping("ajax-provider-change-password")
    @ResponseBody
    public Map<String,String> ajaxProviderChangePassword(UserInfo userInfo,HttpSession session){
        userInfo.setId(this.userInfo.getId());
        userInfo.setUpdater(this.userInfo.getName());
        userInfo.setUpdateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
        this.userInfo= userInfoService.updateUserInfoPassword(userInfo);
        session.setAttribute("user",this.userInfo);
        Map<String ,String > map=new HashMap<>();
        map.put("msg","密码修改成功！");
        return map;
    }
    /**
     * 发布服务商服务内容
     * @return 来到发布页面
     */
    @GetMapping("provider-release-service.html")
    public String providerReleaseService(){
        return "provider/provider-release-service";
    }
    /**
     * ajax提交服务内容
     */
    @PostMapping("ajax-provider-release-service")
    @ResponseBody
    public Map<String,String> ajaxProviderReleaseService(com.qilinxx.innovatevolume.domain.model.ProviderService providerService){
        Map<String,String> map=new HashMap<>();
        List<com.qilinxx.innovatevolume.domain.model.ProviderService> providerServiceList = providerServiceService.selectAllByProviderId(this.provider.getId());
        if(providerServiceList.size()!=0){
            for (com.qilinxx.innovatevolume.domain.model.ProviderService p:providerServiceList) {
                if(p.getName().equals(providerService.getName())){
                    map.put("msg","此服务已发布!");
                    return map;
                }
            }
        }
        providerService.setId(UUID.UU32());
        providerService.setProviderId(this.provider.getId());
        providerService.setIsUse("0");
        providerService.setCreater(this.userInfo.getName());
        providerService.setCreateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
        providerServiceService.insertProviderService(providerService);
        map.put("msg","发布成功(待审核)！");
        return map;
    }
    /**
     * 发布服务商处理服务内容列表
     * @return 来到发布页面列表
     */
    @GetMapping("provider-service-list.html")
    public String providerServiceList(Model model){
        List<com.qilinxx.innovatevolume.domain.model.ProviderService> providerServiceList = providerServiceService.selectAllByProviderId(this.provider.getId());
        Collections.reverse(providerServiceList);
        model.addAttribute("providerServiceList",providerServiceList);
        model.addAttribute("provider",this.provider);
        model.addAttribute("dateKit",new DateKit());
        return "provider/provider-service-list";
    }
    /**
     * ajax删除服务内容
     * id为服务内容的id
     */
    @PostMapping("ajax-provider-delete-service")
    @ResponseBody
    public Map<String,String> ajaxProviderDeleteService(String id){
        Map<String,String> map=new HashMap<>();
        providerServiceService.deleteProviderService(id);
        map.put("msg","删除成功！");
        return map;
    }
    /**
     * 服务商对的创新券的申请的处理
     * @return 服务商创新券处理页面
     */
    @GetMapping("provider-voucher-apply-list.html")
    public String providerVoucherApplyList(Model model){
        List<VoucherApply> voucherApplyList = voucherApplyService.selectVoucherApplyByProviderId(this.provider.getId());
        if(voucherApplyList.size()!=0){
            Map<String, Enterprise> enterpriseMap = enterpriseService.voucherApplyListToEnterpriseMap(voucherApplyList);
            Map<String,String> providerServiceMap=providerServiceService.voucherApplyListToProviderServiceMap(voucherApplyList);
            model.addAttribute("enterpriseMap",enterpriseMap);
            model.addAttribute("providerServiceMap",providerServiceMap);
        }
        model.addAttribute("voucherApplyList",voucherApplyList);
        model.addAttribute("provider",this.provider);
        model.addAttribute("dateKit",new DateKit());
        return "provider/provider-voucher-apply-list";
    }
    /**
     * ajax服务商对创新券的申请同意的处理
     * id 为voucherApply的id
     */
    @PostMapping("ajax-provider-agree-apply")
    @ResponseBody
    public Map<String,String> ajaxProviderAgreeApply(String id){
        Map<String ,String> map =new HashMap<>();
        voucherApplyService.updateIsUseById(id,"1");
        map.put("msg","通过审核!");
        return map;
    }
    /**
     * 查看合同详情
     * @return 来到合同列表页面
     */
    @GetMapping("provider-contract.html")
    public String providerContract(Model model){
        List<Contract> contractList = contractService.selectContractByProviderId(this.provider.getId());
        if(contractList.size()!=0){
            Map<String,Enterprise> enterpriseMap=enterpriseService.contractListToEnterpriseMap(contractList);
            Map<String,VoucherApply> voucherApplyMap=voucherApplyService.contractListToVoucherApplyMap(contractList);
            model.addAttribute("enterpriseMap",enterpriseMap);
            model.addAttribute("voucherApplyMap",voucherApplyMap);
        }
        model.addAttribute("contractList",contractList);
        model.addAttribute("provider",this.provider);
        model.addAttribute("dateKit",new DateKit());
        return "provider/provider-contract";
    }
    /**
     * 填写创新券信息，发布新创新券
     * @return 来到发布创新券页面
     */
    @GetMapping("provider-release-voucher.html")
    public String providerReleaseVoucher(Model model){
        List<com.qilinxx.innovatevolume.domain.model.ProviderService> providerServiceList = providerServiceService.selectAllByProviderId(this.provider.getId());
        model.addAttribute("providerServiceList",providerServiceList);
        model.addAttribute("VOUCHER_CATEGORY", WebConst.VOUCHER_CATEGORY);
        model.addAttribute("provider",this.provider);
        return "provider/provider-release-voucher";
    }
    /**
     * ajax提供商发布创新券
     * voucher为新提交的创新券信息
     */
    @PostMapping("ajax-provider-release-voucher")
    @ResponseBody
    public Map<String,String> ajaxProviderReleaseVoucher(Voucher voucher){
        Map<String,String> map =new HashMap<>();
        List<Voucher> voucherList = voucherService.selectVoucherByProviderId(this.provider.getId());
        if(voucherList.size()!=0){
            for (Voucher v:voucherList) {
                if(v.getType().equals(voucher.getType())&&v.getName().equals(voucher.getName())){
                    map.put("msg","该创新券已被使用！");
                    return map;
                }
            }
        }
        voucher.setId(UUID.UU32());
        voucher.setIsUse("0");
        voucher.setCreater(this.userInfo.getName());
        voucher.setCreateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
        voucherService.insertVoucher(voucher);
        map.put("msg","提交成功(待审核)！");
        return map;
    }
    /**
     * 该提供商处理自己所发布的所有创新券
     * @return 提供商所发布的创新券列表
     */
    @GetMapping("provider-voucher-list.html")
    public String providerVoucherList(Model model){
        List<Voucher> voucherList = voucherService.selectVoucherByProviderId(this.provider.getId());
        model.addAttribute("voucherList",voucherList);
        model.addAttribute("dateKit",new DateKit());
        model.addAttribute("provider",this.provider);
        return "provider/provider-voucher-list";
    }
    /**
     * ajax提供商发布创新券
     * voucher为新提交的创新券信息
     */
    @PostMapping("ajax-enterprise-delete-voucher")
    @ResponseBody
    public Map<String,String> ajaxEnterpriseDeleteVoucher(String id){
        Map<String,String> map=new HashMap<>();
        voucherService.deleteVoucher(id);
        map.put("msg","删除成功！");
        return map;
    }
    /**
     * 该提供商查看企业基本信息
     * @return 企业基本信息表
     */
    @GetMapping("provider-enterprise-info.html")
    public String providerEnterpriseInfo(String id,Model model){
        model.addAttribute("enterprise",enterpriseService.selectEnterpriseById(id));
        model.addAttribute("dateKit",new DateKit());
        return "provider/provider-enterprise-info";
    }
    /**
     * 该提供商处理人员信息
     * @return 提供商的人员信息表
     */
    @GetMapping("provider-staff-list.html")
    public String providerStaffList(Model model){
        List<ProviderStaff> providerStaffList = providerStaffService.selectAllByProviderId(this.provider.getId());
        model.addAttribute("providerStaffList",providerStaffList);
        model.addAttribute("provider",this.provider);
        model.addAttribute("dateKit",new DateKit());
        return "provider/provider-staff-list";
    }
    @PostMapping("ajax-provider-delete-staff")
    @ResponseBody
    public Map<String,String> ajaxProviderDeleteStaff(String id){
        Map<String,String> map=new HashMap<>();
        providerStaffService.deleteProviderStaff(id);
        map.put("msg","删除成功！");
        return map;
    }
    /**
     * 该提供商添加人员
     * @return 提供商添加人员列表
     */
    @GetMapping("provider-add-staff.html")
    public String providerAddStaff(){
        return "provider/provider-add-staff";
    }
    /**
     * ajax提供商添加人员
     */
    @PostMapping("ajax-provider-add-staff")
    @ResponseBody
    public Map<String,String> ajaxProviderAddStaff(ProviderStaff providerStaff){
        Map<String,String> map=new HashMap<>();
        providerStaff.setProviderId(this.provider.getId());
        providerStaff.setIsUse("0");
        providerStaff.setCreater(this.userInfo.getName());
        providerStaff.setCreateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
        providerStaffService.insertProviderStaff(providerStaff);
        map.put("msg","添加成功(待审核)!");
        return map;
    }

}
