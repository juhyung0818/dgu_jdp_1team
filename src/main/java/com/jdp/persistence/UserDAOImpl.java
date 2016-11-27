package com.jdp.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;
/**
 * implement UserDAO
 * @author kwon
 * update date : 2016-11-11
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.jdp.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}


	@Override
	public UserVO register(UserVO user) throws Exception {

		return session.selectOne(namespace + ".register", user);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("uid", uid);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
		session.update(namespace+".keepLogin",paramMap);
	}

	@Override
	public UserVO checkUserWithSessionKey(String value) {
		return session.selectOne(namespace+".checkUserWithSessionKey", value);
	}

	/**
	 * uid check
	 * "uid" is primary key
	 * uid must not duplicate
	 * @author YJH
	 */
	@Override
	public int checkUid(String uid) throws Exception {
		return session.selectOne(namespace+".checkUid", uid);
	}

}
