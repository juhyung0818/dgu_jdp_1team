package com.jdp.persistence;

import java.util.Date;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;
/**
 * user login
 * @author kwon
 * update date : 2016-11-11
 */
public interface UserDAO {
	/**
	 * user login
	 * @param dto : user id, pw, cookie
	 * @return UserVO
	 * @throws Exception
	 */
	public UserVO login(LoginDTO dto) throws Exception;

	public UserVO register(UserVO user) throws Exception;
	//public UserVO login(UserVO user) throws Exception;

	
	/**
	 * auto login
	 * @param uid : user id
	 * @param sessionId : session id 
	 * @param next : expire date
	 * @throws Exception
	 */
	public void keepLogin(String uid, String sessionId, Date next) throws Exception;;
	
	/**
	 * check expire date
	 * @param value : session key
	 * @return
	 * @throws Exception
	 */
	public UserVO checkUserWithSessionKey(String value) throws Exception;

}
