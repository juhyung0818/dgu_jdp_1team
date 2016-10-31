package com.jdp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdp.domain.QuestionVO;
import com.jdp.service.QuestionServiceImpl;

/**
 * controller of teacher and students about exam 
 * @author YJH
 * 2016.10.19.Wed
 */
@Controller
@RequestMapping("/exam/*")
public class ExamController {

	@Inject
	private QuestionServiceImpl examService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(QuestionVO questions, Model model) {
		logger.info("Welcome home! The client locale is {}.");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String regist(QuestionVO questions) throws Exception{
		logger.info("exam register.........");
		
		examService.register(questions);
		
		return "home";

	}
}
