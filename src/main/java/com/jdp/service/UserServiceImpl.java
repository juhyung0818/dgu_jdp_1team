package com.jdp.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;
import com.jdp.persistence.UserDAO;

/**
 * implement UserService
 * 
 * @author kwon update date : 2016-11-11
 */
@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public UserVO register(UserVO user) throws Exception {

		return dao.register(user);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) throws Exception {
		dao.keepLogin(uid, sessionId, next);
	}

	@Override
	public UserVO checkLoginBefore(String value) throws Exception {
		return dao.checkUserWithSessionKey(value);
	}

	/**
	 * uid check
	 * @author YJH
	 */
	@Override
	public int checkUid(String uid) throws Exception {
		return dao.checkUid(uid);
	}
}
