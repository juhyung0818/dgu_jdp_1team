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

import com.jdp.domain.StudentVO;
import com.jdp.domain.SubjectVO;
import com.jdp.service.StudentService;

@Controller
@RequestMapping("/student/*")
public class StudentController {

	@Inject
	private StudentService subjectService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/studentLogin", method = RequestMethod.GET)
	public void registGET() {
		logger.info("student login");
	}

	@RequestMapping(value = "/studentLogin", method = RequestMethod.POST)
	public String registPOST(@RequestParam("sid") String sid, @RequestParam("pw") String pw,
							@ModelAttribute StudentVO student) throws Exception {
		logger.info("student login");
		
		if(subjectService.login(student))
			return "redirect:/student/studentMain?sid="+student.getSid();
		return "redirect:/student/studentLogin";
	}
	
	@RequestMapping(value = "/studentMain", method = RequestMethod.GET)
	public void registGET(@ModelAttribute SubjectVO subject, Model model) {
		logger.info("student main");
	}
}
