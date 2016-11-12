package com.jdp.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jdp.domain.ScoreVO;
import com.jdp.service.ScoreService;

public class ExamInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//HttpSession session=request.getSession();
		ModelMap modelMap=modelAndView.getModelMap();
		ScoreVO score=(ScoreVO)modelMap.get("scoreVO");
		
		if(!score.getUid().equals(""))
		{
			response.sendRedirect("/question/try?subjectCode="+score.getSubjectCode()+"&examName"+score.getExamName());
		}
		else
		{
			response.sendRedirect("/exam/studentExam");
		}
	}

	@Inject
	private ScoreService scoreService;

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//
//		HttpSession session=request.getSession();
//		
//		if(session.getAttribute("isTry")!=null)
//		{
//			logger.info("you took a exam before!!");
//			return false;
//		}
//		return true;
//	}
	
	
}
