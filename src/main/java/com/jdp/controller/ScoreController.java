package com.jdp.controller;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdp.domain.CheckVO;
import com.jdp.domain.MemberListVO;
import com.jdp.domain.UserVO;
import com.jdp.domain.QuestionVO;
import com.jdp.domain.ScoreVO;
import com.jdp.service.QuestionService;
import com.jdp.service.ScoreService;
import com.jdp.service.SubjectService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	private List<MemberListVO> listMem;
	private int flag=0;
	@Inject
	private ScoreService scoreService;
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public void managementGET(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("subjectName") String subjectName,
			@ModelAttribute MemberListVO memberList, Model model, HttpSession session) throws Exception {
		logger.info("Student Subject Register...");
		UserVO user = new UserVO();
		user = (UserVO)session.getAttribute("teacher");
		
		if(flag==0){
			listMem=scoreService.listMember(user.getUid(), subjectCode);
		} 
		model.addAttribute("uname", user.getUname());
		model.addAttribute("list", listMem);
		model.addAttribute("subjectName", subjectName);
		flag =0;
	}
	
	@RequestMapping(value = "/management", method = RequestMethod.POST)
	public String managementPOST(@RequestParam("member_grade") String member_grade, 
			@RequestParam("member_classNumber") String member_classNumber, 
			@RequestParam("member_studentNumber") String member_studentNumber,
			@RequestParam("member_uname") String member_uname,
			@ModelAttribute MemberListVO memberList, Model model) throws Exception {
		logger.info("memberlist...........");
		memberList.setUid("jo");//have to modify
		memberList.setSubjectCode(1);//have to modify
		if(!member_grade.equals(""))
			memberList.setGrade(Integer.parseInt(member_grade));
		if(!member_classNumber.equals(""))
			memberList.setClassNumber(Integer.parseInt(member_classNumber));
		if(!member_studentNumber.equals(""))
			memberList.setStudentNumber(Integer.parseInt(member_studentNumber));
		memberList.setUname(member_uname);
		listMem = scoreService.listMember2(memberList);
		flag =1;
		
		return "redirect:/score/management";
	}

}
