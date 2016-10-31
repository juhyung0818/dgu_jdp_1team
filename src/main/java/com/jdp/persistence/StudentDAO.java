package com.jdp.persistence;

import com.jdp.domain.StudentVO;

/**
 * Database Access Object
 * interface to access Student table in database
 * @author YJH
 * 2016.10.30.Sun
 */
public interface StudentDAO {

	public void register(StudentVO student) throws Exception;
	public void checkSid(StudentVO student) throws Exception;
	public void checkPW(StudentVO student) throws Exception;

}
