package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.SubjectVO;

/**
 * Database Access Object
 * interface to access Subject table in database
 * @author YJH
 * 2016.11.01.Thu
 */

public interface SubjectDAO {

	//add subject in database 
	public void register(SubjectVO subject) throws Exception;
	//update subject in database
	public void modify(int subjectCode, String subjectName) throws Exception;
	//select subjectName in database
	public List<SubjectVO> listSubject(String sid) throws Exception;
}
