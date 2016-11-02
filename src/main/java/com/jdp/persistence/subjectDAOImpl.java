package com.jdp.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.SubjectVO;

/**
 * Database Access Object
 * class to access Subject table in database
 * @author YJH
 * 2016.11.01.Thu
 */

@Repository
public class SubjectDAOImpl implements SubjectDAO{

	@Inject
	private SqlSession session;
	private String namespace="com.jdp.mapper.SubjectMapper";

	/**
	 * Subject add to database in subject table
	 */
	@Override
	public void register(SubjectVO subject) throws Exception {
		session.insert(namespace+".register", subject);
	}
	
	/**
	 * Subject modify subjectName to database in subject table
	 */
	@Override
	public void modify(int subjectCode, String subjectName) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("subjectName", subjectName);
		session.insert(namespace+".modify", paramMap);
	}
}