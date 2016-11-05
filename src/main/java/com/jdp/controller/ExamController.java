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

/**
 * controller of teacher and students about exam
 * 
 * @author YJH 2016.10.19.Wed
 */

@Controller //get, post, put, patch
@RequestMapping("/exam")
public class ExamController {

	@Inject
	private ExamService examService;

	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode) {
		logger.info("question register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(@RequestParam("subjectCode") int subjectCode, @RequestParam("examName") String examName, 
							 @RequestParam("num") int num, @ModelAttribute ExamVO exam) throws Exception {
		logger.info("exam register.........");
		logger.info(exam.toString());
		exam.setSubjectCode(subjectCode);
		exam.setExamName(examName);
		examService.register(exam);
		return "redirect:/question/register?subjectCode="+subjectCode+"&examName="+examName+"&num="+num;
	}

	// TODO subject code....
	@RequestMapping(value = "/managementExam", method = RequestMethod.GET)
	public void managementExamGET(@RequestParam("subjectCode") int subjectCode, Model model) throws Exception {
		logger.info("subjectCode : " + subjectCode + "examList");
		model.addAttribute("list", examService.examList(subjectCode));
		model.addAttribute("subjectCode", subjectCode);
	}
}
