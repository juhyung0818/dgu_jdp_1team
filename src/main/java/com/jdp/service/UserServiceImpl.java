package com.jdp.service;

import java.util.Date;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

import org.omg.CORBA.TIMEOUT;
import org.springframework.stereotype.Service;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;
import com.jdp.exception.DuplicationIdException;
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

	/**
	 * uid check and register
	 * @author YJH
	 */

	@Override
	public UserVO register(UserVO user) throws Exception {
		if(dao.checkUid(user.getUid()) > 0){
			throw new DuplicationIdException();
		}
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

	@Override
	public void checkUid(String uid) throws Exception {
		if(dao.checkUid(uid) > 0){
			throw new DuplicationIdException();
		}else{
			throw new TimeoutException();
		}
	}

}
