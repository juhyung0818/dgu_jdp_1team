package com.jdp.controller;



import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdp.domain.ExamVO;
import com.jdp.domain.MemberListVO;
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
	private List<MemberListVO> listMem;
	private int flag=0;
	@Inject
	private SubjectService subjectService;
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/tRegister", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("uid") String uid, Model model) {
		logger.info("subject Register...");
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("uid", uid);
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
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public void registGET(
			@ModelAttribute MemberListVO memberList, Model model) throws Exception {
		logger.info("Student Subject Register...");
//		String member_grade="";
//		String member_classNumber="";
//		String member_studentNumber="";
//		String member_name="";
//		memberList.setUid("jo");//have to modify
//		memberList.setSubjectCode(1);//have to modify
//		if(!member_grade.equals(""))
//			memberList.setGrade(Integer.parseInt(member_grade));
//		if(!member_classNumber.equals(""))
//			memberList.setGrade(Integer.parseInt(member_classNumber));
//		if(!member_studentNumber.equals(""))
//			memberList.setGrade(Integer.parseInt(member_studentNumber));
//		if(!member_name.equals(""))
//			memberList.setName(member_name);
//		//subjectService.listMember2(memberList);
//		model.addAttribute("list", subjectService.listMember2(memberList));
//		//model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		if(flag==0){
			listMem=subjectService.listMember("jo", 1);
		} 
		model.addAttribute("list", listMem);
		flag =0;
	}
	@RequestMapping(value = "/management", method = RequestMethod.POST)
	public String registPOST(@RequestParam("member_grade") String member_grade, 
			@RequestParam("member_classNumber") String member_classNumber, 
			@RequestParam("member_studentNumber") String member_studentNumber,
			@RequestParam("member_name") String member_name,
			@ModelAttribute MemberListVO memberList, Model model) throws Exception {
		logger.info("memberlist...........");
		//logger.info(memberList.toString());
		memberList.setUid("jo");//have to modify
		memberList.setSubjectCode(1);//have to modify
		if(!member_grade.equals(""))
			memberList.setGrade(Integer.parseInt(member_grade));
		if(!member_classNumber.equals(""))
			memberList.setClassNumber(Integer.parseInt(member_classNumber));
		if(!member_studentNumber.equals(""))
			memberList.setStudentNumber(Integer.parseInt(member_studentNumber));
		memberList.setName(member_name);
		//subjectService.listMember2(memberList);
		listMem = subjectService.listMember2(memberList);
		flag =1;
		//model.addAttribute("list", subjectService.listMember2(memberList));
		//model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		return "redirect:/subject/management";
	}
//	@RequestMapping(value = "/management", method = RequestMethod.GET)
//	public void managementGET(
//			@ModelAttribute MemberListVO memberList, Model model) throws Exception {
//		logger.info("memberlist...........");
//		//logger.info(memberList.toString());
//		//memberList.setUid("jo");//have to modify
//		//memberList.setSubjectCode(1);//have to modify
//		//memberList.setGrade(1);
//		//memberList.setClassNumber(2);
//		//memberList.setStudentNumber(2012111975);
//		//memberList.setName("¿ÃøÎ¡ÿ");
//		
//		//subjectService.listMember2(memberList);
//		model.addAttribute("list", subjectService.listMember2(memberList));
//		//model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
//	}
}
