package com.jdp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;
import com.jdp.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO dao;

//	@Override
//	public UserVO login(UserVO user) throws Exception {
//		return dao.login(user);
//	}

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

@Override
public UserVO register(UserVO user) throws Exception {
	
	return dao.register(user);
}
	
}
