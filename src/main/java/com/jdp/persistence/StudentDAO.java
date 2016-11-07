package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.StudentVO;


/**
 * Database Access Object
 * interface to access Student table in database
 * @author YJH
 * 2016.10.30.Sun
 */
public interface StudentDAO {

	public void register(StudentVO student) throws Exception;
	
	//id duplication check
	public void checkSid(StudentVO student) throws Exception;
	public void checkPW(StudentVO student) throws Exception;
	public List<StudentVO> login(StudentVO student) throws Exception;	
}
