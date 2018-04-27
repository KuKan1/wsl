package com.wsl.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsl.wjw.dto.TypeDto;
import com.wsl.wjw.mapper.TypeMapper;
import com.wsl.wjw.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeMapper typeMapper;

	@Override
	public TypeDto queryTypeDtoById(Long id) {
		return typeMapper.queryTypeDtoById(id);
	}

	@Override
	public List<TypeDto> queryAllTypeDto() throws Exception {
		return typeMapper.queryAllTypeDto();
	}

}
