package com.wsl.wjw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsl.wjw.dto.TypeDto;

/**
 * 券类型Mapper
 * @author liuzy
 */
public interface TypeMapper {

	TypeDto queryTypeDtoById(@Param("id") Long id);
	
	List<TypeDto> queryAllTypeDto();
}
