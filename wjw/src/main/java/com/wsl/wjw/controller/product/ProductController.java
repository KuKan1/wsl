package com.wsl.wjw.controller.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wsl.wjw.dto.ShopDto;
import com.wsl.wjw.service.ShopService;

@Controller
@RequestMapping(value = {"/product"})
public class ProductController {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value = "/index")
    public String index(ModelAndView modelAndView) {
		
		return "/product/product-list";  
    }

	@ResponseBody
	@RequestMapping(value="/{id}")
	public ShopDto queryShopById(@PathVariable Long id) throws Exception{
		return shopService.queryShopById(id);
	}
	
	@RequestMapping(value = "/add")
    public String add(HttpServletRequest request,Map<String,Object> map) throws Exception {
		String id = request.getParameter("id");
		if(id != null){
			ShopDto shopDto = shopService.queryShopById(Long.valueOf(id));
			map.put("shopDto", shopDto);
		}
		return "/product/product-add";  
    }
	
	@ResponseBody
	@RequestMapping(value="/{typeId}/{categoryId}")
	public List<ShopDto> queryShopByCategoryId(@PathVariable Long typeId,@PathVariable Long categoryId) throws Exception{
		return shopService.queryShopByCategoryId(typeId, categoryId);
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(ShopDto shopDto) throws Exception{
		if(shopDto != null){
			if(shopDto.getId() == null){
				shopService.insertSelective(shopDto);
			}else{
				shopService.updateByPrimaryKeySelective(shopDto);
			}
			return "{\"status\":\"S\",\"msg\":\"保存成功\"}";
		}
		return "{\"status\":\"E\",\"msg\":\"保存失败\"}";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public String deleteShop(@RequestBody String ids) throws Exception{
		if(shopService.batchDel(ids)){
			return "{\"status\":\"S\",\"msg\":\"删除成功\"}";
		}else{
			return "{\"status\":\"E\",\"msg\":\"删除失败\"}";
		}
	}
	
}