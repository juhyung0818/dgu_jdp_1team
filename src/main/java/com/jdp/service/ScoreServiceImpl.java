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
	public List<CheckVO> answer(int examCode) throws Exception {
		return scoreDao.answer(examCode);
	}

	@Override
	public ScoreVO check(int subjectCode, String examName, String uid) throws Exception {
		return scoreDao.check(subjectCode, examName, uid);
	}

	@Override
	public ScoreVO myScore(int examCode, String uid) throws Exception {
		return scoreDao.myScore(examCode, uid);
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
	public ScoreVO checkIsTry(int examCode, String uid) throws Exception {
		return scoreDao.checkIsTry(examCode, uid);
	}

	@Override
	public List<ExamVO> listExam(int subjectCode) throws Exception {
		return scoreDao.listExam(subjectCode);
	}

	@Override
	public List<ScoreVO> readScore(int subjectCode, String uid) throws Exception {
		return scoreDao.readScore(subjectCode, uid);
	}

	@Override
	public List<ScoreVO> scoreList(int subjectCode, String uid) throws Exception {
		return scoreDao.scoreList(subjectCode, uid);
	}

	
}
