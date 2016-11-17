package com.jdp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void delete(int subjectCode, String examName) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("examName", examName);
		session.delete(namespace+".delete", paramMap);
	}

	@Override
	public void readExam(ExamVO exam) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(ExamVO exam, String newName) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectCode", exam.getSubjectCode());
		paramMap.put("examName", exam.getExamName());
		paramMap.put("startTime", exam.getStartTime());
		paramMap.put("endTime", exam.getEndTime());
		paramMap.put("newName", newName);
		session.update(namespace+".modify", paramMap);
	}

	@Override
	public List<ExamVO> listExam(int subjectCode) throws Exception {
		return session.selectList(namespace+".listExam", subjectCode);
	}

	@Override
	public void incrementCnt(ExamVO exam) throws Exception {
		session.update(namespace+".incrementCnt", exam);
	}

	@Override
	public String getSubjectName(int subjectCode) throws Exception {
		return session.selectOne(namespace+".getName", subjectCode);
	}

}
