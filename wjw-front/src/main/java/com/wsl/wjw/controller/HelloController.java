package com.wsl.wjw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.wsl.wjw.dto.CategoryDto;
import com.wsl.wjw.dto.TypeDto;
import com.wsl.wjw.service.CategoryService;
import com.wsl.wjw.service.TypeService;  
   
@Controller
public class HelloController {  
	
	@Autowired
	TypeService typeService;
	@Autowired
	CategoryService categoryService;
	
     
    @RequestMapping("/test")  
    public String hello(Map<String,Object> map) throws Exception{  
    	TypeDto typeDto = typeService.queryTypeDtoById(1L);
    	System.out.println(JSON.toJSONString(typeDto));
    	
    	List<CategoryDto> categoryList = categoryService.queryCategoryListByTypeId(1L);
    	System.out.println("CategoryList :"+JSON.toJSONString(categoryList));
    	
       map.put("name", "[-- 守护天使]");  
       return "test";  
    }  
     
} 