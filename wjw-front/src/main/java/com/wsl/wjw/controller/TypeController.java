package com.wsl.wjw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsl.wjw.dto.TypeDto;
import com.wsl.wjw.service.TypeService;

@RestController
@RequestMapping(value="type")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value="/all")
	public List<TypeDto> queryAllType() throws Exception{
		return typeService.queryAllTypeDto();
	}

}
