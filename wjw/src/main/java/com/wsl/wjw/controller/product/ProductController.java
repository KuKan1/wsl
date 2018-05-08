package com.wsl.wjw.controller.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wsl.wjw.dto.CategoryDto;
import com.wsl.wjw.service.CategoryService;

@Controller
@RequestMapping(value = {"/product"})
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/index")
    public String index(ModelAndView modelAndView) {
		
		return "/product/product-list";  
    }

	@RequestMapping(value = "/add")
    public String add(HttpServletRequest request,Map<String,Object> map) throws Exception {
		String id_param = request.getParameter("id");
		if(id_param != null){
			String id = id_param.split("[.]")[0];
			CategoryDto categoryDto = categoryService.queryCategoryListById(Long.valueOf(id));
			map.put("categoryDto", categoryDto);
		}
		return "/product/product-add";  
    }
	
    
}