package com.wsl.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="column")
public class ColumnController {

	@RequestMapping(value={"index","/","list"})
	public String index(ModelAndView modelAndView){
		return "/column/column";
	}
}
