package com.wsl.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="sys")
public class SystemController {

	
	@RequestMapping(value="uploadPic")
	public String uploadPic(){
		return "/system/uploadPic";
	}
}
