package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/alpha")//浏览器访问这个类的名字
public class AlphaController1 {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")//浏览器访问这个方法的名字
    @ResponseBody//说明返回的不是网页，只是一个普通的字符串
    public String sayHello() {
        return "Hello SpringBoot.";
    }

    @RequestMapping("/check")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    //    @RequestMapping("/http")//这个方法使用浏览器访问时的访问路径（访问名）
//    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //获取请求数据
//        System.out.println(request.getMethod());
//        System.out.println(request.getServletPath());
//        Enumeration<String> enumeration = request.getHeaderNames();//获取请求行
//        while(enumeration.hasMoreElements()){
//            String name = enumeration.nextElement();
//            String value = request.getHeader(name);
//            System.out.println(name + ";" + value);
//        }
//        System.out.println(request.getParameter("code"));
//
//        //返回响应数据
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = response.getWriter();//获取输出流
//        writer.write("<h1>牛客网</h1>");
//        writer.close();
//
//    }
//
//    @RequestMapping("http1")
//    public void http1(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        //获取请求数据
//        System.out.println(request.getMethod());//请求的方式
//        System.out.println(request.getServletPath());//请求路径
//        Enumeration<String> enumeration = request.getHeaderNames();//请求报文头部
//        while(enumeration.hasMoreElements()){
//            String name = enumeration.nextElement();
//            String value = request.getHeader(name);
//            System.out.println(name + ";"  + value);
//        }
//        System.out.println(request.getParameter("code"));//获取业务数据code
//        System.out.println(request.getParameter("name"));//获取业务数据name
//
//
//        //返回响应数据
//        response.setContentType("text/html;charset=utf-8");//设置返回类型
//        PrintWriter writer = response.getWriter();//获得输出流
//        writer.write("<h1>牛客网</h1>");
//        writer.write("<h2>牛客社区</h2>");
//        writer.close();//关闭输出流
//
//    }
//    @RequestMapping("httptest")
//    public void httptest(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        //获取浏览器请求信息
//
//        System.out.println(request.getMethod());//获取浏览器请求方式
//        System.out.println(request.getServletPath());//获取浏览器请求路径
//        Enumeration<String> enumeration = request.getHeaderNames();//获取请求头部信息
//        while(enumeration.hasMoreElements()){
//            String name = enumeration.nextElement();
//            String value = request.getHeader(name);
//            System.out.println(name + ";" + value);
//        }
//        System.out.println(request.getParameter("username"));//获取业务数据
//        System.out.println(request.getParameter("password"));
//
//
//        //获取浏览器响应信息
////        response.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = response.getWriter();//获取输出流
//        writer.write("<h1>获取成功</h1>");
//        writer.close();
//    }
    //获取GET请求的信息
//    @RequestMapping(path = "/student", method = RequestMethod.GET)
//    @ResponseBody
//    public String getStudents(
//            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
//            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit)
//    {
//        System.out.println(current);
//        System.out.println(limit);
//        return "some students";
//    }
//    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String getStudent(@PathVariable("id") int id) {
//        System.out.println(id);
//        return " student";
//    }
    //POST请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(String name,int age)
    {
        System.out.println(name);
        System.out.println(age);
        return "add success";
    }

    //HTML响应
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");
        return mav;

    }

    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp()
    {
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",35);
        emp.put("salary",8000.00);
        return emp;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps()
    {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",35);
        emp.put("salary",8000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","李四");
        emp.put("age",25);
        emp.put("salary",9000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","王五");
        emp.put("age",45);
        emp.put("salary",10000.00);
        list.add(emp);
        return list;
    }

}