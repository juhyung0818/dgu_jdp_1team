package com.jdp.persistence;

<<<<<<< HEAD
import java.util.List;

import com.jdp.domain.SubjectVO;

public interface SubjectDAO {
	public void register(SubjectVO subject) throws Exception;
	public void delete(int subjectCode) throws Exception;
	//modify about exam
	public List<SubjectVO> listExam() throws Exception;
=======
import com.jdp.domain.SubjectVO;

/**
 * Database Access Object
 * interface to access Subject table in database
 * @author YJH
 * 2016.11.01.Thu
 */

public interface SubjectDAO {

	public void register(SubjectVO subject) throws Exception;
	public void modify(int subjectCode, String subjectName) throws Exception;
>>>>>>> 4c254baab405df4c62e2424763b80eb4fabed372
}
