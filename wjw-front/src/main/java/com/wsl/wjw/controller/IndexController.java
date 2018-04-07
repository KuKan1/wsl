package com.wsl.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = {"/index","/"})
    public String index(ModelAndView modelAndView) throws Exception {
		return "/index";  
    }
    
}