package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.ExamVO;

/**
 * Database Access Object
 * interface to access exam table in database
 * @author YJH
 * 2016.10.19.Wed
 */

public interface ExamDAO {
	public void register(ExamVO exam) throws Exception;
	public void delete(int examCode) throws Exception;
	//modify about exam
	public void update(ExamVO exam) throws Exception;
	public List<ExamVO> listExam(int subjectCode) throws Exception;
	public void incrementCnt(ExamVO exam) throws Exception;
	public String getSubjectName(int subjectCode) throws Exception;
	public ExamVO getExam(int examCode) throws Exception;
	
	//all exam delete
	public void deleteAll(int subjectCode) throws Exception;
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
	//return exam code of exam
	public int getExamCode(int subjectCode, String examName) throws Exception;
	//examCode list of a subject code
	public List<Integer> examCodeList(int subjectCode) throws Exception;
	//check exam name
	public int checkExamName(int subjectCode, String examName) throws Exception;
}
