package com.wsl.wjw.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/product"})
public class ProductController {
	
	@RequestMapping(value = "/index")
    public String index(ModelAndView modelAndView) {
		
		return "/product/product-list";  
    }

    
}