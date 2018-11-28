package com.qilinxx.innovatevolume.controller.front;

import com.google.gson.Gson;
import com.qilinxx.innovatevolume.domain.mapper.ProviderMapper;
import com.qilinxx.innovatevolume.domain.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: dqsdc
 * @Date: 2018-11-15 11:12
 * @Description:
 */
@Controller
public class FrontIndexController {

    @Autowired
    ProviderMapper providerMapper;

    @RequestMapping("/login")
    public String login() {
        return "front/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "front/register";
    }

    @RequestMapping(value = {"/index",""})
    public String index() {
        return "front/index";
    }

    @RequestMapping("/policy")
    public String policy() {
        return "front/policy";
    }

    @RequestMapping("/news")
    public String news() {
        return "front/news";
    }
    @RequestMapping("/organization")
    public String organization() {
        return "front/organization";
    }


    @RequestMapping("/science")
    public String science(HttpServletRequest request) {
        List<Provider> providerList=providerMapper.selectAll();
        request.setAttribute("providers",providerList);
        return "front/science";
    }
    @RequestMapping("/answer")
    public String answer() {
        return "front/answer";
    }
    @RequestMapping("/help")
    public String help() {
        return "front/help";
    }

    @RequestMapping("/json")
    @ResponseBody
    public String json(){
        String str="&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\"&gt;&lt;strong style=\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\"&gt;&lt;span style=\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\"&gt;河北省科学技术厅&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\"&gt;&lt;strong style=\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\"&gt;&lt;span style=\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\"&gt;关于公布河北省科技创新券创新服务&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\"&gt;&lt;strong style=\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\"&gt;&lt;span style=\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\"&gt;提供机构（第二批）的通知&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\"&gt;&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\"&gt;各有关单位：&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\"&gt;　　根据《河北省科技创新券实施细则（试行）》（冀科计〔2016〕22号）和《关于征集省科技创新券创新服务提供机构（第二批）的通知》（冀科计函〔2017〕34号）有关规定，省科技厅组织专家对申报科技创新券创新服务提供机构进行评审，现将审核通过的科技创新券创新服务提供机构（第二批）名单予以公布（见附件）。请相关单位及时在河北省科技创新券工作平台（http://cxq.kjfw.org.cn）进行注册备案。&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\"&gt;　　联系人：郑银银&amp;nbsp; 电话：0311-85891860&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\"&gt;　　附件：&lt;a href=\"http://www.hebstd.gov.cn/web/banshi/sttzgg/55841/2017042616345033785.doc\" style=\"color: rgb(0, 0, 0); padding: 0px; margin: 0px;\"&gt;河北省第二批科技创新券创新服务提供机构名单.doc&lt;/a&gt;&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\"&gt;　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　河北省科学技术厅&lt;/p&gt;&lt;p style=\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\"&gt;　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　2017年04月26日&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;";
//      String str="{\n" +
//                "\"Title\": \"关于公布河北省科技创新券创新服务提供机构（第二批）的通知\",\n" +
//                "\"Detail\": \"&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;&lt;strong style=\\\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\\\"&gt;&lt;span style=\\\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\\\"&gt;淮北市科学技术局&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;&lt;strong style=\\\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\\\"&gt;&lt;span style=\\\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\\\"&gt;关于公布河北省科技创新券创新服务&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;&lt;strong style=\\\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\\\"&gt;&lt;span style=\\\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\\\"&gt;提供机构（第二批）的通知&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\\\"&gt;各有关单位：&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\\\"&gt;　　根据《河北省科技创新券实施细则（试行）》（冀科计〔2016〕22号）和《关于征集省科技创新券创新服务提供机构（第二批）的通知》（冀科计函〔2017〕34号）有关规定，省科技厅组织专家对申报科技创新券创新服务提供机构进行评审，现将审核通过的科技创新券创新服务提供机构（第二批）名单予以公布（见附件）。请相关单位及时在河北省科技创新券工作平台（http://cxq.kjfw.org.cn）进行注册备案。&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\\\"&gt;　　联系人：郑银银&amp;nbsp; 电话：0311-85891860&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\\\"&gt;　　附件：&lt;a href=\\\"http://www.hebstd.gov.cn/web/banshi/sttzgg/55841/2017042616345033785.doc\\\" style=\\\"color: rgb(0, 0, 0); padding: 0px; margin: 0px;\\\"&gt;河北省第二批科技创新券创新服务提供机构名单.doc&lt;/a&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　淮北市科学技术局&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　2017年04月26日&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;\",\n" +
//                "\"Person\": \"省科技厅\",\n" +
//                "\"PTime\": \"2017-04-27 15:52:34\",\n" +
//                "\"File\": \"\",\n" +
//                "\"ReadCount\": 427,\n" +
//                "\"ReadType\": \"4\",\n" +
//                "\"TableID\": 66,\n" +
//                "\"PrimaryKeys\": [\"TableID\"],\n" +
//                "\"PropertyNames\": [\"Title\", \"Detail\", \"Person\", \"PTime\", \"File\", \"ReadCount\", \"ReadType\", \"TableID\"],\n" +
//                "\"PropertyValues\": [\"关于公布河北省科技创新券创新服务提供机构（第二批）的通知\", \"&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;&lt;strong style=\\\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\\\"&gt;&lt;span style=\\\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\\\"&gt;淮北市科学技术局&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;&lt;strong style=\\\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\\\"&gt;&lt;span style=\\\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\\\"&gt;关于公布河北省科技创新券创新服务&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;&lt;strong style=\\\"font-size: 14px; font-family: 雅黑, 宋体, arial, verdana, sans-serif; padding: 0px; margin: 0px; line-height: 28px;\\\"&gt;&lt;span style=\\\"margin: 0px; padding: 0px; font-family: 宋体, arial, verdana, sans-serif; font-size: 22px; line-height: 44px;\\\"&gt;提供机构（第二批）的通知&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\\\"&gt;各有关单位：&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\\\"&gt;　　根据《河北省科技创新券实施细则（试行）》（冀科计〔2016〕22号）和《关于征集省科技创新券创新服务提供机构（第二批）的通知》（冀科计函〔2017〕34号）有关规定，省科技厅组织专家对申报科技创新券创新服务提供机构进行评审，现将审核通过的科技创新券创新服务提供机构（第二批）名单予以公布（见附件）。请相关单位及时在河北省科技创新券工作平台（http://cxq.kjfw.org.cn）进行注册备案。&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\\\"&gt;　　联系人：郑银银&amp;nbsp; 电话：0311-85891860&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; text-align: justify; white-space: normal;\\\"&gt;　　附件：&lt;a href=\\\"http://www.hebstd.gov.cn/web/banshi/sttzgg/55841/2017042616345033785.doc\\\" style=\\\"color: rgb(0, 0, 0); padding: 0px; margin: 0px;\\\"&gt;河北省第二批科技创新券创新服务提供机构名单.doc&lt;/a&gt;&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　淮北市科学技术局&lt;/p&gt;&lt;p style=\\\"margin-top: 0.5em; margin-bottom: 0.5em; padding: 0px; font-family: 宋体; color: rgb(0, 51, 102); font-size: 15px; line-height: 2; white-space: normal; text-align: center;\\\"&gt;　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　2017年04月26日&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;\", \"省科技厅\", \"2017-04-27 15:52:34\", \"\", 427, \"4\", 66]\n" +
//                "}";
      return str;
    }
}
