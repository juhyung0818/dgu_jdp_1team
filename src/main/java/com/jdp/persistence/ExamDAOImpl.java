package com.jdp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.jdp.domain.ExamVO;

@Repository
public class ExamDAOImpl implements ExamDAO{
	
	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.ExamMapper";

	@Override
	public void register(ExamVO exam) throws Exception {
		session.insert(namespace+".register", exam);
	}

	@Override
	public void delete(ExamVO exam) throws Exception {
		session.delete(namespace+".delete", exam);
	}

	@Override
	public void readExam(ExamVO exam) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(ExamVO exam) throws Exception {
		session.update(namespace+".update", exam);
	}

	@Override
	public List<ExamVO> listExam(String subjectCode) throws Exception {
		return session.selectList(namespace+".listExam", subjectCode);
	}

	@Override
	public void incrementCnt(ExamVO exam) throws Exception {
		session.update(namespace+".incrementCnt", exam);
	}

}
