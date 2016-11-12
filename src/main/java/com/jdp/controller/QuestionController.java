package com.jdp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdp.domain.CheckVO;
import com.jdp.domain.QuestionVO;
import com.jdp.domain.ScoreVO;
import com.jdp.domain.UserVO;
import com.jdp.service.QuestionService;
import com.jdp.service.ScoreService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Inject
	private QuestionService questionService;
	@Inject
	private ScoreService scoreService;
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("examName") String examName,
			@RequestParam("num") int num,
			Model model, HttpSession session){
		
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("examName", examName);
		model.addAttribute("num", num);
		model.addAttribute("uname", ((UserVO)session.getAttribute("teacher")).getUname());
		logger.info("Question Register...");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(@RequestParam("subjectCode") int subjectCode, 
							@RequestParam("examName") String examName,
							@RequestBody String question) throws Exception{
		logger.info("question register.........");
		System.out.println(question);
		//parsing part
		List<QuestionVO> list = new ArrayList<QuestionVO>();
		String[] temp = question.split("&question%5B%5D=");
		
		for(int i=0; i<temp.length/8; i++){

			QuestionVO q = new QuestionVO();
			q.setSubjectCode(subjectCode);
			q.setExamName(examName);
			q.setqNumber(Integer.parseInt(temp[i*8+1]));
			q.setqPoint(Integer.parseInt(temp[i*8+2]));
			q.setAnswer(Integer.parseInt(temp[i*8+3]));
			q.setqInfo(temp[i*8+4]);
			q.setEx1(temp[i*8+5]);
			q.setEx2(temp[i*8+6]);
			q.setEx3(temp[i*8+7]);
			q.setEx4(temp[i*8+8]);
			//
			list.add(q);
		}
		//insert questions
		questionService.registerList(list);
		
		return "redirect:/exam/managementExam?subjectCode="+subjectCode;
	}	
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void read(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName, Model model, HttpSession session) throws Exception {
		 List<QuestionVO> list = questionService.listQuestion(subjectCode, examName);
		model.addAttribute("list",list);
		model.addAttribute("uname", ((UserVO)session.getAttribute("teacher")).getUname());
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("examName", examName);
		model.addAttribute("num", list.size());
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName) throws Exception {
		logger.info("subjectCode: " + subjectCode +" examName: " + examName + " delete....");
		questionService.delete(subjectCode, examName);
		return "redirect:/exam/managementExam?subjectCode="+subjectCode;
	}
	
	@RequestMapping(value = "/try", method = RequestMethod.GET)
	public void tryGET(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("examName") String examName, 
			Model model, 
			HttpSession session)throws Exception {
		logger.info("- try question GET......");
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("examName", examName);
		model.addAttribute("list", questionService.tryQuestion(subjectCode, examName));
		model.addAttribute("size", questionService.tryQuestion(subjectCode, examName).size()+1);
		model.addAttribute("uname", ((UserVO)session.getAttribute("student")).getUname());
	}
	
	@RequestMapping(value = "/try", method = RequestMethod.POST)
	public String tryPOST(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("examName") String examName,
			@RequestBody String answer, 
			Model model, HttpSession session) throws Exception {
		String uid = ((UserVO)session.getAttribute("student")).getUid();

		logger.info(uid + "- try question POST.....");
		ScoreVO score = new ScoreVO();
		score.setSubjectCode(subjectCode);
		score.setExamName(examName);
		score.setUid(uid);
		score.setScore(0);
		
		//parsing part
		String[] stAnswer = answer.split("&answer=");
		int[] stAns = new int[stAnswer.length-1]; 
		for(int i=0; i<stAnswer.length; i++){
			if(i>0){
				stAns[i-1] = Integer.parseInt(stAnswer[i]);
			}
		}
		
		//score calculation
		List<CheckVO> an = scoreService.answer(subjectCode, examName);
		for(int i=0; i<stAns.length; i++){
			if(an.get(i).getAnwser()==stAns[i]){
				score.setScore(score.getScore() + an.get(i).getqPoint());
			}
		}
		
		//insert score
		scoreService.register(score);
		return "redirect:/exam/studentExam?subjectCode="+subjectCode;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyQuestion(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("examName") String examName, 
			Model model, 
			@RequestBody String question, RedirectAttributes rttr,
			HttpSession session)throws Exception {

		System.out.println("modify post....");

		//parsing part
		List<QuestionVO> list = new ArrayList<QuestionVO>();
		String[] temp = question.split("&question%5B%5D=");
		for(int i=0; i<temp.length/8; i++){

			QuestionVO q = new QuestionVO();
			q.setSubjectCode(subjectCode);
			q.setExamName(examName);
			q.setqNumber(Integer.parseInt(temp[i*8+1]));
			q.setqPoint(Integer.parseInt(temp[i*8+2]));
			q.setAnswer(Integer.parseInt(temp[i*8+3]));
			q.setqInfo(temp[i*8+4]);
			q.setEx1(temp[i*8+5]);
			q.setEx2(temp[i*8+6]);
			q.setEx3(temp[i*8+7]);
			q.setEx4(temp[i*8+8]);
			//
			list.add(q);
		}
		//modify questions
		questionService.update(list);
	    rttr.addAttribute("subjectCode", subjectCode);
		return "redirect:/exam/managementExam";
	}
}