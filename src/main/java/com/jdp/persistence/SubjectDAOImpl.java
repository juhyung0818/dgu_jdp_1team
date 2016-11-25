package com.jdp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.MemberVO;
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
	public void register(String subjectName, String uid) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectName", subjectName);
		paramMap.put("uid", uid);
		session.insert(namespace+".register", paramMap);
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

	@Override
	public void joinSubject(MemberVO member) throws Exception {
		session.insert(namespace+".joinSubject", member);
	}

	@Override
	public List<SubjectVO> listStudent(String uid) throws Exception {
		return session.selectList(namespace+".listStudent", uid);
	}

	@Override
	public List<SubjectVO> listTeacher(String uid) throws Exception {
		return session.selectList(namespace+".listTeacher", uid);
	}

	@Override
	public void delete(int subjectCode) throws Exception {
		session.delete(namespace+".delete", subjectCode);
	}

	@Override
	public String getSubjectName(int subjectCode) throws Exception {
		return session.selectOne(namespace+".getSubjectName", subjectCode);
	}

	// Student leave subject 
	@Override
	public void leaveSubject(String uid, int subjectCode) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uid", uid);
		paramMap.put("subjectCode", subjectCode);
		session.delete(namespace+".leaveSubject", paramMap);
	}
	
	// check user access authority
	@Override
	public int checkAuthority(String uid, int subjectCode) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uid", uid);
		paramMap.put("subjectCode", subjectCode);
		return session.selectOne(namespace+".checkAuthority", paramMap);
	}
}

