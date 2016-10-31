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

import com.jdp.domain.QuestionVO;
import com.jdp.service.ExamService;
import com.jdp.service.QuestionService;

/**
 * controller of teacher and students about exam
 * 
 * @author YJH 2016.10.31.Mun
 */
@Controller
@RequestMapping("/teacher/*")
public class TeacherController {

	// Exam Service instance
	@Inject
	private ExamService examService;
	@Inject
	private QuestionService questionService;
	// instance for log
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(method = RequestMethod.GET)
	public void mainView(Model model) throws Exception {
		logger.info("subjectCode : " + "" + "examList");
		model.addAttribute("list", examService.examList(12312));
	}


	// TODO subject code....
	@RequestMapping(value = "/managementExam", method = RequestMethod.GET)
	public void managementExamGET(Model model) throws Exception {
		logger.info("subjectCode : " + "" + "examList");
		model.addAttribute("list", examService.examList(12312));
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("subjcetCode") int subjectCode, @RequestParam("examName") String examName,
			Model model) throws Exception {

		model.addAttribute("list", questionService.questionList(12312, "test"));
	}

}
