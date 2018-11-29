package com.qilinxx.innovatevolume.controller.admin;

import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.service.ContractService;
import com.qilinxx.innovatevolume.service.VoucherApplyService;
import com.qilinxx.innovatevolume.util.Commons;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.vo.ContractVo;
import com.qilinxx.innovatevolume.vo.VoucherApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    VoucherApplyService voucherApplyService;
    /**
     * 查询所有合同，生成ContractVoList
     * @return
     */
    @RequestMapping("admin-contract-list")
    public String contractList(Model model){
        List<ContractVo> contractVoList = contractService.selectAllVo();
        model.addAttribute("contractVoList",contractVoList);
        model.addAttribute("commons",new Commons());
        return "admin/contract/list";
    }
    /**
     * 使某个合同失效
     * @param id 合同id
     * @return
     */
    @RequestMapping("admin-noExamine-Contract")
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
    @RequestMapping("admin-start-Contract")
    @ResponseBody
    public String startContract(String id){
        System.out.println(id);
        contractService.startContract(id);
        return "success";
    }

    /**
     * 合同更新页面跳转
     * @param id id
     * @param model 传递
     * @return 页面
     */
    @RequestMapping("admin-contract-update.html")
   public String  updateContractUi(String id,Model model){
        ContractVo contractVo = contractService.selectVoById(id);
        model.addAttribute("contractVo",contractVo);
        model.addAttribute("commons",new Commons());
        return "admin/contract/update";
    }

    /***
     * 更新实现
     * @param contract 合同
     * @return 成功
     */
    @RequestMapping("admin-contract-update")
    @ResponseBody
    public String updateContract(Contract contract){
        System.out.println(contract);
        contractService.updateContract(contract);
        return "success";
    }

    /**
     * 所有未审核的申请记录
     * @param model
     * @return
     */
    @RequestMapping("admin-voucherApplyNo-list")
    public String voucherApplyNoList(Model model){
        List<VoucherApplyVo> voucherApplyVoList = voucherApplyService.selectAllVoByIsUseNo();
        model.addAttribute("voucherApplyVoList",voucherApplyVoList);
        model.addAttribute("commons",new Commons());
        return "admin/contract/voucherApply-list";
    }

    /**
     * 增加合同页面跳转
     * @param id 申请id
     * @param model 传递
     * @return 页面
     */
    @RequestMapping("admin-contract-add.html")
    public String contractAddUi(String id,Model model){
        VoucherApplyVo voucherApplyVo = voucherApplyService.selectVobyId(id);
        model.addAttribute("voucherApplyVo",voucherApplyVo);
        model.addAttribute("commons",new Commons());
        return "admin/contract/add";
    }

    /**
     * 增加功能实现
     * @param contract
     * @param startTime
     * @param signTime
     * @return
     */
    @RequestMapping("admin-contract-add")
    @ResponseBody
    public String contractAdd(Contract contract, String  startTime,String  signTime){
        System.out.println("合同对象："+contract.toString());
        System.out.println("时间："+signTime);
        contract.setSignDate(DateKit.getUnixTimeLong(DateKit.dateFormat(signTime,"yyyy-MM-dd HH:mm")));
        contract.setStartDate(DateKit.getUnixTimeLong(DateKit.dateFormat(startTime,"yyyy-MM-dd HH:mm")));
        contractService.insert(contract);
        return "success";
    }

}
