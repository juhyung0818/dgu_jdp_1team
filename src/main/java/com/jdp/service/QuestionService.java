package com.jdp.service;

import java.util.List;

import com.jdp.domain.QuestionVO;

public interface QuestionService {

	//insert a question
	public void register(QuestionVO question) throws Exception;
	//modify a question
	public void update(QuestionVO question) throws Exception;
	//display question list
	public List<QuestionVO> questionList(QuestionVO question) throws Exception;

}
