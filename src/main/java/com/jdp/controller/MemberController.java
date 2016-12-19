package com.jdp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdp.domain.MemberVO;
import com.jdp.domain.UserVO;
import com.jdp.service.ExamService;
import com.jdp.service.MemberService;
import com.jdp.service.UserService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	@Inject
	UserService userService;
	@Inject
	ExamService examService;
	
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public void listGET(@RequestParam("subjectCode") int subjectCode,
						Model model, HttpSession session) throws Exception {
		
		logger.info("Member management get...");
		
		List<MemberVO> list=memberService.list(subjectCode);
		
		model.addAttribute("member", list);
		model.addAttribute("uname", ((UserVO)session.getAttribute("teacher")).getUname());
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("uid") String uid) throws Exception {
		
		logger.info("member register.........");
		
		memberService.register(subjectCode, uid);
		return "redirect:/member/management?subjectCode="+subjectCode;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePOST(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("uid") String uid) throws Exception {
		
		logger.info("member remove.........");
		
		memberService.remove(subjectCode, uid);
		return "redirect:/member/management?subjectCode="+subjectCode;
	}
}
