package com.jdp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
import com.jdp.domain.ExamVO;
import com.jdp.domain.QuestionVO;
import com.jdp.domain.ScoreVO;
import com.jdp.domain.UserVO;
import com.jdp.service.ExamService;
import com.jdp.service.QuestionService;
import com.jdp.service.ScoreService;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Inject
	private QuestionService questionService;
	@Inject
	private ExamService examService;
	@Inject
	private ScoreService scoreService;

	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@RequestParam("examCode") int examCode,
			@RequestParam("num") int num, Model model,
			HttpSession session) throws Exception {
		
		logger.info("Question Register GETGETGET...");
		model.addAttribute("subjectCode",examService.getSubjectCode(examCode));
		model.addAttribute("examCode", examCode);
		model.addAttribute("num", num);
		model.addAttribute("uname", ((UserVO) session.getAttribute("teacher")).getUname());
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(@RequestParam("examCode") int examCode, @RequestBody String question, 
			RedirectAttributes rttr, HttpServletRequest request) throws Exception{
		logger.info("question register postpostpost.........");
		System.out.println(question);
		
		request.setCharacterEncoding("utf8");
		
		//parsing part
		List<QuestionVO> list = new ArrayList<QuestionVO>();
		String[] temp = question.split("&question%5B%5D=");
		
		for(int i=0; i<temp.length/8; i++){

			QuestionVO q = new QuestionVO();
			q.setExamCode(examCode);
			q.setqNumber(Integer.parseInt(temp[i*8+1]));
			q.setqPoint(Integer.parseInt(temp[i*8+2]));
			q.setAnswer(Integer.parseInt(temp[i*8+3]));
			q.setqInfo(temp[i*8+4]);
			q.setEx1(temp[i*8+5]);
			q.setEx2(temp[i*8+6]);
			q.setEx3(temp[i*8+7]);
			q.setEx4(temp[i*8+8]);
			list.add(q);
		}
		//insert questions
		questionService.registerList(list);

		rttr.addAttribute("subjectCode", examService.getSubjectCode(examCode));
		return "redirect:/exam/managementExam";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void read(@RequestParam("examCode") int examCode, Model model, HttpSession session, RedirectAttributes rttr)
			throws Exception {
		List<QuestionVO> list = questionService.listQuestion(examCode);
		ExamVO exam = examService.getExam(examCode);

		model.addAttribute("list", list);
		model.addAttribute("examCode", examCode);
		model.addAttribute("uname", ((UserVO) session.getAttribute("teacher")).getUname());
		model.addAttribute("subjectCode", examService.getSubjectCode(examCode));
		model.addAttribute("examName", exam.getExamName());
		model.addAttribute("num", list.size());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("examCode") int examCode, RedirectAttributes rttr) throws Exception {
		int subjectCode = examService.getSubjectCode(examCode);
		logger.info("subjectCode: " + subjectCode + " examCode: " + examCode + " delete....");
		questionService.delete(examCode);
		rttr.addAttribute("subjectCode", subjectCode);
		return "redirect:/exam/managementExam";
	}

	/**
	 * exam try to student Method : GET
	 * 
	 * @param subjectCode
	 * @param examName
	 * @param model
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/try", method = RequestMethod.GET)
	public void tryGET(@RequestParam("examCode") int examCode, Model model, HttpSession session) throws Exception {
		logger.info("- try question GET......");
		UserVO user = new UserVO();
		user = (UserVO) session.getAttribute("student");

		int time=examService.checkTime(examCode);
		
		//case : time to take a exam
		if( time!=0)
		{
			ExamVO exam = examService.getExam(examCode);
			model.addAttribute("subjectCode", examService.getSubjectCode(examCode));
			model.addAttribute("examName", exam.getExamName());
			model.addAttribute("list", questionService.tryQuestion(examCode));
			model.addAttribute("size", questionService.tryQuestion(examCode).size() + 1);
			model.addAttribute("uname", ((UserVO) session.getAttribute("student")).getUname());
		}
		else
		{
			model.addAttribute("examActive", false);
		}
		
		// for incorrect access
		model.addAttribute("path", ((boolean) session.getAttribute("path")));
		model.addAttribute("deniedURL", ((String) session.getAttribute("deniedURL")));
	}

	/**
	 * student try exam
	 * 
	 * @param subjectCode
	 * @param examCode
	 * @param answer
	 * @param rttr
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/try", method = RequestMethod.POST)
	public String tryPOST(@RequestParam("examCode") int examCode, @RequestBody String answer, RedirectAttributes rttr,
			Model model, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("student");

		logger.info(user.getUid() + "- try question POST.....");
		ScoreVO score = new ScoreVO();
		score.setExamCode(examCode);
		score.setUid(user.getUid());
		score.setScore(0);
		
		logger.info(answer);

		// parsing part
		String[] stAnswer = answer.split("&answer="); //student's answer
		int[] stAns = new int[stAnswer.length - 1]; //student's answer parsing
		for (int i = 0; i < stAnswer.length; i++) {
			if (i > 0) {
				stAns[i - 1] = Integer.parseInt(stAnswer[i]);
			}
		}

		// score calculation
		List<CheckVO> an = scoreService.answer(examCode); //real answer
		for (int i = 0; i < stAns.length; i++) {
			if (an.get(i).getAnwser() == stAns[i]) {
				score.setScore(score.getScore() + an.get(i).getqPoint());
			}
		}

		// insert score
		scoreService.register(score);
		rttr.addAttribute("subjectCode", examService.getSubjectCode(examCode));
		return "redirect:/exam/studentExam";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyQuestion(@RequestParam("examCode") int examCode, Model model, @RequestBody String question,
			RedirectAttributes rttr, HttpSession session) throws Exception {

		System.out.println("modify post....");

		// parsing part
		List<QuestionVO> list = new ArrayList<QuestionVO>();
		String[] temp = question.split("&question%5B%5D=");
		for (int i = 0; i < temp.length / 8; i++) {

			QuestionVO q = new QuestionVO();
			q.setExamCode(examCode);
			q.setqNumber(Integer.parseInt(temp[i * 8 + 1]));
			q.setqPoint(Integer.parseInt(temp[i * 8 + 2]));
			q.setAnswer(Integer.parseInt(temp[i * 8 + 3]));
			q.setqInfo(temp[i * 8 + 4]);
			q.setEx1(temp[i * 8 + 5]);
			q.setEx2(temp[i * 8 + 6]);
			q.setEx3(temp[i * 8 + 7]);
			q.setEx4(temp[i * 8 + 8]);
			//
			list.add(q);
		}
		// modify questions
		questionService.update(list);
		rttr.addAttribute("subjectCode", examService.getSubjectCode(examCode));
		return "redirect:/exam/managementExam";
	}

}