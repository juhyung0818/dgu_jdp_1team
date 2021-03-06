package com.jdp.controller;
import java.util.ArrayList;
import java.util.List;

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

import com.jdp.domain.AverageVO;
import com.jdp.domain.ExamVO;
import com.jdp.domain.MemberListVO;
import com.jdp.domain.ScoreVO;
import com.jdp.domain.UserVO;
import com.jdp.service.ExamService;
import com.jdp.service.ScoreService;
import com.jdp.service.SubjectService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	private List<MemberListVO> listMem;
	private List<ExamVO> listExam;
	private List<ScoreVO> listScore;
	private List<AverageVO> listAverage;
	private int flag=0;
	
	@Inject
	private ScoreService scoreService;
	@Inject
	private SubjectService subjectService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public void managementGET(@RequestParam("subjectCode") int subjectCode,
			@ModelAttribute MemberListVO memberList, Model model, HttpSession session) throws Exception {
		
		logger.info("Student Subject Register...");
		UserVO user = new UserVO();
		user = (UserVO)session.getAttribute("teacher");
		int sum =0;
		if(flag==0){
			listMem=scoreService.listMember(user.getUid(), subjectCode);
			listExam=scoreService.listExam(subjectCode);
			listAverage = new ArrayList<AverageVO>();
			
			//initialize listAverage
			for(int i=0;i<listExam.size();i++){
				AverageVO averageVO = new AverageVO();
				averageVO.setSomeAvg(0);
				averageVO.setAllAvg(0);
				listAverage.add(averageVO);
			}
			
			//get each student's average
			for(int i=0;i<listMem.size();i++){				
				//get each student's score
				listScore = scoreService.readScore(subjectCode,listMem.get(i).getUid());
				
				for(int j=0;j<listExam.size();j++){
					try {
						
						if(listScore.get(j).getScore()>0){
							sum += listScore.get(j).getScore();
						}
					} catch (Exception e) {
						
						//1. 어떤 경우에 예외가 발생하는 거지?
						ScoreVO temp=new ScoreVO();
						temp.setUid(user.getUid());
						temp.setScore(0);
						listScore.add(temp);
					}
					double tmp=listAverage.get(j).getAllAvg();
					listAverage.get(j).setAllAvg(tmp+=listScore.get(j).getScore());
				}
				
				listMem.get(i).setScoreList(listScore);
				listMem.get(i).setAverage((double)sum/(double)listScore.size());
				sum=0;
			}
			
			//get all student's average
			for(int i=0;i<listExam.size();i++){	
				listAverage.get(i).setAllAvg(listAverage.get(i).getAllAvg()/(double)listMem.size());
			}
		}
		
		model.addAttribute("listExam",listExam);
		model.addAttribute("uname", user.getUname());
		model.addAttribute("list", listMem);
		model.addAttribute("subjectName", subjectService.getSubjectName(subjectCode));
		model.addAttribute("averageVO", listAverage);
		flag =0;
	}
	
	@RequestMapping(value = "/management", method = RequestMethod.POST)
	public String managementPOST(
			@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("member_grade") String member_grade, 
			@RequestParam("member_classNumber") String member_classNumber, 
			@RequestParam("member_studentNumber") String member_studentNumber,
			@RequestParam("member_uname") String member_uname,
			@ModelAttribute MemberListVO memberList, Model model, HttpSession session) throws Exception {
		
		logger.info("memberlist...........");
		int sum =0;
		
		UserVO user = new UserVO();
		user = (UserVO)session.getAttribute("teacher");
		
		memberList.setUid(user.getUid());//have to modify
		
		if(!member_grade.equals(""))
			memberList.setGrade(Integer.parseInt(member_grade));
		if(!member_classNumber.equals(""))
			memberList.setClassNumber(Integer.parseInt(member_classNumber));
		if(!member_studentNumber.equals(""))
			memberList.setStudentNumber(Integer.parseInt(member_studentNumber));
		memberList.setUname(member_uname);

		listMem = scoreService.listMember2(memberList);
		listExam=scoreService.listExam(subjectCode);
		
		//initialize listExam
		for(int i=0;i<listExam.size();i++){
			listAverage.get(i).setSomeAvg(0);
		}
		
		
		for(int i=0;i<listMem.size();i++){
			listScore = scoreService.readScore(subjectCode,listMem.get(i).getUid());
			for(int j=0;j<listExam.size();j++){
				try {
					if(listScore.get(j).getScore()>0){
					sum += listScore.get(j).getScore();
					}
				} catch (Exception e) {
					ScoreVO temp=new ScoreVO();
					temp.setUid(user.getUid());
					temp.setScore(0);
					listScore.add(temp);
				}
				double tmp = listAverage.get(j).getSomeAvg();
				listAverage.get(j).setSomeAvg(tmp+=listScore.get(j).getScore());
			}
			
			listMem.get(i).setScoreList(listScore);
			listMem.get(i).setAverage((double)sum/(double)listScore.size());
			sum=0;
		}
		for(int i=0;i<listExam.size();i++){	
			listAverage.get(i).setSomeAvg(listAverage.get(i).getSomeAvg()/(double)listMem.size());
		}
		flag =1;
		
		return "redirect:/score/management?subjectCode="+subjectCode;
	}

}
