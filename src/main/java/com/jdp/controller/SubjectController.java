package com.jdp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdp.domain.SubjectVO;
import com.jdp.service.SubjectService;

/**
 * Controller for Subject
 * @author YJH
 * 2016.11.02.Wed
 */

@Controller
@RequestMapping("/subject/*")
public class SubjectController {
	
	@Inject
	private SubjectService subjectService;
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("tid") String tid, Model model) {
		logger.info("subject Register...");
		model.addAttribute("tid", tid);
	}
	
	//TODO this method need subjectCode, tid
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("tid") String tid, @RequestParam("subjectName") String subjectName) throws Exception {
		SubjectVO subject = new SubjectVO();
		subject.setSubjectCode(subjectCode);
		subject.setSubjectName(subjectName);
		subject.setTid(tid);
		subjectService.register(subject);
		return "redirect:/exam/managementExam?subjectCode="+subjectCode;
	}
}
