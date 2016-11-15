package com.jdp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.CheckVO;
import com.jdp.domain.MemberListVO;
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
	public ScoreVO check(int subjectCode, String examName, String uid) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("examName", examName);
		paramMap.put("uid", uid);
		return session.selectOne(namespace + ".check", uid);
	}
	@Override
	public List<MemberListVO> listMember(String uid, int subjectCode) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uid", uid);
		paramMap.put("subjectCode", subjectCode);
		return session.selectList(namespace+".manage", paramMap);
	}


	@Override
	public List<MemberListVO> listMember2(MemberListVO memberListVO) throws Exception {
		return session.selectList(namespace+".manage2", memberListVO);
	}
	/**
	 * display exam infomation and score
	 * 2016.11.11.Fri
	 */
	@Override
	public List<ScoreVO> myScore(int subjectCode, String uid) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("uid", uid);
		return session.selectList(namespace+".myScore", paramMap);

	}

	@Override
	public int myScore(String uid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
