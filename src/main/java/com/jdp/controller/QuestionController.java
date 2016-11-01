package com.jdp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdp.domain.QuestionListVO;
import com.jdp.domain.QuestionVO;
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
	public String registPOST(@ModelAttribute QuestionVO question) throws Exception{
		logger.info("question register.........");
		questionService.register(question);
		return "redirect:/exam/managementExam";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void read(@RequestParam("examName") String examName, Model model) throws Exception {
		model.addAttribute("list", questionService.questionList(12312, examName));
	}
}
