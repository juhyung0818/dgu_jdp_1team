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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/tRegister", method = RequestMethod.GET)
	public void registGET(Model model, HttpSession session) {
		logger.info("subject Register...");
		UserVO user = (UserVO)session.getAttribute("teacher");
		model.addAttribute("uname", user.getUname());
	}
	
	//TODO this method need subjectCode, tid
	@RequestMapping(value = "/tRegister", method = RequestMethod.POST)
	public String registPOST(@RequestParam("subjectName") String subjectName,
			RedirectAttributes rttr, HttpSession session) throws Exception {
		UserVO user = (UserVO)session.getAttribute("teacher");
		subjectService.register(subjectName, user.getUid());
		
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/subject/tSubject";
	}

	@RequestMapping(value = "/tSubject", method = RequestMethod.GET)
	public void listTeacher(Model model, HttpSession session) throws Exception {
		logger.info("teacher subject List...");
		UserVO vo=(UserVO)session.getAttribute("teacher");
		model.addAttribute("list", subjectService.listTeacher(vo.getUid()));
		model.addAttribute("uname", vo.getUname());
	}
	
	/**
	 * student join subject
	 * @param model
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/sSubject", method = RequestMethod.GET)
	public void listStudent(Model model, HttpSession session) throws Exception {
		logger.info("student subject List...");
		
		UserVO vo=(UserVO)session.getAttribute("student");
		model.addAttribute("list", subjectService.listStudent(vo.getUid()));
		model.addAttribute("uid", vo.getUid());
		model.addAttribute("uname", vo.getUname());
		
	}
	
	/**
	 * student join subject
	 * @param model
	 * @param session
	 */
	@RequestMapping(value = "/sRegister", method = RequestMethod.GET)
	public void sRegisterGET(Model model, HttpSession session) {
		logger.info("Student Subject Register...");
		
		model.addAttribute("uname", ((UserVO)session.getAttribute("student")).getUname());
	}

	@RequestMapping(value ="/sRegister", method = RequestMethod.POST)
	public String sRegisterPOST(@ModelAttribute MemberVO member, Model model, HttpSession session) throws Exception {
		logger.info("Student Subject Register...");
		UserVO user = new UserVO();
		user = (UserVO)session.getAttribute("student");
		member.setUid(user.getUid());
		subjectService.joinSubject(member);
		return "redirect:/subject/sSubject";
	}
	
	/**
	 * teacher remove subject 
	 * @param subjectCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/tDelete", method = RequestMethod.POST)
	public String tDeletePOST(@RequestParam("subjectCode") int subjectCode) throws Exception {
		logger.info("teacher Subject delete...");
		subjectService.delete(subjectCode);
		return "redirect:/subject/tSubject";
	}
	
	/**
	 * GET method to update subject information
	 * @param subjectCode : key value 
	 * @param model : object give jsp to pass
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void subjectModifyGET(@RequestParam("subjectCode") int subjectCode, Model model) throws Exception{
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("subjectName", subjectService.getSubjectName(subjectCode));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String subjectModifyPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("subjectName") String subjectName,
			RedirectAttributes rttr) throws Exception{
		subjectService.modify(subjectCode, subjectName);
	    rttr.addAttribute("subjectCode", subjectCode);
		return "redirect:/exam/managementExam";
	}
	
	@RequestMapping(value="/leave", method = RequestMethod.POST)
	public String leaveSubjectPOST(@RequestParam("subjectCode") int subjectCode, 
			HttpSession session) throws Exception{
		logger.info("leave subject....");
		UserVO user = new UserVO();
		user = (UserVO)session.getAttribute("student");
		subjectService.leaveSubject(user.getUid(), subjectCode);
		return "redirect:/subject/sSubject";
	}
}

