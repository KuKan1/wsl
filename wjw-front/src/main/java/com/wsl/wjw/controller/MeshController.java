package com.wsl.wjw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wsl.wjw.constant.PageConst;

@Controller
@RequestMapping(value="mesh")
public class MeshController {

	@RequestMapping(value = "/{page}/{model}")
    public String meshOne(@PathVariable String page,@PathVariable String model, Map<String,Object> map) {
		if(PageConst.MODEL_TB.equals(model)){
			map.put("modelName", PageConst.MODEL_NAME_TB);  
		}else if(PageConst.MODEL_TM.equals(model)){
			map.put("modelName", PageConst.MODEL_NAME_TM);  
		}else if(PageConst.MODEL_JD.equals(model)){
			map.put("modelName", PageConst.MODEL_NAME_JD);  
		}
		List list = new ArrayList();
		for(int i = 0; i < 8; i++){
			list.add(i+1);
		}
		map.put("list", list);
		return "/"+page;  
    }
	
}
