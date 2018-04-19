package com.wsl.wjw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsl.wjw.dto.ShopDto;
import com.wsl.wjw.dto.query.ShopQueryParam;

public interface ShopMapper {

	public List<ShopDto> queryShopByTypeId(@Param("typeId") Long typeId) throws Exception;
	
	public List<ShopDto> queryShopByCategoryId(ShopQueryParam shopQueryParam) throws Exception;
}
