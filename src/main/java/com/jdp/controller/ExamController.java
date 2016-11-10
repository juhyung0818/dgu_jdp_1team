package com.jdp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdp.domain.ExamVO;
import com.jdp.domain.UserVO;
import com.jdp.service.ExamService;
import com.jdp.service.ScoreService;

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
	@Inject
	private ScoreService scoreService;

	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode, Model model, HttpSession session) {
		logger.info("question register");
		model.addAttribute("uname", ((UserVO)session.getAttribute("teacher")).getUname());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName, 
			@RequestParam("num") int num, 
			@ModelAttribute ExamVO exam, Model model) throws Exception {
		logger.info("exam register.........");
		logger.info(exam.toString());
		exam.setSubjectCode(subjectCode);
		exam.setExamName(examName);
		examService.register(exam);
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		return "redirect:/question/register?subjectCode="+subjectCode+"&examName="+examName+"&num="+num;
	}

	@RequestMapping(value = "/managementExam", method = RequestMethod.GET)
	public void managementExamGET(@RequestParam("subjectCode") int subjectCode, Model model, HttpSession session) throws Exception {
		logger.info("subjectCode : " + subjectCode + "examList");
		
		model.addAttribute("list", examService.examList(subjectCode));
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		
		model.addAttribute("uname", ((UserVO)session.getAttribute("teacher")).getUname());
	}

	@RequestMapping(value = "/managementExam", method = RequestMethod.POST)
	public String managementExamPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName) throws Exception {
		logger.info("subjectCode: " + subjectCode +" examName: " + examName + " delete....");

		examService.delete(subjectCode, examName);
		return "redirect:/exam/managementExam?subjectCode="+subjectCode;
	}
	@RequestMapping(value = "/studentExam", method = RequestMethod.GET)
	public void studentExamGET(@RequestParam("subjectCode") int subjectCode, Model model, HttpSession session) throws Exception {
		logger.info("subjectCode : " + subjectCode + "examList");
		
		//model.addAttribute("score", scoreService.myScore(((UserVO)session.getAttribute("student")).getUid()));
		model.addAttribute("score", "-");
		model.addAttribute("list", examService.examList(subjectCode));
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		
		model.addAttribute("uname", ((UserVO)session.getAttribute("student")).getUname());
	}
}