package com.wsl.wjw.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;  
   
@Controller
public class HelloController {  
     
    @RequestMapping("/test")  
    public String hello(Map<String,Object> map){  
       map.put("name", "[-- 守护天使]");  
       return "test";  
    }  
     
} 