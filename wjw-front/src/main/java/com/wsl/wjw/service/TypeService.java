package com.wsl.wjw.service;

import java.util.List;

import com.wsl.wjw.dto.TypeDto;

/**
 * 券类型
 * @author liuzy
 *
 */
public interface TypeService {

	TypeDto queryTypeDtoById(Long id) throws Exception;
	
	List<TypeDto> queryAllTypeDto() throws Exception;
}
