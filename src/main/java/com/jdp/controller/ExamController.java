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
import org.springframework.web.bind.annotation.RequestBody;
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
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode) {
		logger.info("question register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName, 
			@RequestParam("num") int num, 
			@ModelAttribute ExamVO exam, Model model) throws Exception {
		logger.info("exam register.........");
		logger.info(exam.toString());
		exam.setSubjectCode(subjectCode);
		exam.setExamName(examName);
		examService.register(exam);
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		return "redirect:/question/register?subjectCode="+subjectCode+"&examName="+examName+"&num="+num;
	}

	@RequestMapping(value = "/managementExam", method = RequestMethod.GET)
	public void managementExamGET(@RequestParam("subjectCode") int subjectCode, Model model) throws Exception {
		logger.info("subjectCode : " + subjectCode + "examList");
		model.addAttribute("list", examService.examList(subjectCode));
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String managementExamPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName,
			RedirectAttributes rttr) throws Exception {
		logger.info("subjectCode: " + subjectCode +" examName: " + examName + " delete....");
//		questionService.delete(subjectCode, examName);
		examService.delete(subjectCode, examName);
	    rttr.addAttribute("subjectCode", subjectCode);
	    rttr.addAttribute("examName", examName);
		return "redirect:/exam/managementExam";
	}
	
	@RequestMapping(value = "/studentExam", method = RequestMethod.GET)

	public void studentExamGET(@RequestParam("subjectCode") int subjectCode,
			Model model, HttpSession session) throws Exception {
		logger.info("subjectCode : " + subjectCode + " examList");
		UserVO user = new UserVO();
		user = (UserVO)session.getAttribute("student");

		List<ExamVO> examList = examService.examList(subjectCode);
		List<ScoreVO> scoreList = scoreService.myScore(subjectCode, user.getUid());
		
		List<ScoreExamVO> list = new ArrayList<>();

		// examList.size() >= scoreList
		for(int i=0; i<examList.size(); i++){

			ScoreExamVO temp = new ScoreExamVO();
			temp.setSubjectCode(examList.get(i).getSubjectCode()); // subject code
			temp.setExamName(examList.get(i).getExamName()); // exam name
			temp.setStartTime(examList.get(i).getStartTime()); //start time
			temp.setEndTime(examList.get(i).getEndTime()); // end time
			temp.setScore(-1);
			
			//score for each exams
			for(int j=0; j<scoreList.size(); j++){
				if(examList.get(i).getSubjectCode() == scoreList.get(j).getSubjectCode()
						&& examList.get(i).getExamName().equals(scoreList.get(j).getExamName())){
					temp.setScore(scoreList.get(j).getScore());
				}

			}
			list.add(temp);
		}
		
		//check whether take exam or doesn't
		model.addAttribute("isTry", scoreService.check(user.getUid()));
		
		model.addAttribute("uid", user.getUid());
		
		model.addAttribute("list", list);
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("subjectName", examService.getSubjectName(subjectCode));
		model.addAttribute("uname", user.getUname());
	}
	
	@RequestMapping(value = "/studentExam", method = RequestMethod.POST)
	public String studentExamPOST(@RequestParam("subjectCode") int subjectCode, 
			@RequestBody String examName,
			Model model, HttpSession session) throws Exception {
		
		model.addAttribute("subjectCode", subjectCode);


		String[] exam = examName.split("&examName%5B%5D=");

		for(int i=0; i<exam.length; i++){
			System.out.println(exam[i]);
		}
		return "redirect:/question/try?subjectCode="+subjectCode+"&examName="+exam[0];
	}
	
}
