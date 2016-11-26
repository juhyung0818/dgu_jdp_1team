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
	public void delete(int examCode) throws Exception;
	//removu all exams
	public void deleteAll(int subjectCode) throws Exception;
	//modify startTime, endTime, exam name
	public void update(ExamVO exam) throws Exception;
	//display exam list
	public List<ExamVO> examList(int subjectCode) throws Exception;
	public String getSubjectName(int subjectCode) throws Exception;
	//get exam information
	public ExamVO getExam(int examCode) throws Exception;
	/**
	 * it's time to able to take a exam or not
	 * @param subjectCode
	 * @param examName
	 * @return if start time <= current time <= end time, return examVO. if not, return null.
	 * @throws Exception
	 */
	public ExamVO checkTime(int examCode) throws Exception;
	//return subject code of exam
	public int getSubjectCode(int examCode) throws Exception;
	//return subject code of exam
	public int getExamCode(int subjectCode, String examName) throws Exception;
}