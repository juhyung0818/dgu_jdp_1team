package com.jdp.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jdp.domain.UserVO;
/**
 * add comment plz
 * @author KSS
 * insert date
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	//private static final String LOGIN ="login";
	private static final String STUDENT ="student";
	private static final String TEACHER ="teacher";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session=request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object user = modelMap.get("userVO");
		UserVO vo=(UserVO)user;
		
		if(user !=null)
		{
			logger.info("new login success");
			Object dest=session.getAttribute("dest");
			
			//url after login success
			
			//case : student
			if(vo.getFlag()==0)
			{
				session.setAttribute(STUDENT, user);
				if(request.getParameter("useCookie")!=null)
				{
					logger.info("remember me...");
					Cookie studentCookie = new Cookie("studentCookie", session.getId());
					studentCookie.setPath("/");
					studentCookie.setMaxAge(60*60*24*7); // 1 week
					response.addCookie(studentCookie);
				}
				response.sendRedirect(dest!=null?(String)dest : "/subject/sSubject");
			}
				
			//case : teacher
			else
			{
				session.setAttribute(TEACHER, user);
				if(request.getParameter("useCookie")!=null)
				{
					logger.info("remember me...");
					Cookie teacherCookie = new Cookie("teacherCookie", session.getId());
					teacherCookie.setPath("/");
					teacherCookie.setMaxAge(60*60*24*7);// 1 week
					response.addCookie(teacherCookie);
				}
				response.sendRedirect(dest!=null?(String)dest : "/subject/tSubject");
			}
		}
		else
		{
			logger.info("userVO is null...");
			//url after login fail
			response.sendRedirect("/user/login");
		}
			
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session =request.getSession();
		
		if((session.getAttribute(STUDENT)!=null))
		{
			logger.info("clear login data before");
			session.removeAttribute(STUDENT);
		}
		else if(session.getAttribute(TEACHER)!=null)
		{
			logger.info("clear login data before");
			session.removeAttribute(TEACHER);
		}
		return true;
	}	
}
