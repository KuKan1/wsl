package com.wsl.wjw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsl.wjw.dto.ShopDto;
import com.wsl.wjw.service.ShopService;

@RestController
@RequestMapping(value="shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value="/{typeId}")
	public List<ShopDto> queryShopByTypeId(@PathVariable Long typeId) throws Exception{
		return shopService.queryShopByTypeId(typeId);
	}
	
	@RequestMapping(value="/{typeId}/{categoryId}")
	public List<ShopDto> queryShopByCategoryId(@PathVariable Long typeId,@PathVariable Long categoryId) throws Exception{
		return shopService.queryShopByCategoryId(typeId, categoryId);
	}

}
