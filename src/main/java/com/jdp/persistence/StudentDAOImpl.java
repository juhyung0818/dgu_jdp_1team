package com.jdp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.StudentVO;
/**
 * Database Access Object
 * class to access StudentDAO table in database
 * @author YJH
 * 2016.10.30.Sun
 */
@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.StudentMapper";
	
	@Override
	public void register(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkSid(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPW(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentVO> login(StudentVO student) throws Exception {
		return session.selectOne(namespace+".login", student);
	}

}
