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
     * 服务商对的创新券的申请的处理
     * @return 服务商创新券处理页面
     */
    @GetMapping("provider-voucher-apply-list.html")
    public String providerVoucherApplyList(Model model){
        List<VoucherApply> voucherApplyList = voucherApplyService.selectVoucherApplyByProviderId(this.provider.getId());
        if(voucherApplyList.size()!=0){
            Map<String, Enterprise> enterpriseMap ;//= enterpriseService.voucherApplyListToEnterpriseMap(voucherApplyList);
            Map<String,String> providerServiceMap=providerServiceService.voucherApplyListToProviderServiceMap(voucherApplyList);
          //  model.addAttribute("enterpriseMap",enterpriseMap);
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
        model.addAttribute("VOUCHER_CATEGORY", WebConst.VOUCHER_CATEGORY);
        model.addAttribute("provider",this.provider);
        return "provider/provider-release-voucher";
    }
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

}
