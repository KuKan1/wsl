package com.wsl.wjw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


	@RequestMapping(value = {"/login"},method=RequestMethod.POST)
    public String login(HttpServletRequest request,String usr,String pwd,ModelAndView modelAndView) {
		
		return "/login";  
    }
    
}