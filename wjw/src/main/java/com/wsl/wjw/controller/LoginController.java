package com.wsl.wjw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wsl.wjw.contant.SystemCont;

@Controller
public class LoginController {

	@RequestMapping(value = {"/login"})
    public String login(HttpServletRequest request,HttpServletResponse response,ModelAndView modelAndView) throws IOException {
		HttpSession session = request.getSession();
        Object isLogin = session.getAttribute(SystemCont.isLoginCont);
        if(SystemCont.isLogin.equals(isLogin)){
        	response.sendRedirect("/index");
        }
		return "/login";  
    }

	@RequestMapping(value = {"/login/index"},method=RequestMethod.POST)
	@ResponseBody
    public String login(HttpServletRequest request,String usr,String pwd,ModelAndView modelAndView) {
		HttpSession session = request.getSession();
		if("wquanw".equals(usr) && "123+abc".equals(pwd)){
			session.setAttribute(SystemCont.isLoginCont, SystemCont.isLogin);
			return "suc";  
		}
		return "error";  
    }
    
}