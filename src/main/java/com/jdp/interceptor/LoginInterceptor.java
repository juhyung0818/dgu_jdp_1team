package com.jdp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.jdp.domain.UserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final String LOGIN ="login";
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
			session.setAttribute(LOGIN, user);
			//response.sendRedirect("/");
			//"/"->"/subject/subjectList"
			
			Object dest=session.getAttribute("dest");
			//url after login success
			
			//case : student
			if(vo.getFlag()==0)
				response.sendRedirect(dest!=null?(String)dest : "/subject/sSubject");
			//case : teacher
			else
				response.sendRedirect(dest!=null?(String)dest : "/subject/tSubject");
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
		
		if(session.getAttribute(LOGIN)!=null)
		{
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		return true;
	}	
}
