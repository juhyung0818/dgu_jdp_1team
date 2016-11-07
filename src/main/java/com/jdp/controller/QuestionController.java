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

import com.jdp.domain.CheckVO;
import com.jdp.domain.QuestionVO;
import com.jdp.domain.ScoreVO;
import com.jdp.service.QuestionService;
import com.jdp.service.ScoreService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Inject
	private QuestionService questionService;
	@Inject
	private ScoreService scoreService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("examName") String examName,
			@RequestParam("num") int num, Model model){
		
		model.addAttribute("subjectCode", subjectCode);
		model.addAttribute("num", num);
		logger.info("Question Register...");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(@ModelAttribute QuestionVO question) throws Exception{
		logger.info("question register.........");
		questionService.register(question);
		return "redirect:/exam/managementExam?subjectCode="+question.getSubjectCode();
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void read(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName, Model model) throws Exception {
		model.addAttribute("list", questionService.listQuestion(subjectCode, examName));
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String delete(@RequestParam("subjectCode") int subjectCode, 
			@RequestParam("examName") String examName) throws Exception {
		logger.info("subjectCode: " + subjectCode +" examName: " + examName + " delete....");
		questionService.delete(subjectCode, examName);
		return "redirect:/exam/managementExam?subjectCode="+subjectCode;
	}
	
	@RequestMapping(value = "/try", method = RequestMethod.GET)
	public void tryGET(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("examName") String examName, 
			@RequestParam("uid") String uid,
			Model model) throws Exception {
		model.addAttribute("uid", uid);
		model.addAttribute("list", questionService.tryQuestion(subjectCode, examName));
	}
	
	@RequestMapping(value = "/try", method = RequestMethod.POST)
	public void tryPOST(@RequestParam("subjectCode") int subjectCode,
			@RequestParam("examName") String examName,
			@RequestParam("uid") String uid, @ModelAttribute int[] answer,
			Model model) throws Exception {
		ScoreVO score = new ScoreVO();
		score.setSubjectCode(subjectCode);
		score.setExamName(examName);
		score.setUid(uid);
		score.setScore(0);
		List<CheckVO> an = scoreService.answer(subjectCode, examName);
		for(int i=0; i<answer.length; i++){
			if(an.get(i).getAnwser()==answer[i]){
				score.setScore(score.getScore() + an.get(i).getqPoint());
			}
		}
		
		scoreService.register(score);
	}
}