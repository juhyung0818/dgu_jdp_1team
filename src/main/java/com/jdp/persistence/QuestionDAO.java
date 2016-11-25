package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.QuestionVO;

/**
 * Database Access Object
 * interface to access question table in database
 * @author YJH
 * 2016.10.19.Wed
 */

public interface QuestionDAO {
	//insert a question
	public void register(QuestionVO question) throws Exception;
	public void registerList(List<QuestionVO> question) throws Exception;
	//modify a question
	public void update(QuestionVO question) throws Exception;
	//display question list
	public List<QuestionVO> listQuestion(int examCode) throws Exception;
	public List<QuestionVO> tryQuestion(int examCode) throws Exception;
	
 	public void delete(int examCode) throws Exception;
	//all question delete
	public void deleteAll(int subjectCode) throws Exception;

}
