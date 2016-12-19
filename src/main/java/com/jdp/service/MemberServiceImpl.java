package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.jdp.domain.MemberVO;
import com.jdp.persistence.MemberDAO;
@Repository
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDAO memberDao;
	@Override
	public List<MemberVO> list(int subjectCode) throws Exception {
		return memberDao.list(subjectCode);
	}
	@Override
	public void register(int subjectCode, String uid) throws Exception {
		
		memberDao.register(subjectCode, uid);
	}
	@Override
	public void remove(int subjectCode, String uid) throws Exception {

		memberDao.remove(subjectCode, uid);
	}

}
