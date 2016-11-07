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
import com.jdp.domain.SubjectVO;
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
	public String registPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("uid") String uid, @ModelAttribute SubjectVO subject) throws Exception {
		subject.setSubjectCode(subjectCode);
		subjectService.register(subject);
		return "redirect:/exam/managementExam?subjectCode="+subject.getSubjectCode();
	}

	@RequestMapping(value = "/tSubject", method = RequestMethod.GET)
	//public void listTeacher(@RequestParam("uid") String uid, Model model) throws Exception {
	public void listTeacher(Model model, HttpSession session) throws Exception {
		logger.info("teacher subject List...");
		
		UserVO vo=(UserVO)session.getAttribute("login");
		model.addAttribute("list", subjectService.listTeacher(vo.getUid()));
		model.addAttribute("uname", vo.getUname());
	}
	
	@RequestMapping(value = "/sSubject", method = RequestMethod.GET)
	//public void listStudent(@RequestParam("uid") String uid, Model model) throws Exception {
	public void listStudent(Model model, HttpSession session) throws Exception {
		logger.info("student subject List...");
		
		UserVO vo=(UserVO)session.getAttribute("login");
		model.addAttribute("list", subjectService.listStudent(vo.getUid()));
		model.addAttribute("uid", vo.getUid());
		model.addAttribute("uname", vo.getUname());
	}
	
	@RequestMapping(value = "/sRegister", method = RequestMethod.GET)
	public void sRegisterGET(Model model, HttpSession session) {
		logger.info("Student Subject Register...");
		
		model.addAttribute("uname", ((UserVO)session.getAttribute("login")).getUname());
	}
	
//	@RequestMapping(value ="/sRegister", method = RequestMethod.POST)
//	public String sRegisterPOST(@RequestParam("uid") String uid, @ModelAttribute MemberVO member, Model model) throws Exception {
//		logger.info("Student Subject Register...");
//		subjectService.joinSubject(member);
//		return "redirect:/subject/sSubject?uid="+uid;
//	}
	@RequestMapping(value ="/sRegister", method = RequestMethod.POST)
	public String sRegisterPOST(@ModelAttribute MemberVO member, Model model) throws Exception {
		logger.info("Student Subject Register...");
		subjectService.joinSubject(member);
		return "redirect:/subject/sSubject";
	}
}
