package com.garen.community.controller;

import com.garen.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Garen!";
    }
    
    /**
     * @description 处理查询请求
     * @param
     * @return java.lang.String
     */
    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }
}
