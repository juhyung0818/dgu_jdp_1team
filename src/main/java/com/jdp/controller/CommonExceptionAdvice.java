package com.jdp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jdp.exception.DuplicationExamException;
import com.jdp.exception.InvalidTypeException;
import com.jdp.exception.NotAuthoriedException;
import com.jdp.exception.NotAuthoritySubject;
import com.jdp.exception.NotExistException;
import com.jdp.exception.PrimaryKeyDuplicatedException;
import com.jdp.exception.SubjectNameNotExistException;

/**
 * Advice class for Exception handler
 * @author YJH
 * 2016.11.20.Sun
 */

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/error_common");
		modelAndView.addObject("exception", e);

		return modelAndView;
	}

	@ResponseBody
	@ExceptionHandler(PrimaryKeyDuplicatedException.class)
	public ModelAndView highfiveException(PrimaryKeyDuplicatedException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/primary_key_duplication");
		modelAndView.addObject("exception", e);

		return modelAndView;
	}

	@ResponseBody
	@ExceptionHandler(InvalidTypeException.class)
	public ModelAndView invalidFormatException(InvalidTypeException e) {

		logger.error(e.getMessage(), e.getStackTrace());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/error_common");
		modelAndView.addObject("exception", e);

		return modelAndView;

	}

	@ResponseBody
	@ExceptionHandler(NotExistException.class)
	public ModelAndView notExistException(NotExistException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/error_common");
		modelAndView.addObject("exception", e);

		return modelAndView;
	}

	@ResponseBody
	@ExceptionHandler(NotAuthoriedException.class)
	public ModelAndView notAuthoriedException(NotAuthoriedException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/error_common");
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	@ResponseBody
	@ExceptionHandler(NotAuthoritySubject.class)
	public ModelAndView notAuthoritySubject(NotAuthoritySubject e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/not_authority_subject");
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}

	//Duplication key of table
	@ResponseBody
	@ExceptionHandler(PrimaryKeyDuplicatedException.class)
	public ModelAndView primaryKeyDuplicatedException(PrimaryKeyDuplicatedException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/primary_key_duplication");
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
		modelAndView.setViewName("/exception/duplication_exam");
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	//subject name invalid
	@ResponseBody
	@ExceptionHandler(SubjectNameNotExistException.class)
	public ModelAndView subjectNameNotExistException(SubjectNameNotExistException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/subject_name_not_exist");
		modelAndView.addObject("exception", e);
		modelAndView.addObject("code", e.getExceptionCode());


		return modelAndView;
	}
}
