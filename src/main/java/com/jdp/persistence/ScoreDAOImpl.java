package com.jdp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.CheckVO;
import com.jdp.domain.ScoreVO;

@Repository
public class ScoreDAOImpl implements ScoreDAO{

	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.ScoreMapper";
	
	//score register
	@Override
	public void register(ScoreVO score) throws Exception {
		session.insert(namespace + ".register", score);
	}
	
	//answer check
	@Override
	public List<CheckVO> answers(int subjectCode, String examName) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("examName", examName);
		return session.selectList(namespace+".answer", paramMap);
	}

	@Override
	public int myScore(String uid) throws Exception {
		return session.selectOne(namespace+".myScore", uid);
	}


}
