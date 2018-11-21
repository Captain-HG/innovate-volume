package com.qilinxx.innovatevolume.controller.admin;

import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.*;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.util.Commons;
import com.qilinxx.innovatevolume.vo.ContractVo;
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
    UserInfoService userInfoService;
    @Autowired
    VoucherService voucherService;
    @Autowired
    ProviderFileService providerFileService;
    @Autowired
    ProviderStaffService providerStaffService;
    @Autowired
    ProviderServiceService providerServiceService;
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
        model.addAttribute("commons",new Commons());
        return "admin/provider/list";
    }



    /**
     * 根据code公司编号查询，显示用户创建者的信息
     * @param id 公司编号
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-creater-show")
    public String providerCreaterShow(String id,Model model){
        System.out.println(id);
       UserInfo userInfo = userInfoService.selectByCode(id);
       System.out.println(userInfo.toString());
        model.addAttribute("commons",new Commons());
       model.addAttribute("userInfo",userInfo);
        return "admin/provider/creater-show";
    }
    /**
     * 查看提供商的基本信息
     * @param id 提供商id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-show")
    public String providerShow(String  id,Model model){
        Provider provider = providerService.selectById(id);
        model.addAttribute("provider",provider);
        model.addAttribute("commons",new Commons());
        return "admin/provider/show";
    }
    /**
     * 查看提供商的联系人基本信息
     * @param id 提供商id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-contacter-show")
    public String providerContacterShow(String id,Model model){
        Provider provider = providerService.selectById(id);
        model.addAttribute("provider",provider);
        return "admin/provider/contacter-show";
    }
    /**
     * 查看提供商的基本信息
     * @param id 提供商id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-admin-show")
    public String providerAdminShow(String id,Model model){
        Provider provider = providerService.selectById(id);
        model.addAttribute("provider",provider);
        return "admin/provider/admin-show";
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
        System.out.println(id);
        String str = providerService.startProvider(id);
        // System.out.println("传过来的语句："+str);
        //  logService.insertLog(str,userId(request),userIp(request));
        return "success";
    }


    /**
     * 验证商家码是否已经被注册
     * @param code
     * @return
     */
    @RequestMapping("admin-ajaxRegister")
    @ResponseBody
    public String userAjaxRegister(String code,String id) {
        Provider provider = providerService.selectById(id);
        if (code.equals(provider.getCode())) {
            return "true";
        } else {
            return providerService.ifCodeUse(code);
        }
    }
    /**
     * 修改提供商页面跳转
     * 修改对象的id
     * @return 修改页面
     */
    @RequestMapping("admin-provider-update.html")
    public String providerAddUI(String id,Model model){
        Provider provider = providerService.selectById(id);
        model.addAttribute("provider",provider);
        return "admin/provider/update";
    }

    /**
     * 更新商家的实现
     * @return
     */
    @RequestMapping("admin-provider-update")
    @ResponseBody
    public String providerAdd(Provider provider){
   System.out.println(provider.toString());
       providerService.updateProvider(provider);
        return "success";
    }

    /**
     * 查看改商家的文件
     * @param id 商家id
     * @param model 传递
     * @return 页面跳转
     */
    @RequestMapping("admin-provider-file.html")
    public String providerFile(String id,Model model){
        System.out.println(id);
        List<ProviderFile> providerFileList = providerFileService.selectAllByProviderId(id);
        Provider provider = providerService.selectById(id);
        model.addAttribute("providerFileList",providerFileList);
        model.addAttribute("provider",provider);
        model.addAttribute("commons",new Commons());
        return "admin/provider/file-list";
    }

    /**
     * 使某个文件失效
     * @param id 文件id
     * @return
     */
    @RequestMapping("admin-noExamine-providerFile")
    @ResponseBody
    public String noExamineFile(Integer id){
        System.out.println(id);
        providerFileService.noExamineFile(id);
        return "success";
    }
    /**
     * 启用某个文件
     * @param id 文件id
     * @return
     */
    @RequestMapping("admin-start-providerFile")
    @ResponseBody
    public String StartFile(Integer id){
        System.out.println(id);
        providerFileService.startFile(id);
        return "success";
    }
    /**
     * 查看改商家的领军人物
     * @param id 商家id
     * @param model 传递
     * @return 页面跳转
     */
    @RequestMapping("admin-provider-staff.html")
    public String providerStaff(String id,Model model){
        System.out.println(id);
        List<ProviderStaff> providerStaffList = providerStaffService.selectAllByProviderId(id);
        Provider provider = providerService.selectById(id);
        model.addAttribute("providerStaffList",providerStaffList);
        model.addAttribute("provider",provider);
        model.addAttribute("commons",new Commons());
        return "admin/provider/staff-list";
    }
    /**
     * 使某个人员失效
     * @param id 人员id
     * @return
     */
    @RequestMapping("admin-noExamine-providerStaff")
    @ResponseBody
    public String noExamineStaff(Integer id){
        System.out.println(id);
        providerStaffService.noExamineStaff(id);
        return "success";
    }
    /**
     * 启用某个人员
     * @param id 文件id
     * @return
     */
    @RequestMapping("admin-start-providerStaff")
    @ResponseBody
    public String StartStaff(Integer id){
        System.out.println(id);
        providerStaffService.startStaff(id);
        return "success";
    }

    /**
     * 人员更新页面跳转
     * @param id 人员id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-staff-update.html")
    public String  staffUpdateUI(Integer id,Model model){
        ProviderStaff providerStaff = providerStaffService.selectById(id);
        model.addAttribute("providerStaff",providerStaff);
        model.addAttribute("commons",new Commons());
        return "admin/provider/staff-update";
    }

    /**
     * 人员更新
     * @param providerStaff
     * @return
     */
    @RequestMapping("admin-provider-staff-update")
    @ResponseBody
    public String  staffUpdate(ProviderStaff providerStaff){
        System.out.println(providerStaff);
        providerStaffService.updateProviderStaff(providerStaff);
        return "success";
    }
    /**
     * 查看商家的服务内容
     * @param id 商家id
     * @param model 传递
     * @return 页面跳转
     */
    @RequestMapping("admin-provider-service.html")
    public String providerService(String id,Model model){
        System.out.println(id);
        List<com.qilinxx.innovatevolume.domain.model.ProviderService> providerServiceList = providerServiceService.selectAllByProviderId(id);
        Provider provider = providerService.selectById(id);
        model.addAttribute("providerServiceList",providerServiceList);
        model.addAttribute("provider",provider);
        model.addAttribute("commons",new Commons());
        return "admin/provider/service-list";
    }
    /**
     * 使某个服务失效
     * @param id 人员id
     * @return
     */
    @RequestMapping("admin-noExamine-providerService")
    @ResponseBody
    public String noExamineService(String  id){
        System.out.println(id);
        providerServiceService.noExamineService(id);
        return "success";
    }
    /**
     * 启用某个服务
     * @param id 文件id
     * @return
     */
    @RequestMapping("admin-start-providerService")
    @ResponseBody
    public String StartService(String id){
        System.out.println(id);
        providerServiceService.startService(id);
        return "success";
    }

    /**
     * 服务更新页面跳转
     * @param id 人员id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-service-update.html")
    public String  serviceUpdateUI(String  id,Model model){
        com.qilinxx.innovatevolume.domain.model.ProviderService providerService = providerServiceService.selectById(id);
        model.addAttribute("providerService",providerService);
        model.addAttribute("commons",new Commons());
        return "admin/provider/service-update";
    }

    /**
     * 服务更新
     * @param  providerService 服务
     * @return 成功
     */
    @RequestMapping("admin-provider-service-update")
    @ResponseBody
    public String  serviceUpdate(com.qilinxx.innovatevolume.domain.model.ProviderService providerService){
        System.out.println(providerService);
        providerServiceService.updateProviderService(providerService);
        return "success";
    }
    /**
     * 查看商家的券内容
     * @param id 商家id
     * @param model 传递
     * @return 页面跳转
     */
    @RequestMapping("admin-provider-voucher.html")
    public String providereVoucher(String id,Model model){
        System.out.println(id);
        List<Voucher> voucherList = voucherService.selectAllByProviderId(id);
        Provider provider = providerService.selectById(id);
        model.addAttribute("voucherList",voucherList);
        model.addAttribute("provider",provider);
        model.addAttribute("commons",new Commons());
        return "admin/provider/voucher-list";
    }
    /**
     * 使某个券失效
     * @param id 券id
     * @return
     */
    @RequestMapping("admin-noExamine-providerVoucher")
    @ResponseBody
    public String noExamineVoucher(String  id){
        System.out.println(id);
        voucherService.noExamineVoucher(id);
        return "success";
    }
    /**
     * 启用某个券
     * @param id 券id
     * @return 返回成功
     */
    @RequestMapping("admin-start-providerVoucher")
    @ResponseBody
    public String startVoucher(String id){
        System.out.println(id);
        voucherService.startVoucher(id);
        return "success";
    }

    /**
     * 券更新页面跳转
     * @param id 券id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-provider-voucher-update.html")
    public String  voucherUpdateUI(String  id,Model model){
        Voucher voucher = voucherService.selectById(id);
        model.addAttribute("voucher",voucher);
        model.addAttribute("commons",new Commons());
        return "admin/provider/voucher-update";
    }

    /**
     * 券更新
     * @param  voucher 券
     * @return 成功
     */
    @RequestMapping("admin-provider-voucher-update")
    @ResponseBody
    public String  voucherUpdate(Voucher voucher){
        System.out.println(voucher);
        voucherService.updateVoucher(voucher);
        return "success";
    }

    /**
     * 跳转到合同list界面
     * @param model 传递
     * @param id 提供商id
     * @return 跳转合同list
     */
    @RequestMapping("admin-provider-contract.html")
    public String providerContract(Model model,String id){
        System.out.println(id);
        List<ContractVo> contractVoList = contractService.selectAllByProviderId(id);
         model.addAttribute("contractVoList",contractVoList);
         model.addAttribute("commons",new Commons());
        return "admin/provider/contract-list";
    }
    /**
     * 使某个合同失效
     * @param id 合同id
     * @return
     */
    @RequestMapping("admin-noExamine-providerContract")
    @ResponseBody
    public String noExamineContract(String  id){
        System.out.println(id);
        contractService.noExamineContract(id);
        return "success";
    }
    /**
     * 启用某个合同
     * @param id 合同id
     * @return 返回成功
     */
    @RequestMapping("admin-start-providerContract")
    @ResponseBody
    public String startContract(String id){
        System.out.println(id);
        contractService.startContract(id);
        return "success";
    }
}
