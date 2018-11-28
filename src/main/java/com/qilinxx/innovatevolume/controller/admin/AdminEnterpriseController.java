package com.qilinxx.innovatevolume.controller.admin;

import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.*;
import com.qilinxx.innovatevolume.util.Commons;
import com.qilinxx.innovatevolume.vo.ContractVo;
import com.qilinxx.innovatevolume.vo.VoucherApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminEnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    VoucherService voucherService;
    @Autowired
    EnterpriseFileService enterpriseFileService;
    @Autowired
    EnterpriseStaffService enterpriseStaffService;
    @Autowired
    ContractService contractService;
    @Autowired
    VoucherApplyService voucherApplyService;
    /**
     *跳转到管理员的
     * 提供者页面的list
     */
    @RequestMapping("admin-enterprise-list")
    public String adminEnterpriseList(Model model){
      List<Enterprise> enterpriseList = enterpriseService.selectAll();
          model.addAttribute("enterpriseList",enterpriseList);
        model.addAttribute("commons",new Commons());
        return "admin/enterprise/list";
    }



    /**
     * 根据code公司编号查询，显示用户创建者的信息
     * @param id 公司编号code
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-enterprise-creater-show")
    public String enterpriseCreaterShow(String id,Model model){
        System.out.println(id);
       UserInfo userInfo = userInfoService.selectByCode(id);
       System.out.println(userInfo.toString());
        model.addAttribute("commons",new Commons());
       model.addAttribute("userInfo",userInfo);
        return "admin/enterprise/creater-show";
    }
    /**
     * 查看科技企业的基本信息
     * @param id 科技企业id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-enterprise-show")
    public String enterpriseShow(String  id,Model model){
        Enterprise enterprise = enterpriseService.selectById(id);
        model.addAttribute("enterprise",enterprise);
        model.addAttribute("commons",new Commons());
        return "admin/enterprise/show";
    }
    /**
     * 查看的联系人基本信息
     * @param id 科技企业id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-enterprise-contacter-show")
    public String enterpriseContacterShow(String id,Model model){
        Enterprise enterprise = enterpriseService.selectById(id);
        model.addAttribute("enterprise",enterprise);
        return "admin/enterprise/contacter-show";
    }

    /**
     * 重新审核此科技企业
     * @param id  科技企业id
     * @return 成功
     */
    @RequestMapping("admin-examine-enterprise")
    @ResponseBody
    public String examineEnterprise(String id, HttpServletRequest request) {
        enterpriseService.examineEnterprise(id);
        // System.out.println("传过来的语句："+str);
        //  logService.insertLog(str,userId(request),userIp(request));
        return "success";
    }
    /**
     * 审核此商家未通过
     * @param id  商家id
     * @return 成功
     */
    @RequestMapping("admin-noExamine-enterprise")
    @ResponseBody
    public String noExamineEnterprise(String id, HttpServletRequest request) {
         enterpriseService.noExamineEnterprise(id);
        // System.out.println("传过来的语句："+str);
        //  logService.insertLog(str,userId(request),userIp(request));
        return "success";
    }
    /**
     * 审核通过
     * @param id  商家id
     * @return 成功
     */
    @RequestMapping("admin-start-enterprise")
    @ResponseBody
    public String startProvide(String id, HttpServletRequest request) {
        System.out.println(id);
        String str = enterpriseService.startEnterprise(id);
        // System.out.println("传过来的语句："+str);
        //  logService.insertLog(str,userId(request),userIp(request));
        return "success";
    }


    /**
     * 验证商家码是否已经被注册
     * @param code
     * @return
     */
//    @RequestMapping("admin-ajaxRegister")
//    @ResponseBody
//    public String userAjaxRegister(String code,String id) {
//        Enterprise enterprise = enterpriseService.selectById(id);
//        if (code.equals(enterprise.getCode())) {
//            return "true";
//        } else {
//            return enterpriseService.ifCodeUse(code);
//        }
//    }
    /**
     * 修改科技企业页面跳转
     * 修改对象的id
     * @return 修改页面
     */
    @RequestMapping("admin-enterprise-update.html")
    public String enterpriseAddUI(String id,Model model){
        Enterprise enterprise = enterpriseService.selectById(id);
        model.addAttribute("enterprise",enterprise);
        model.addAttribute("commons",new Commons());
        return "admin/enterprise/update";
    }

    /**
     * 更新商家的实现
     * @return
     */
    @RequestMapping("admin-enterprise-update")
    @ResponseBody
    public String enterpriseAdd(Enterprise enterprise){
   System.out.println("更新对象："+enterprise.toString());
       enterpriseService.updateEnterprise(enterprise);
        return "success";
    }

    /**
     * 查看改商家的文件
     * @param id 商家id
     * @param model 传递
     * @return 页面跳转
     */
    @RequestMapping("admin-enterprise-file.html")
    public String enterpriseFile(String id,Model model){
        System.out.println(id);
        List<EnterpriseFile> enterpriseFileList = enterpriseFileService.selectAllByEnterpriseId(id);
        Enterprise enterprise = enterpriseService.selectById(id);
        model.addAttribute("enterpriseFileList",enterpriseFileList);
        model.addAttribute("enterprise",enterprise);
        model.addAttribute("commons",new Commons());
        return "admin/enterprise/file-list";
    }

    /**
     * 使某个文件失效
     * @param id 文件id
     * @return
     */
    @RequestMapping("admin-noExamine-enterpriseFile")
    @ResponseBody
    public String noExamineFile(Integer id){
        System.out.println(id);
        enterpriseFileService.noExamineFile(id);
        return "success";
    }
    /**
     * 启用某个文件
     * @param id 文件id
     * @return
     */
    @RequestMapping("admin-start-enterpriseFile")
    @ResponseBody
    public String StartFile(Integer id){
        System.out.println(id);
        enterpriseFileService.startFile(id);
        return "success";
    }
    /**
     * 查看改商家的领军人物
     * @param id 商家id
     * @param model 传递
     * @return 页面跳转
     */
    @RequestMapping("admin-enterprise-staff.html")
    public String enterpriseStaff(String id,Model model){
        System.out.println(id);
        List<EnterpriseStaff> enterpriseStaffList = enterpriseStaffService.selectAllByEnterpriseId(id);
        Enterprise enterprise = enterpriseService.selectById(id);
        model.addAttribute("enterpriseStaffList",enterpriseStaffList);
        model.addAttribute("enterprise",enterprise);
        model.addAttribute("commons",new Commons());
        return "admin/enterprise/staff-list";
    }
    /**
     * 使某个人员失效
     * @param id 人员id
     * @return
     */
    @RequestMapping("admin-noExamine-enterpriseStaff")
    @ResponseBody
    public String noExamineStaff(Integer id){
        System.out.println(id);
        enterpriseStaffService.noExamineStaff(id);
        return "success";
    }
    /**
     * 启用某个人员
     * @param id 文件id
     * @return
     */
    @RequestMapping("admin-start-enterpriseStaff")
    @ResponseBody
    public String StartStaff(Integer id){
        System.out.println(id);
        enterpriseStaffService.startStaff(id);
        return "success";
    }

    /**
     * 人员更新页面跳转
     * @param id 人员id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-enterprise-staff-update.html")
    public String  staffUpdateUI(Integer id,Model model){
        EnterpriseStaff enterpriseStaff = enterpriseStaffService.selectById(id);
        model.addAttribute("enterpriseStaff",enterpriseStaff);
        model.addAttribute("commons",new Commons());
        return "admin/enterprise/staff-update";
    }

    /**
     * 人员更新
     * @param enterpriseStaff
     * @return
     */
    @RequestMapping("admin-enterprise-staff-update")
    @ResponseBody
    public String  staffUpdate(EnterpriseStaff enterpriseStaff){
        System.out.println(enterpriseStaff);
        enterpriseStaffService.updateEnterpriseStaff(enterpriseStaff);
        return "success";
    }

    /**
     * 跳转到合同list界面
     * @param model 传递
     * @param id 科技企业id
     * @return 跳转合同list
     */
    @RequestMapping("admin-enterprise-contract.html")
    public String enterpriseContract(Model model,String id){
        System.out.println(id);
        //查找回一个封装好的合同list（包括双方名字）
        List<ContractVo> contractVoList = contractService.selectAllByEnterpriseId(id);
         model.addAttribute("contractVoList",contractVoList);
         model.addAttribute("commons",new Commons());
        return "admin/contract/list";
    }

    /**
     * 跳转到申请记录list界面
     * @param model 传递
     * @param id 科技企业id
     * @return 跳转记录list
     */
    @RequestMapping("admin-enterprise-voucherApply.html")
    public String enterpriseVoucherApply(Model model,String id){
        System.out.println(id);
        List<VoucherApplyVo> voucherApplyVoList = voucherApplyService.selectAllByEnterpriseId(id);
        model.addAttribute("voucherApplyVoList",voucherApplyVoList);
        model.addAttribute("commons",new Commons());
        return "admin/enterprise/voucherApply-list";
    }
    /**
     * 使某个申请失效
     * @param id 申请id
     * @return
     */
    @RequestMapping("admin-noExamine-enterpriseVoucherApply")
    @ResponseBody
    public String noExamineApply(String  id){
        System.out.println(id);
        voucherApplyService.noExamineApply(id);
        return "success";
    }
    /**
     * 启用某个申请
     * @param id 申请id
     * @return 返回成功
     */
    @RequestMapping("admin-start-enterpriseVoucherApply")
    @ResponseBody
    public String startApply(String id){
        System.out.println(id);
        voucherApplyService.startApply(id);
        return "success";
    }
    /**
     * 重审某个申请
     * @param id 申请id
     * @return 返回成功
     */
    @RequestMapping("admin-examine-enterpriseVoucherApply")
    @ResponseBody
    public String examineApply(String id){
        System.out.println(id);
        voucherApplyService.examineApply(id);
        return "success";
    }
    /**
     * 验证商家码是否已经被注册
     * @param code
     * @return
     */
    @RequestMapping("admin-enterprise-codeAjaxRegister")
    @ResponseBody
    public String userAjaxRegister(String code,String id) {
        System.out.println("id和编码："+code+id);
        Enterprise enterprise = enterpriseService.selectById(id);
        if (code.equals(enterprise.getCode())) {
            System.out.println("方雨生正确");
            return "true";
        }
        else{
            return enterpriseService.ifCodeUse(code);
        }
    }

    /**
     * 人员更新页面跳转
     * @param id 人员id
     * @param model 传递
     * @return 跳转
     */
    @RequestMapping("admin-enterprise-voucherApply-update.html")
    public String  voucherApplyUpdateUI( String id,Model model){
        VoucherApplyVo voucherApplyVo = voucherApplyService.selectVobyId(id);
        model.addAttribute("voucherApplyVo",voucherApplyVo);
        model.addAttribute("commons",new Commons());
        return "admin/enterprise/voucherApply-update";
    }

    /**
     * 申请更新
     * @param voucherApply 申请
     * @return
     */
    @RequestMapping("admin-enterprise-voucherApply-update")
    @ResponseBody
    public String  voucherApplyUpdate(VoucherApply voucherApply){
        System.out.println(voucherApply);
       voucherApplyService.update(voucherApply);
        return "success";
    }
}
