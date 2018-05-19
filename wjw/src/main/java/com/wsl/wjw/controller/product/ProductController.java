package com.wsl.wjw.controller.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wsl.wjw.dto.CategoryDto;
import com.wsl.wjw.dto.ShopDto;
import com.wsl.wjw.service.CategoryService;
import com.wsl.wjw.service.ShopService;

@Controller
@RequestMapping(value = {"/product"})
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ShopService shopService;
	
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
	
	@ResponseBody
	@RequestMapping(value="/{typeId}/{categoryId}")
	public List<ShopDto> queryShopByCategoryId(@PathVariable Long typeId,@PathVariable Long categoryId) throws Exception{
		return shopService.queryShopByCategoryId(typeId, categoryId);
	}
	
	@ResponseBody
	@RequestMapping(value="/save")
	public String save(ShopDto shopDto) throws Exception{
		int count = shopService.insertSelective(shopDto);
		return "suc";
	}
    
}