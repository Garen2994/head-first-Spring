package com.garen.community.controller;

import com.garen.community.service.AlphaService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
    //************Get请求*************
    /**
     * @description 加参数方式 1. /students?current=1&limit=20
     * @param current
     * @param limit
     * @return
     */
    @RequestMapping(path = "/students", method = RequestMethod.GET) //必须是处理GET请求
    @ResponseBody
    public String getStudents( //参数名保持一致
        @RequestParam(name = "current", required = false, defaultValue = "i") int current,
        @RequestParam(name = "limit", required = false, defaultValue = "i") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some Student";
    }
    /**
     * @description 2. /student/123 当参数在路径中时
     * @param id
     * @return java.lang.String
     */
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){ // 用注解定义路径参数
        System.out.println(id);
        return "a student";
    }
    
    //**********POST请求************
    
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        return "Succeed";
    }
    
    //响应HTML数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    /**
     * @description //TODO
     * @param
     * @return org.springframework.web.servlet.ModelAndView  //
     */
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "Garen");
        mav.addObject("age",18);
        mav.setViewName("/demo/view"); // template
        return mav;
    }
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name" , "Garen");
        model.addAttribute("age",19);
        return "/demo/view";
    }
    
    //响应JSON数据(异步请求)
    //Java对象->JSON字符串->JS对象
    
    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","Garen");
        emp.put("Age", 19);
        emp.put("Salary", 18000.00);
        list.add(emp);
        
        Map<String, Object> emp1 = new HashMap<>();
        emp1.put("name","Betty");
        emp1.put("Age", 20);
        emp1.put("Salary", 1800.00);
        list.add(emp1);
        
        Map<String, Object> emp2 = new HashMap<>();
        emp2.put("name","Lucy");
        emp2.put("Age", 18);
        emp2.put("Salary", 8000.00);
        list.add(emp2);
        
        return list;
    }
}
