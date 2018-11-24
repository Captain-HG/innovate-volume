package com.qilinxx.innovatevolume.controller.providerController;

import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.service.*;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务商页面
 * providerController
 * 2018/11/15
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
    private VoucherService voucherService;
    @Autowired
    private ProviderServiceService providerServiceService;
    @Autowired
    private VoucherApplyService voucherApplyService;
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
     * 来到创新券科技企业的迎接面
     * @return 欢迎页面
     */
    @GetMapping("provider-welcome")
    public String providerWelcome(){
        return "provider/provider-welcome";
    }

    /**
     * 企业个人资料
     * @return 个人资料页面
     */
    //@GetMapping("provider-info.html")
    //public String providerInfo(Model model){
    //    model.addAttribute("dateKit",new DateKit());
    //    model.addAttribute("provider",provider);
    //    return "provider/provider-info";
    //}
    /**
     * 修改个人资料
     * @return 修改个人资料页面
     */
    //@GetMapping("provider-change-info.html")
    //public String providerChangeInfo(Model model){
    //    model.addAttribute("dateKit",new DateKit());
    //    model.addAttribute("provider",provider);
    //    return "provider/provider-change-info";
    //}
    /**
     * 一般post请求提交修改个人资料
     * @return 修改个人资料页面
     */
    //@PostMapping("provider-change-info")
    //public String providerChangeInfo(provider provider,String  formatRegDate,String  formatFoundDate){
    //    provider.setRegDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatRegDate)))));
    //    provider.setFoundDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatFoundDate)))));
    //    provider.setUpdateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
    //    System.out.println(provider);
    //    return "redirect:provider-info.html";
    //}
    /**
     * ajax提交修改个人资料
     *
     */
    //@PostMapping("ajax-provider-change-info")
    //@ResponseBody
    //public Map<String, String> ajaxproviderChangeInfo(provider provider, String  formatRegDate, String  formatFoundDate){
    //    provider.setRegDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatRegDate)))));
    //    provider.setFoundDate(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.dateFormat(formatFoundDate)))));
    //    provider.setUpdateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
    //    provider.setId(this.provider.getId());
    //    this.provider=providerService.updateproviderInfo(provider);
    //    Map<String ,String > map=new HashMap<>();
    //    map.put("msg","修改成功");
    //    return map;
    //}
    /**
     * 修改个人密码
     * @return 来到修改个人密码页面
     */
    @GetMapping("provider-change-password.html")
    public String providerChangePassword(Model model){
        model.addAttribute("userName",this.userInfo.getName());
        return "provider/provider-change-password";
    }
    /**
     * ajax提交更改个人密码
     */
    @ResponseBody
    @PostMapping("ajax-provider-change-password")
    public Map<String,String> providerChangePassword(UserInfo userInfo,HttpSession session){
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
    //@GetMapping("provider-voucher-list.html")
    //public String providerVoucher(Model model){
    //    List<Voucher> vouchers = voucherService.selectAll();
    //    if(vouchers.size()!=0){
    //        Map<String, Provider> providerMap = providerService.voucherListToProviderMap(vouchers);
    //        model.addAttribute("providerMap",providerMap);
    //    }
    //    model.addAttribute("vouchers",vouchers);
    //    model.addAttribute("dateKit",new DateKit());
    //    return "provider/provider-voucher-list";
    //}
    /**
     * 企业申请创新券
     * id 为创新券表的id
     * @return 来到创新券申请页面
     */
   // @GetMapping("provider-voucher-apply.html")
    //public String providerVoucherApply( String id,Model model){
    //    Voucher voucher = voucherService.selectVoucherById(id);
    //    Provider provider = providerService.selectById(voucher.getProviderId());
    //    model.addAttribute("provider",this.provider);
    //    model.addAttribute("voucher",voucher);
    //    model.addAttribute("provider",provider);
    //    model.addAttribute("providerServices",providerServiceService.selectAllByProviderId(provider.getId()));
    //    return "provider/provider-voucher-apply";
    //}
    /**
     * 企业填好了创新券申请信息
     * @return 来到创新券申请记录列表
     */
    //@PostMapping("provider-voucher-apply-list.html")
    //public String providerVoucherApplyList(VoucherApply voucherApply){
    //    System.out.println(voucherApply);
    //    return "provider/provider-voucher-apply-list";
    //}
    /**
     * 企业填好了创新券申请信息
     * ajax方式
     * @return
     */
    //@PostMapping("ajax-provider-voucher-apply-list.html")
    //@ResponseBody
    //public Map<String ,String > providerVoucherApplyList(VoucherApply voucherApply){
    //    Map<String ,String > map=new HashMap<>();
    //    voucherApply.setId(UUID.UU32());
    //    voucherApply.setproviderId(this.provider.getId());
    //    voucherApply.setIsUse("0");
    //    voucherApply.setCreater(this.userInfo.getName());
    //    voucherApply.setCreateTime(Long.parseLong(String.valueOf(DateKit.getUnixTimeByDate(DateKit.getNowTime()))));
    //    voucherApplyService.insertVoucherApply(voucherApply);
    //    map.put("msg","提交成功(待审核)");
    //    return map;
    //}
    /**
     * 企业查看申请记录
     * @return 来到企业申请记录页面
     */
    //@GetMapping("provider-voucher-apply-list.html")
    //public String providerVoucherApplyList(Model model){
    //    List<VoucherApply> voucherApplyList = voucherApplyService.selectVoucherApplyByproviderId(this.provider.getId());
    //    if(voucherApplyList.size()!=0){
    //        Map<String, Provider> providerMap = providerService.voucherApplyListToProviderMap(voucherApplyList);
    //        Map<String, String> providerServiceMap = providerServiceService.voucherApplyListToProviderServiceMap(voucherApplyList);
    //        model.addAttribute("providerMap",providerMap);
    //        model.addAttribute("providerServiceMap",providerServiceMap);
    //    }
    //    model.addAttribute("voucherApplyList",voucherApplyList);
    //    model.addAttribute("provider",this.provider);
    //    model.addAttribute("dateKit",new DateKit());
    //    return "provider/provider-voucher-apply-list";
    //}
    /**
     * 企业删除创新券申请记录
     * ajax方式
     * @return
     */
    //@PostMapping("ajax-provider-delete-apply")
    //@ResponseBody
    //public Map<String ,String > ajaxproviderDeleteApply(String id){
    //    voucherApplyService.deleteVoucherApply(id);
    //    Map<String,String> map=new HashMap<>();
    //    map.put("msg","删除成功!");
    //    return map;
    //}
}
