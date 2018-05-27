package com.wsl.wjw.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsl.wjw.dto.ShopDto;

public interface ShopService {

	public ShopDto queryShopById(@Param("id") Long id) throws Exception;
	
	public List<ShopDto> queryShopByTypeId(Long typeId) throws Exception;
	
	public List<ShopDto> queryShopByCategoryId(Long typeId, Long categoryId) throws Exception;
	
	public int insertSelective(ShopDto shopDto) throws Exception;
	
	int deleteByPrimaryKey(Long id) throws Exception;
	
	int updateByPrimaryKeySelective(ShopDto shopDto) throws Exception;
	
	public boolean batchDel(String ids) throws Exception;
}
