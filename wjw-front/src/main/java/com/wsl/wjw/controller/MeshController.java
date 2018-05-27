package com.wsl.wjw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wsl.wjw.dto.CategoryDto;
import com.wsl.wjw.service.CategoryService;

@Controller
@RequestMapping(value="mesh")
public class MeshController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/{page}/{model}")
    public String meshOne(@PathVariable String page,@PathVariable Long model, Map<String,Object> map) throws Exception {
		List<CategoryDto> categoryList = categoryService.queryCategoryListByTypeId(model);
		if(categoryList != null && categoryList.size() > 0){
			map.put("modelName", categoryList.get(0).getTypeName());
			map.put("categoryList", categoryList);
		}else{
			return "/help";  
		}

		return "/"+page;  
    }
	
}
