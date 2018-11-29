package com.qilinxx.innovatevolume.controller.admin;

import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.service.UserInfoService;
import com.qilinxx.innovatevolume.util.Commons;
import com.qilinxx.innovatevolume.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminUserController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * userList页面
     * @param model 传递
     * @return 页面
     */
    @RequestMapping("admin-userInfo-list")
    public String adminUserList(Model model){
        List<UserInfoVo> userInfoVoList = userInfoService.selectVoAll();
        model.addAttribute("userInfoVoList",userInfoVoList);
        model.addAttribute("commons",new Commons());
        return "admin/user/list";
    }

    /**
     * 跳转更新页面
     * @param model 传递
     * @param id user的id
     * @return
     */
   @RequestMapping("admin-userInfo-update.html")
    public String userInfoUpdateUi(Model model,String id){
       UserInfo userInfo = userInfoService.selectById(id);
       model.addAttribute("userInfo",userInfo);
       model.addAttribute("commons",new Commons());
       return "admin/user/update";
   }
   @RequestMapping("admin-userInfo-update")
   @ResponseBody
    public  String  userInfoUpdate(UserInfo userInfo){
       System.out.println(userInfo);
       userInfoService.updateUserInfo(userInfo);
       return "success";
   }
    /**
     * 审核此用户失效
     * @param id  用户id
     * @return 成功
     */
    @RequestMapping("admin-noExamine-user")
    @ResponseBody
    public String noExamineUser(String id) {
        System.out.println("userId:"+id);
        userInfoService.noExamineUserInfo(id);
        return "success";
    }
    /**
     * 用户启用
     * @param id  用户id
     * @return 成功
     */
    @RequestMapping("admin-start-user")
    @ResponseBody
    public String startUser(String id) {
        System.out.println("userId:"+id);
        userInfoService.startUserInfo(id);
        return "success";
    }
    /**
     * 验证商家码是否已经被注册
     * @param code 商家码
     * @return
     */
    @RequestMapping("admin-user-codeAjaxRegister")
    @ResponseBody
    public String userAjaxRegister(String code,String id) {
        System.out.println("id和编码："+code+id);
        UserInfo userInfo = userInfoService.selectById(id);
        if (code.equals(userInfo.getOrgcode())) {
            return "true";
        } else {

            return userInfoService.ifCodeUse(code);
        }
    }
}

