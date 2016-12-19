package com.jdp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdp.domain.ExamVO;
import com.jdp.domain.ScoreExamVO;
import com.jdp.domain.ScoreVO;
import com.jdp.domain.UserVO;
import com.jdp.service.ExamService;
import com.jdp.service.ScoreService;
import com.jdp.service.SubjectService;

/**
 * controller of teacher and students about exam
 * 
 * @author YJH 2016.10.19.Wed
 */

@Controller
@RequestMapping("/exam/*")
public class ExamController {

	@Inject
	private ExamService examService;
	@Inject
	private ScoreService scoreService;
	@Inject
	private SubjectService subjectService;
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode, HttpSession session, Model model) {
		model.addAttribute("uname", ((UserVO)session.getAttribute("teacher")).getUname());
		logger.info("question register");
		model.addAttribute("subjectCode", subjectCode);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName, 
			@RequestParam("num") int num, 
			@RequestParam("startTime") String startTime, 
			@RequestParam("endTime") String endTime, HttpSession session, RedirectAttributes rttr,
			Model model) throws Exception {
		logger.info("exam register.........");
		
		ExamVO exam=new ExamVO();
		exam.setSubjectCode(subjectCode);
		exam.setExamName(examName);
		
		exam.setStartTime(Timestamp.valueOf(startTime+":00"));//for matching format
		exam.setEndTime(Timestamp.valueOf(endTime+":00"));//for matching format
		examService.register(exam);
		int examCode = examService.getExamCode(subjectCode, examName);
		model.addAttribute("uname", ((UserVO)session.getAttribute("teacher")).getUname());
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		rttr.addAttribute("examCode", examCode);
		rttr.addAttribute("num", num);
		return "redirect:/question/register";
	}

	@RequestMapping(value = "/managementExam", method = RequestMethod.GET)
	public void managementExamGET(@RequestParam("subjectCode") int subjectCode, Model model, HttpSession session) throws Exception {
		logger.info("subjectCode : " + subjectCode + "examList");
		int flag = 1; //teacher flag is 1(one)
		UserVO user = ((UserVO)session.getAttribute("teacher"));
		model.addAttribute("list", examService.examList(subjectCode, user.getUid(), flag));
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		model.addAttribute("uname", user.getUname());
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String managementExamPOST(@RequestParam("examCode") int examCode,
			RedirectAttributes rttr) throws Exception {
		logger.info("examCode : " + examCode);
		int subjectCode = examService.getSubjectCode(examCode);
		examService.delete(examCode);
		rttr.addAttribute("subjectCode", subjectCode);
		return "redirect:/exam/managementExam";
	}
	
	@RequestMapping(value = "/studentExam", method = RequestMethod.GET)
	public void studentExamGET(@RequestParam("subjectCode") int subjectCode,
			Model model, HttpSession session) throws Exception {
		logger.info("student Exam subjectCode : " + subjectCode + " examList");
		
		int flag = 0; //student flag is 0(zero)
		UserVO user = new UserVO();
		user = (UserVO)session.getAttribute("student");
		
		List<ExamVO> examList = examService.examList(subjectCode, user.getUid(), flag);
		List<ScoreVO> scoreList = scoreService.scoreList(subjectCode, user.getUid());
		
		List<ScoreExamVO> list = new ArrayList<>();
		// examList.size() >= scoreList
		for(int i=0; i<examList.size(); i++){

			ScoreExamVO temp = new ScoreExamVO();
			temp.setExamName(examList.get(i).getExamName());
			temp.setExamCode(examList.get(i).getExamCode());
			temp.setStartTime(examList.get(i).getStartTime()); //start time
			temp.setEndTime(examList.get(i).getEndTime()); // end time
			temp.setScore(-1);
			
			//case : no time to exam
			if(examService.checkTime(examList.get(i).getExamCode())==0){
				temp.setScore(-2);
			}
			//case : time to exam but not take a exam yet
			else{
				temp.setScore(-1);
			}
			//score for each exams
			for(int j=0; j<scoreList.size(); j++){
				if(examList.get(i).getExamCode() == scoreList.get(j).getExamCode()){
					temp.setScore(scoreList.get(j).getScore());
				}
			}
			list.add(temp);
		}

		//initialization
		//path : you have to take a exam with 'try' button
		//       must not to directly enter page that take a exam. 
		session.setAttribute("path",false);

		model.addAttribute("uid", user.getUid());
		
		model.addAttribute("list", list);
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		model.addAttribute("uname", user.getUname());
		
	}


	@RequestMapping(value ="/studentExamPost", method = RequestMethod.POST)
	public void studentExamPOST(
			@RequestParam("examCode") int examCode,
			Model model, HttpSession session) throws Exception {
		//if score is not null, then you took a exam before
		//if not, you didn't take a exam
		ScoreVO score=scoreService.checkIsTry(examCode, ((UserVO)session.getAttribute("student")).getUid());
		
		//for using ExamInterceptor
		model.addAttribute("scoreVO", score);
		model.addAttribute("currentExamCode", examCode);
	}
	

	/**
	 * exam information update
	 * Method : GET
	 * @param subjectCode : key of subject
	 * @param examName
	 * @param session : login session
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void examModifyGET(@RequestParam("examCode") int examCode,
			HttpSession session, Model model) throws Exception{
		model.addAttribute("uname", ((UserVO)session.getAttribute("teacher")).getUname());
		ExamVO exam = examService.getExam(examCode);
		System.out.println(exam.toString());
		model.addAttribute("subjectCode", examService.getSubjectCode(examCode));
		model.addAttribute("examName", exam.getExamName());
		model.addAttribute("startTime", exam.getStartTime());
		model.addAttribute("endTime", exam.getEndTime());
	}
	
	/**
	 * exam information update
	 * Method : POST
	 * @param subjectCode
	 * @param examName
	 * @param exam
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String examModifyPOST(ExamVO exam, RedirectAttributes rttr) throws Exception{
		logger.info(exam.toString());
		examService.update(exam);
	    rttr.addAttribute("subjectCode", exam.getSubjectCode());
		return "redirect:/exam/managementExam";
	}
	
}
