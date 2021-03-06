package com.wsl.wjw.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsl.wjw.dto.CategoryDto;
import com.wsl.wjw.dto.back.CategoryTreeDto;

public interface CategoryService {

	/**
	 * 根据id查询分类
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	CategoryDto queryCategoryListById(@Param("id") Long id) throws Exception;
	
	/**
	 * 根据类型查询所有分类
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	List<CategoryDto> queryCategoryListByTypeId(Long typeId) throws Exception;
	
	/**
	 * 查询所有分类
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	List<CategoryTreeDto> queryCategoryList() throws Exception;
}
