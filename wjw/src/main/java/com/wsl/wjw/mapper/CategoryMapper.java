package com.wsl.wjw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsl.wjw.dto.CategoryDto;

public interface CategoryMapper {

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
	List<CategoryDto> queryCategoryListByTypeId(@Param("typeId") Long typeId) throws Exception;
	
	/**
	 * 查询所有分类
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	List<CategoryDto> queryCategoryList() throws Exception;
	
}
