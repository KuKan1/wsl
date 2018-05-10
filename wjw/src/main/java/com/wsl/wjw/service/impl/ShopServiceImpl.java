package com.wsl.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsl.wjw.dto.ShopDto;
import com.wsl.wjw.dto.query.ShopQueryParam;
import com.wsl.wjw.mapper.ShopMapper;
import com.wsl.wjw.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopMapper shopMapper;
	
	@Override
	public List<ShopDto> queryShopByTypeId(Long typeId) throws Exception {
		return shopMapper.queryShopByTypeId(typeId);
	}

	@Override
	public List<ShopDto> queryShopByCategoryId(Long typeId, Long categoryId) throws Exception {
		ShopQueryParam shopQueryParam = new ShopQueryParam();
		shopQueryParam.setTypeId(typeId);
		shopQueryParam.setCategoryId(categoryId);
		return shopMapper.queryShopByCategoryId(shopQueryParam);
	}

	@Override
	public int insertSelective(ShopDto shopDto) throws Exception {
		return shopMapper.insertSelective(shopDto);
	}

	@Override
	public int deleteByPrimaryKey(Long id) throws Exception {
		return shopMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopDto shopDto) throws Exception {
		return shopMapper.updateByPrimaryKeySelective(shopDto);
	}

}
