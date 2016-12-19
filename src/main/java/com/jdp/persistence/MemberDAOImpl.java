package com.jdp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.MemberVO;
@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession session; //session for sql connection
	private String namespace = "com.jdp.mapper.MemberMapper";
	
	@Override
	public List<MemberVO> list(int subjectCode) throws Exception {
		 
		return session.selectList(namespace+".list", subjectCode);
	}

	@Override
	public void register(int subjectCode, String uid) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("subjectCode", subjectCode);
		param.put("uid", uid);
		session.update(namespace+".register", param);
	}

	@Override
	public void remove(int subjectCode, String uid) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("subjectCode", subjectCode);
		param.put("uid", uid);
		session.update(namespace+".remove", param);
	}

}
