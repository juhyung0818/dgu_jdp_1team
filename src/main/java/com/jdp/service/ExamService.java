package com.jdp.service;

import java.util.List;

import com.jdp.domain.ExamVO;
import com.jdp.domain.QuestionVO;

/**
 * Service interface about Exam
 * @author YJH
 * 2016.10.24.Wed
 */
public interface ExamService {

	//insert a exam
	public void register(ExamVO exam) throws Exception; 
	//remove a exam
	public void delete(int subjectCode, String examName) throws Exception; 
	//modify startTime, endTime, exam name
	public void update(ExamVO exam) throws Exception;
	//display exam list
	public List<ExamVO> examList(int subjectCode) throws Exception;
}
