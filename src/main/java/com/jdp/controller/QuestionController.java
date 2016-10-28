package com.jdp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdp.domain.QuestionListVO;
import com.jdp.service.QuestionServiceImpl;

@Controller
@RequestMapping("/question/*")
public class QuestionController {
	
	@Inject
	private QuestionServiceImpl questionService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute QuestionListVO questions, Model model) {
		logger.info("Question Register...");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(@ModelAttribute QuestionListVO questions) throws Exception{
		logger.info("question register.........");
		questionService.register(questions);
		return "question/success";
	}

}
