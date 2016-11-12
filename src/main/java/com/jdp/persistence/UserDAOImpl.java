package com.jdp.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="com.jdp.mapper.UserMapper";

//	@Override
//	public UserVO login(UserVO user) throws Exception {
//		return session.selectOne(namespace+".login", user);
//	}
//	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {	
		return session.selectOne(namespace+".login", dto);
	}

@Override
public UserVO register(UserVO user) throws Exception {
	
	return session.selectOne(namespace+".register",user );
}


}
