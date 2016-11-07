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

import com.jdp.domain.MemberVO;
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
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);

	@RequestMapping(value = "/tRegister", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("uid") String uid, Model model) {
		logger.info("subject Register...");
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("uid", uid);
	}
	
	//TODO this method need subjectCode, tid
	@RequestMapping(value = "/tRegister", method = RequestMethod.POST)
	public String registPOST(@RequestParam("uid") String uid, 
			@ModelAttribute SubjectVO subject) throws Exception {
		subjectService.register(subject);
		return "redirect:/exam/managementExam?subjectCode="+subject.getSubjectCode();
	}

	@RequestMapping(value = "/tSubject", method = RequestMethod.GET)
	public void listTeacher(@RequestParam("uid") String uid, Model model) throws Exception {
		logger.info("teacher subject List...");
		model.addAttribute("list", subjectService.listTeacher(uid));
		model.addAttribute("uid", uid);
	}
	
	@RequestMapping(value = "/sSubject", method = RequestMethod.GET)
	public void listStudent(@RequestParam("uid") String uid, Model model) throws Exception {
		logger.info("student subject List...");
		model.addAttribute("list", subjectService.listStudent(uid));
		model.addAttribute("uid", uid);
	}
	
	@RequestMapping(value = "/sRegister", method = RequestMethod.GET)
	public void sRegisterGET(@RequestParam("uid") String uid, Model model) {
		logger.info("Student Subject Register...");
		model.addAttribute("uid", uid);
	}
	
	@RequestMapping(value ="/sRegister", method = RequestMethod.POST)
	public String sRegisterPOST(@RequestParam("uid") String uid, @ModelAttribute MemberVO member, Model model) throws Exception {
		logger.info("Student Subject Register...");
		subjectService.joinSubject(member);
		return "redirect:/subject/sSubject?uid="+uid;
	}

}
