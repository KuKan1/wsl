package com.wsl.wjw.interceptor;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wsl.wjw.contant.SystemCont;

public class CommonInterceptor implements HandlerInterceptor {
	
	private static List<String> excludeUrls;

	static{
		excludeUrls = new ArrayList();
		excludeUrls.add("/**");
		excludeUrls.add("/login");
		excludeUrls.add("login/index");
	}
	
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
	
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    	String requestUri = httpServletRequest.getRequestURI();
    	String contextPath = httpServletRequest.getContextPath();
    	String url = requestUri.substring(contextPath.length());
    	String path = httpServletRequest.getContextPath();
        String scheme = httpServletRequest.getScheme();
        String serverName = httpServletRequest.getServerName();
        int port = httpServletRequest.getServerPort();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        httpServletRequest.setAttribute("basePath", basePath);
        
        if (contains(excludeUrls, url)) {
			return true;
		}else{
			HttpSession session = httpServletRequest.getSession();
	        Object isLogin = session.getAttribute(SystemCont.isLoginCont);
	        if(!SystemCont.isLogin.equals(isLogin)){
	        	httpServletResponse.sendRedirect("/login");
	        }
		}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
    
    private boolean contains(List<String> list, String url) {
		try {
			for (String str : list) {
				System.out.println(url + "==" + str);
				if (url.contains(str)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}