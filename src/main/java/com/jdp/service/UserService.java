package com.jdp.service;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
	//public UserVO login(UserVO user) throws Exception;
}
