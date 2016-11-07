package com.jdp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdp.domain.QuestionVO;

@Controller
@RequestMapping("/test/*")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void registGET(QuestionVO questions, Model model) {
		logger.info("testing....");
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login (Model model) {
		logger.info("testing....");
	}
}
