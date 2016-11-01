package com.jdp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.SubjectVO;

@Repository
public class subjectDAOImpl implements SubjectDAO{

	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.subjectMapper";
	
	@Override
	public void register(SubjectVO subject) throws Exception {
		session.insert(namespace+".register",subject);
	}

	@Override
	public void delete(int subjectCode) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectVO> listExam() throws Exception {
		return session.selectList(namespace+".subjectList");
	}

}
