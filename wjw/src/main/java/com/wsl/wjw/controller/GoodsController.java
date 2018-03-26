package com.wsl.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="goods")
public class GoodsController {

	@RequestMapping(value={"index","/","list"})
	public String index(ModelAndView modelAndView){
		return "/goods/gList";
	}
	
	@RequestMapping(value={"add"})
	public String add(ModelAndView modelAndView){
		return "/goods/gAdd";
	}
	
	@RequestMapping(value={"type"})
	public String type(ModelAndView modelAndView){
		return "/goods/gType";
	}
}
