package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.MemberVO;

public interface MemberDAO {
	public List<MemberVO> list(int subjectCode) throws Exception;
	public void register(int subjectCode, String uid) throws Exception;
	public void remove(int subjectCode, String uid) throws Exception;
}
