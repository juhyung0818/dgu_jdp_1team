package com.jdp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.ExamVO;
import com.jdp.exception.TimeOutException;
/**
 * Database Access Object
 * class to access exam table in database
 * @author YJH
 * 2016.10.19.Wed
 */
@Repository
public class ExamDAOImpl implements ExamDAO{

	@Inject
	private SqlSession session; //session for sql connection
	private String namespace = "com.jdp.mapper.ExamMapper";

	@Override
	public void register(ExamVO exam) throws Exception {
		session.insert(namespace+".register", exam);
	}

	@Override
	public void delete(int examCode) throws Exception {
		session.delete(namespace+".delete", examCode);
	}

	@Override
	public void update(ExamVO exam) throws Exception {
		session.update(namespace+".modify", exam);
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

	@Override
	public ExamVO getExam(int examCode) throws Exception {
		return session.selectOne(namespace+".getExam", examCode);
	}

	@Override
	public void deleteAll(int subjectCode) throws Exception {
		session.delete(namespace+".deleteAll", subjectCode);
	}

	@Override
	public int checkTime(int examCode) throws Exception {
		return session.selectOne(namespace+".checkTime", examCode);
	}

	@Override
	public int getSubjectCode(int examCode) throws Exception {
		return session.selectOne(namespace + ".getSubjectCode", examCode);
	}

	//get exam name
	@Override
	public int getExamCode(int subjectCode, String examName) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("subjectCode", subjectCode);
		param.put("examName", examName);
		return session.selectOne(namespace+".getExamCode", param);
	}

	@Override
	public List<Integer> examCodeList(int subjectCode) throws Exception {
		return session.selectList(namespace + ".examCodeList", subjectCode);
	}

	@Override
	public int checkExamName(int subjectCode, String examName) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("subjectCode", subjectCode);
		param.put("examName", examName);
		return session.selectOne(namespace + ".checkExamName", param);
	}

	@Override
	public int checkExam(int examCode) throws Exception {
		return session.selectOne(namespace + ".checkExam", examCode);
	}
}
