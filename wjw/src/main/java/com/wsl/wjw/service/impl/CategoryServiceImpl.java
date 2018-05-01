package com.wsl.wjw.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsl.wjw.dto.CategoryDto;
import com.wsl.wjw.dto.back.CategoryTreeDto;
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

	@Override
	public List<CategoryTreeDto> queryCategoryList() throws Exception {
		List<CategoryTreeDto> categoryTree = new ArrayList<CategoryTreeDto>();
		List<CategoryDto> categoryList = categoryMapper.queryCategoryList();
		if(categoryList != null){
			Set<Long> parentSet = new HashSet<Long>();
			CategoryTreeDto categoryTreeDto = null;
			for (CategoryDto categoryDto : categoryList) {
				if(!parentSet.contains(categoryDto.getTypeId())){
					categoryTreeDto = new CategoryTreeDto();
					categoryTreeDto.setId(categoryDto.getTypeId());
					categoryTreeDto.setName(categoryDto.getTypeName());
					categoryTreeDto.setpId(0L);
					categoryTree.add(categoryTreeDto);
					
					parentSet.add(categoryDto.getTypeId());
				}
				categoryTreeDto = new CategoryTreeDto();
				String id = categoryDto.getTypeId()+""+categoryDto.getId();
				categoryTreeDto.setId(Long.valueOf(id));
				categoryTreeDto.setName(categoryDto.getVname());
				categoryTreeDto.setpId(categoryDto.getTypeId());
				//categoryTreeDto.setUrl("/product/category/add?id="+categoryDto.getId());
				//categoryTreeDto.setTarget("catetoryIframe");
				categoryTreeDto.setFile("/product/category/add?id="+categoryDto.getId());
				categoryTree.add(categoryTreeDto);
			}
		}
		return categoryTree;
	}
	
	@Override
	public CategoryDto queryCategoryListById(Long id) throws Exception{
		
		return categoryMapper.queryCategoryListById(id);
	}
	
}
