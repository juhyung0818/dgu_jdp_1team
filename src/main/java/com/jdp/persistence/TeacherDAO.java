package com.jdp.persistence;

import com.jdp.domain.TeacherVO;

/**
 * Database Access Object
 * interface to access Teacher table in database
 * @author YJH
 * 2016.10.30.Sun
 */
public interface TeacherDAO {

	public void register(TeacherVO teacher) throws Exception;
	public void checkTid(TeacherVO teacher) throws Exception;
	public void checkPW(TeacherVO teacher) throws Exception;

}
