package com.qilinxx.innovatevolume.controller;

import com.qilinxx.innovatevolume.util.identify.GifCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: dqsdc
 * @Date: 2018-11-20 14:21
 * @Description: 存放一些公共调用资源，如动态验证码等
 */
@Controller
public class CommonController {

    //动态验证码模块
    @GetMapping("/identify")
    @ResponseBody
    public String identify(HttpSession session, HttpServletResponse response) throws IOException {
        GifCaptcha gifCaptcha = new GifCaptcha(200, 40);
        String text = new String(gifCaptcha.getText());
        session.setAttribute("code", text);
        gifCaptcha.out(response.getOutputStream());
        return "ok";
    }
}
