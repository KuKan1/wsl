package com.wsl.wjw.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wsl.wjw.dto.back.CategoryTreeDto;
import com.wsl.wjw.service.CategoryService;

@Controller
@RequestMapping(value = {"/product/category"})
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/index")
    public String index(ModelAndView modelAndView) {
		
		return "/product/product-category";  
    }
	
	@RequestMapping(value = "/add")
    public String add(ModelAndView modelAndView) {
		
		return "/product/product-category-add";  
    }
	
	@ResponseBody
	@RequestMapping(value = "/list")
	public List<CategoryTreeDto> queryCategoryList() throws Exception{
		return categoryService.queryCategoryList();
	}

    
}