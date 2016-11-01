package com.jdp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdp.domain.ExamVO;
import com.jdp.service.ExamService;

@Controller
@RequestMapping("/subject/*")
public class SubjectController {
	@Inject
	private ExamService examService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute ExamVO exam, Model model) {
		logger.info("exam register");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(@ModelAttribute ExamVO exam) throws Exception{

		logger.info("exam register.........");
		logger.info(exam.toString());
		
		examService.register(exam);
		
		return "home";
		//please change teacher main later
	}
}
