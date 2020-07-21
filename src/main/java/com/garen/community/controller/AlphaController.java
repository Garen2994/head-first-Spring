package com.garen.community.controller;

import com.garen.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
    
    @RequestMapping("/http")
    @ResponseBody
    public void http(HttpServletRequest request, HttpServletResponse response){
        //请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }
        System.out.println(request.getParameter("code"));
        
        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try{
            PrintWriter pw = response.getWriter();
            pw.write("<h>GAREN WEBSITE</h>");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
