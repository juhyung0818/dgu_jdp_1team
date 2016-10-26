package com.jdp.service;

import java.util.List;

import com.jdp.domain.ExamVO;
import com.jdp.domain.QuestionVO;

/**
 * interface of exam for exam
 * @author YJH
 * 2016.10.24.Mon
 */
public interface ExamService {

	//insert a exam
	public void register(ExamVO exam) throws Exception; 
	//remove a exam
	public void delete(ExamVO exam) throws Exception; 
	//modify startTime, endTime, exam name
	public void update(ExamVO exam) throws Exception;
	//display exam list
	public List<ExamVO> examList(ExamVO exam) throws Exception;
	//display one exam
	public List<QuestionVO> read(ExamVO exam) throws Exception;	
}
