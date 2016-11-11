package com.jdp.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import com.jdp.service.UserService;
/**
 * login authority
 * @author kwon
 * update date : 2016-11-11
 */
public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Inject
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		if(session.getAttribute("student")==null && session.getAttribute("teacher")==null)
		{
			logger.info("current user is not logined");
			
			saveDest(request);
			
			Cookie studentCookie, teacherCookie;
			//strs
			
			response.sendRedirect("/user/login");
			return false;
		}
		return true;
	}
	
	private void saveDest(HttpServletRequest req)
	{
		String uri=req.getRequestURI();
		
		String query=req.getQueryString();
		
		if(query==null || query.equals("null"))
			query="";
		else
			query="?"+query;
		
		if(req.getMethod().equals("GET"))
		{
			logger.info("dest : "+(uri+query));
			req.getSession().setAttribute("dest", uri+query);
		}
	}
}
