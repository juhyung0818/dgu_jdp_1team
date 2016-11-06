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

import com.jdp.domain.ExamVO;
import com.jdp.service.ExamService;
import com.jdp.service.QuestionService;

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

	// TODO subject code.... exam
	@RequestMapping(value = "/managementExam", method = RequestMethod.GET)
	public void managementExamGET(Model model) throws Exception {
		logger.info("subjectCode : " + "" + "examList");
		model.addAttribute("list", examService.examList(12312));
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("examName") String examName, Model model) throws Exception {

		model.addAttribute("list", questionService.listQuestion(12312, examName));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(ExamVO exam, Model model) {
		logger.info("question register");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(@ModelAttribute ExamVO exam) throws Exception{

		logger.info("exam register.........");
		logger.info(exam.toString());
		
		examService.register(exam);
		
		return "redirect:/teacher/managementExam";
		//please change teacher main later

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("examName") String examName) throws Exception {
		logger.info("subjectCode: "  + " examName: " + examName +" delete....");
		examService.delete(12312, examName);
		return "redirect:/teacher/managementExam";
	}
}
