package com.jdp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.CheckVO;
import com.jdp.domain.ExamVO;
import com.jdp.domain.MemberListVO;
import com.jdp.domain.ScoreVO;

/**
 * 
 * @author LYJ
 *
 */
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
	public List<CheckVO> answer(int examCode) throws Exception {
		return session.selectList(namespace+".answer", examCode);
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
	 * display exam information and score
	 * 2016.11.11.Fri
	 */
	@Override
	public ScoreVO myScore(int examCode, String uid) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("examCode", examCode);
		paramMap.put("uid", uid);
		return session.selectOne(namespace+".myScore", paramMap);
	}

	@Override
	public int myScore(String uid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ExamVO> listExam(int subjectCode) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectCode", subjectCode);
		return session.selectList(namespace+".examList", paramMap);
	}

	@Override
	public List<ScoreVO> readScore(int subjectCode, String uid) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("uid", uid);
		return session.selectList(namespace+".readScore", paramMap);
	
	}
	@Override	
	public ScoreVO checkIsTry(int examCode, String uid) throws Exception {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("examCode", examCode);
		paramMap.put("uid", uid);
		return session.selectOne(namespace+".checkIsTry", paramMap);
	}

	//get my score list in subject
	@Override
	public List<ScoreVO> scoreList(int subjectCode, String uid) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("subjectCode", subjectCode);
		param.put("uid", uid);
		return session.selectList(namespace + ".scoreList", param);
	}

}
