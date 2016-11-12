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
	public void delete(int subjectCode, String examName) throws Exception;
	//modify about exam
	public void update(ExamVO exam, String newName) throws Exception;
	public List<ExamVO> listExam(int subjectCode) throws Exception;
	public void incrementCnt(ExamVO exam) throws Exception;
	public String getSubjectName(int subjectCode) throws Exception;
	
	public void readExam(ExamVO exam) throws Exception;
}
