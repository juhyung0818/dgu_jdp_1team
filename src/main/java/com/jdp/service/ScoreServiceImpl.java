package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.CheckVO;
import com.jdp.domain.ScoreExamVO;
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

}
