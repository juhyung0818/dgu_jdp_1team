package com.jdp.persistence;

import com.jdp.domain.ExamVO;

/**
 * Database Access Object
 * interface to access exam table in database
 * @author YJH
 * 2016.10.19.Wed
 */

public interface ExamDAO {
	public void register(ExamVO exam) throws Exception;
	public void delete(ExamVO exam) throws Exception;
	public void readExam(ExamVO exam) throws Exception;
	public void update(ExamVO exam) throws Exception;
}
