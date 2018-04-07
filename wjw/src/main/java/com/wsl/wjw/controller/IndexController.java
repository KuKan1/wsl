package com.wsl.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


	@RequestMapping(value = {"/login","/"})
    public String login(ModelAndView modelAndView) {
		
		return "/login";  
    }
	
	@RequestMapping(value = {"/index"})
    public String index(ModelAndView modelAndView) {
		
		return "/index";  
    }
	
	@RequestMapping(value = {"/main"})
    public String main(ModelAndView modelAndView) {
		
		return "/layout/main";  
    }
	
	@RequestMapping(value = {"/left"})
    public String left(ModelAndView modelAndView) {
		
		return "/layout/left";  
    }
	
	@RequestMapping(value = {"/top"})
    public String top(ModelAndView modelAndView) {
		
		return "/layout/top";  
    }
	
	@RequestMapping(value = {"/show"})
    public String show(ModelAndView modelAndView) {
		
		return "/layout/show";  
    }
	
	@RequestMapping(value = {"/slider"})
    public String slider(ModelAndView modelAndView) {
		
		return "/layout/slider";  
    }
    
}