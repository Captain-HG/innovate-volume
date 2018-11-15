package com.qilinxx.innovatevolume.controller.front;

import com.qilinxx.innovatevolume.domain.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/index")
    public String index() {
        return "front/index";
    }


    @RequestMapping("test")
    @ResponseBody
    public List test(){
        return providerMapper.selectAll();
    }
}
