package com.qilinxx.innovatevolume.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminContractController {
    @RequestMapping("admin-contract-list")
    public String contractList(){
        return "admin/";
    }
}
