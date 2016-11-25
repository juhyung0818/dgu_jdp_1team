package com.jdp.service;

import java.util.List;

import com.jdp.domain.QuestionVO;

/**
 * interface of question for service
 * @author YJH
 * 2016.10.24.Mon
 */
public interface QuestionService {

	//insert a question
	public void register(QuestionVO question) throws Exception;
	public void registerList(List<QuestionVO> question) throws Exception;
	//modify a question
	public void update(List<QuestionVO> question) throws Exception;
	//display question list
	public List<QuestionVO> listQuestion(int subjectCode, String examName) throws Exception;
	public List<QuestionVO> tryQuestion(int subjectCode, String examName) throws Exception;
	//subject leave
	public void delete(int subjectCode, String examName) throws Exception;
}
