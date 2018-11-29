package com.qilinxx.innovatevolume.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminIndex {
    @RequestMapping("admin-index")
    public String index(){
        return "admin/index";
    }

    @RequestMapping("admin-index-show")
    public String  indexShow(){
        return "admin/show";
    }
}
