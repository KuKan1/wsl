package com.wsl.wjw.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wsl.wjw.dto.TypeDto;
import com.wsl.wjw.service.TypeService;

@Controller
@RequestMapping(value = {"/brand"})
public class BrandController {
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value = "/index")
    public String index(ModelAndView modelAndView) {
		
		return "/product/product-brand";  
    }

	@ResponseBody
	@RequestMapping(value = "/list")
	public List<TypeDto> queryTypeList() throws Exception{
		return typeService.queryAllTypeDto();
	}
	
    
}