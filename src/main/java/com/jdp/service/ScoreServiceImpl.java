package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.CheckVO;
import com.jdp.domain.ExamVO;
import com.jdp.domain.MemberListVO;
import com.jdp.domain.ScoreVO;
import com.jdp.persistence.ScoreDAO;

@Service
public class ScoreServiceImpl implements ScoreService{

	@Inject
	private ScoreDAO scoreDao;
	
	@Override
	public void register(ScoreVO score) throws Exception {
		scoreDao.register(score);
	}

	@Override
	public List<CheckVO> answer(int subjectCode, String examName) throws Exception {
		return scoreDao.answers(subjectCode, examName);
	}


	@Override
	public String check(String uid) throws Exception {
		return scoreDao.check(uid);
	}

	@Override
	public List<ScoreVO> myScore(int subjectCode, String uid) throws Exception {
		return scoreDao.myScore(subjectCode, uid);
	}
	@Override
	public List<MemberListVO> listMember(String uid, int subjectCode) throws Exception {
		return scoreDao.listMember(uid, subjectCode);
	}

	@Override
	public List<MemberListVO> listMember2(MemberListVO memberListVO) throws Exception {
		return scoreDao.listMember2(memberListVO);
	}

	@Override
	public List<ExamVO> listExam(int subjectCode) throws Exception {
		return scoreDao.listExam(subjectCode);
	}

	@Override
	public List<ScoreVO> readScore(int subjectCode, String uid) throws Exception {
		return scoreDao.readScore(subjectCode, uid);
	}

}
