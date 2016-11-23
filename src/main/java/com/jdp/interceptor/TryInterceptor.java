package com.jdp.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jdp.service.ExamService;

public class TryInterceptor extends HandlerInterceptorAdapter{

	@Inject
	ExamService examService;
	
	private static final Logger logger = LoggerFactory.getLogger(TryInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		if((boolean)session.getAttribute("path"))
		{
			logger.info("correct path..");
			if((boolean)session.getAttribute(("examActive")))
			{
				logger.info("go to exam...");
				return true;
			}
			logger.info("access denied..");
			response.sendRedirect((String)session.getAttribute("deniedURL"));
			return false;
		}
		else
		{
			logger.info("incorrect path..");
			return true;
		}

	}

}
