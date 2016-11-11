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

import com.jdp.domain.MemberVO;
import com.jdp.domain.UserVO;
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
	public void registGET(Model model, HttpSession session) {
		logger.info("subject Register...");
		
		model.addAttribute("uname", ((UserVO)session.getAttribute("login")).getUname());
	}
	
	//TODO this method need subjectCode, tid
	@RequestMapping(value = "/tRegister", method = RequestMethod.POST)
	public String registPOST(@RequestParam("subjectName") String subjectName, HttpSession session) throws Exception {
		int subjectCode=subjectService.register(subjectName, ((UserVO)session.getAttribute("login")).getUid());
		return "redirect:/exam/managementExam?subjectCode="+subjectCode;
	}

	@RequestMapping(value = "/tSubject", method = RequestMethod.GET)
	public void listTeacher(Model model, HttpSession session) throws Exception {
		logger.info("teacher subject List...");
		
		UserVO user = (UserVO)session.getAttribute("login");
		model.addAttribute("uname", user.getUname());
		model.addAttribute("list", subjectService.listTeacher(user.getUid()));
	}
	
	@RequestMapping(value = "/sSubject", method = RequestMethod.GET)
	public void listStudent(Model model, HttpSession session) throws Exception {
		logger.info("student subject List...");
		
		UserVO user = (UserVO)session.getAttribute("login");
		model.addAttribute("list", subjectService.listStudent(user.getUid()));
		model.addAttribute("uid", user.getUid());
		model.addAttribute("uname", user.getUname());
	}
	
	@RequestMapping(value = "/sRegister", method = RequestMethod.GET)
	public void sRegisterGET(Model model, HttpSession session) {
		logger.info("Student Subject Register...");
		model.addAttribute("uname", ((UserVO)session.getAttribute("login")).getUname());
	}
	
	@RequestMapping(value ="/sRegister", method = RequestMethod.POST)
	public String sRegisterPOST(@ModelAttribute MemberVO member, Model model, HttpSession session) throws Exception {
		logger.info("Student Subject Register...");
		member.setUid(((UserVO)session.getAttribute("login")).getUid());
		subjectService.joinSubject(member);
		return "redirect:/subject/sSubject";
	}
}
