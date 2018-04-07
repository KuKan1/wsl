package com.wsl.wjw.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.wsl.wjw.dto.TypeDto;
import com.wsl.wjw.service.TypeService;  
   
@Controller
public class HelloController {  
	
	@Autowired
	TypeService typeService;
     
    @RequestMapping("/test")  
    public String hello(Map<String,Object> map) throws Exception{  
    	TypeDto typeDto = typeService.queryTypeDtoById(1L);
    	System.out.println(JSON.toJSONString(typeDto));
       map.put("name", "[-- 守护天使]");  
       return "test";  
    }  
     
} 