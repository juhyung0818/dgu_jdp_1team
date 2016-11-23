package com.jdp.service;

import java.util.List;

import com.jdp.domain.ExamVO;


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
	public void update(ExamVO exam, String newName) throws Exception;
	//display exam list
	public List<ExamVO> examList(int subjectCode) throws Exception;
	
	public String getSubjectName(int subjectCode) throws Exception;
	//get exam infomation
	public ExamVO getExam(int subjectCode, String examName) throws Exception;
	
	
	public void update(ExamVO exam) throws Exception;
	/**
	 * it's time to able to take a exam or not
	 * @param subjectCode
	 * @param examName
	 * @return if start time <= current time <= end time, return examVO. if not, return null.
	 * @throws Exception
	 */
	public ExamVO checkTime(int subjectCode, String examName) throws Exception;
}
