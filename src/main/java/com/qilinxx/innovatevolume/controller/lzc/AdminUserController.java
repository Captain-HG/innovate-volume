package com.qilinxx.innovatevolume.controller.lzc;

import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminUserController {

    @Autowired
    UserInfoService userInfoService;
    /**
     * 跳转到user添加页面
     * @return
     */
    @RequestMapping("admin-user-add.html")
    public String  adminUserAddUI(){
        return "lzc/admin-user-add";
    }

    /**
     * 实现用户添加
     * @return
     */
    @RequestMapping("admin-user-add")
    @ResponseBody
    public String  adminUserAdd(UserInfo userInfo){
        System.out.println(userInfo.toString());
        userInfoService.addUser(userInfo);
        return "success";
    }
    /**
     * 查看账号是否已被注册
     * 查看商家码是否已使用
     * @param account
     * @return
     */
    @RequestMapping("admin-user-ajaxRegister")
    @ResponseBody
    public String userAjaxRegister(String account,String orgCode) {
      return userInfoService.ifUserAccountAndOrgCode(account,orgCode);
    }

}
