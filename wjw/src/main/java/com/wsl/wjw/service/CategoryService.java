package com.wsl.wjw.service;

import java.util.List;

import com.wsl.wjw.dto.CategoryDto;

public interface CategoryService {

	/**
	 * 根据类型查询所有分类
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	List<CategoryDto> queryCategoryListByTypeId(Long typeId) throws Exception;
}
