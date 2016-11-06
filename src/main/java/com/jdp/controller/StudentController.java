package com.jdp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdp.domain.SubjectVO;
import com.jdp.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Inject
	private StudentService studentService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/studentMain", method = RequestMethod.GET)
	public void registGET(@ModelAttribute SubjectVO subject, Model model) {
		logger.info("student main");
	}
}
