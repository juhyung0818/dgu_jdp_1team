package com.jdp.controller;

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
import com.jdp.service.ExamService;

/**
 * controller of teacher and students about exam
 * 
 * @author YJH 2016.10.19.Wed
 */

@Controller //get, post, put, patch
@RequestMapping("/exam")
public class ExamController {

	@Inject
	private ExamService examService;

	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(ExamVO exam, Model model) {
		logger.info("question register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(@ModelAttribute ExamVO exam) throws Exception {
		logger.info("exam register.........");
		logger.info(exam.toString());
		examService.register(exam);
		return "question/register";
	}

	// TODO subject code....
	@RequestMapping(value = "/managementExam", method = RequestMethod.GET)
	public void managementExamGET(Model model) throws Exception {
		logger.info("subjectCode : " + "" + "examList");
		model.addAttribute("list", examService.examList(100));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("subjectCode") int subjectCode, 
						@RequestParam("examName") String examName) throws Exception {
		logger.info("subjectCode: " + subjectCode +" examName: " + examName + " delete....");
		examService.delete(subjectCode, examName);
//		return "redirect:/exam/managementExam";
		return "hello";
	}
	
//	  @RequestMapping(value = "/list/{subjectCode}", method = RequestMethod.GET)
//	  public ResponseEntity<List<ExamVO>> list(@PathVariable("subjectCode") Integer subjectCode) {
//		  
//		  logger.info("exam list.....");
//	    ResponseEntity<List<ExamVO>> entity = null;
//	    try {
//	      entity = new ResponseEntity<>(examService.examList(subjectCode), HttpStatus.OK);
//
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	    }
//
//	    return entity;
//	  }


}
