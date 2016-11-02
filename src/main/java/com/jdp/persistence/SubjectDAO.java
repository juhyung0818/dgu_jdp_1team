package com.jdp.persistence;

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
}
