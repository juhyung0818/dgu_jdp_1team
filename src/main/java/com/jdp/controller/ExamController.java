package com.jdp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdp.service.ExamService;

/**
 * controller of teacher and students about exam 
 * @author YJH
 */
@Controller
@RequestMapping("/exam/*")
public class ExamController {

	@Inject
	private ExamService examService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

}
