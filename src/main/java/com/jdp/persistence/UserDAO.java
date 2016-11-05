package com.jdp.persistence;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
	//public UserVO login(UserVO user) throws Exception;
}
