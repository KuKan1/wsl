package com.wsl.wjw.service;

import java.util.List;

import com.wsl.wjw.dto.ShopDto;

public interface ShopService {

	public List<ShopDto> queryShopByTypeId(Long typeId) throws Exception;
	
	public List<ShopDto> queryShopByCategoryId(Long typeId, Long categoryId) throws Exception;
	
	public int insertSelective(ShopDto shopDto) throws Exception;
	
	int deleteByPrimaryKey(Long id) throws Exception;
	
	int updateByPrimaryKeySelective(ShopDto shopDto) throws Exception;
}
