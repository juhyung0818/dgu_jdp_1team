package com.jdp.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.jdp.domain.UserVO;
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
			
			Cookie studentCookie, teacherCookie;
			studentCookie=WebUtils.getCookie(request, "studentCookie");
			teacherCookie=WebUtils.getCookie(request, "teacherCookie");
			
			if(studentCookie!=null)
			{
				UserVO student=userService.checkLoginBefore(studentCookie.getValue());
				
				logger.info("USERVO : "+student);
				
				if(student!=null)
				{
					session.setAttribute("student", student);
					return true;
				}
			}
			
			if(teacherCookie!=null)
			{
				UserVO teacher=userService.checkLoginBefore(teacherCookie.getValue());
				
				logger.info("USERVO : "+teacher);
				
				if(teacher!=null)
				{
					session.setAttribute("teacher", teacher);
					return true;
				}
			}
			response.sendRedirect("/user/login");
			return false;
		}
		return true;
	}
}
