package com.jdp.service;

import java.sql.Date;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;
/**
 * user login
 * @author kwon
 * update date : 2016³â 11¿ù 11ÀÏ
 */
public interface UserService {
	/**
	 * login 
	 * @param dto : user id, user pw, cookie
	 * @return UserVO
	 * @throws Exception
	 */
	public UserVO login(LoginDTO dto) throws Exception;
	
	/**
	 * auto login
	 * @param uid : user id
	 * @param sessionId : session key
	 * @param next : expire date
	 * @throws Exception
	 */
	public void keepLogin(String uid, String sessionId, Date next) throws Exception;
	/**
	 * check expire date
	 * @param value : session key
	 * @return UserVO
	 */
	public UserVO checkLoginBefore(String value) throws Exception;
}
