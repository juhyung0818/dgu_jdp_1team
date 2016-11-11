package com.jdp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.QuestionVO;

/**
 * Database Access Object
 * class to access question table in database
 * @author YJH
 * 2016.10.19.Wed
 */

@Repository
public class QuestionDAOImpl implements QuestionDAO{
	
	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.QuestionMapper";

	
	public void register(QuestionVO question) throws Exception {
		session.insert(namespace + ".register", question);
	}
	public void registerList(List<QuestionVO> question) throws Exception {
		session.insert(namespace + ".registerList", question);
	}

	@Override
	public void update(QuestionVO question) throws Exception {
		session.update(namespace + ".update", question);
	}

	@Override
	public List<QuestionVO> listQuestion(int subjectCode, String examName) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("examName", examName);
		return session.selectList(namespace + ".listQuestion", paramMap);
	}

	@Override
	public void delete(int subjectCode, String examName) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("examName", examName);
		session.delete(namespace + ".delete", paramMap);
	}

	@Override
	public List<QuestionVO> tryQuestion(int subjectCode, String examName) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("examName", examName);
		return session.selectList(namespace + ".tryQuestion", paramMap);
	}
}
