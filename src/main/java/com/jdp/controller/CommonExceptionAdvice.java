package com.jdp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jdp.exception.DuplicationExamException;
import com.jdp.exception.DuplicationIdException;
import com.jdp.exception.ExamException;
import com.jdp.exception.InvalidTypeException;
import com.jdp.exception.NotAccessExamException;
import com.jdp.exception.NotAccessSubjectException;
import com.jdp.exception.NotExistExamException;
import com.jdp.exception.NotExistExamNameException;
import com.jdp.exception.NotExistException;
import com.jdp.exception.NotExistSubjectException;
import com.jdp.exception.NotExistSubjectNameException;
import com.jdp.exception.PrimaryKeyDuplicatedException;
import com.jdp.exception.TimeOutException;
import com.jdp.exception.TookExamException;

/**
 * Advice class for Exception handler
 * @author YJH
 * 2016.11.20.Sun
 */

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	private String exceptionView = "/exception/error";

	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/error_common");
		modelAndView.addObject("exception", e);

		return modelAndView;
	}


	@ResponseBody
	@ExceptionHandler(ExamException.class)
	public ModelAndView examException(ExamException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/error_common");
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}

	@ResponseBody
	@ExceptionHandler(InvalidTypeException.class)
	public ModelAndView invalidFormatException(InvalidTypeException e) {

		logger.error(e.getMessage(), e.getStackTrace());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;

	}
	
	/* duplicated exceptions */
	//Duplication key of table
	@ResponseBody
	@ExceptionHandler(PrimaryKeyDuplicatedException.class)
	public ModelAndView primaryKeyDuplicatedException(PrimaryKeyDuplicatedException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	//Duplication uid 
	@ResponseBody
	@ExceptionHandler(DuplicationIdException.class)
	public ModelAndView duplicationIdException(DuplicationIdException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	//exam name already exist
	@ResponseBody
	@ExceptionHandler(DuplicationExamException.class)
	public ModelAndView duplicationExamException(DuplicationExamException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	/* not access exceptions */
	//user is not access subject
	@ResponseBody
	@ExceptionHandler(NotAccessSubjectException.class)
	public ModelAndView notAccessSubjectException(NotAccessSubjectException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	//user is not access exam
	@ResponseBody
	@ExceptionHandler(NotAccessExamException.class)
	public ModelAndView notAccessExamException(NotAccessExamException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	/* not exist exceptions */
	//exam name is not exist
	@ResponseBody
	@ExceptionHandler(NotExistExamNameException.class)
	public ModelAndView notExistExamNameException(NotExistExamNameException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	//subject name is not exist
	@ResponseBody
	@ExceptionHandler(NotExistSubjectNameException.class)
	public ModelAndView notExistSubjectNameException(NotExistSubjectNameException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	
	//exam is not exist
	@ResponseBody
	@ExceptionHandler(NotExistExamException.class)
	public ModelAndView notExistExamException(NotExistExamException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	
	//subject is not exist
	@ResponseBody
	@ExceptionHandler(NotExistSubjectException.class)
	public ModelAndView notExistSubjectException(NotExistException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}

	//not exist ~
	@ResponseBody
	@ExceptionHandler(NotExistException.class)
	public ModelAndView notExistException(NotExistException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	/* time check exception */
	//check time can view question or not
	@ResponseBody
	@ExceptionHandler(TimeOutException.class)
	public ModelAndView timeOutException(TimeOutException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	/* not authority exam */
	//alreay took exam 
	@ResponseBody
	@ExceptionHandler(TookExamException.class)
	public ModelAndView tookExamException(TookExamException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(exceptionView);
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode().getClass());

		return modelAndView;
	}

}
