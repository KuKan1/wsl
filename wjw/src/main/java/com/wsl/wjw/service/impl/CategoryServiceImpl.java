package com.wsl.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsl.wjw.dto.CategoryDto;
import com.wsl.wjw.mapper.CategoryMapper;
import com.wsl.wjw.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryDto> queryCategoryListByTypeId(Long typeId) throws Exception {
		return categoryMapper.queryCategoryListByTypeId(typeId);
	}

}
