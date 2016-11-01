package com.jdp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdp.domain.SubjectVO;
import com.jdp.service.SubjectService;

@Controller
@RequestMapping("/subject/*")
public class SubjectController {

	@Inject
	private SubjectService subjectService;
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectName") String subjectName) {
		logger.info("subject Register...");
	}
	
	//TODO this method need subjectCode, tid
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(SubjectVO subject) throws Exception {
//		SubjectVO subject = new SubjectVO();
//		subject.setSubjectCode(100);
//		subject.setTid("jh");
//		subject.setSubjectName(subjectName);
		subjectService.register(subject);
		return "redirect:/exam/managementExam";
	}
}
