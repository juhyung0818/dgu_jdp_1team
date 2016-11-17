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
/**
 * prevent that who took a exam before try exam again
 * @author kwon
 * update date : 2016-11-13
 */
public class ExamInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Inject
	private ScoreService scoreService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//because bring what i added to model in get/post method 
		ModelMap modelMap=modelAndView.getModelMap();
		
		ScoreVO score=(ScoreVO)modelMap.get("scoreVO");
		int subjectCode=(int)modelMap.get("currentSubCode");
		String examName=(String)modelMap.get("currentExamName");
	
		try {
			if(!score.getUid().equals(""))
			{
				// case : took a exam before
				logger.info("you took a exam before!!");
				response.sendRedirect("/exam/studentExam?subjectCode="+subjectCode);
				
			}
		} catch (Exception e) {
			//case : didn't take a exam
			response.sendRedirect("/question/try?subjectCode="+subjectCode+"&examName="+examName);
		}
	}


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
