package com.jdp.service;

import java.util.List;

import com.jdp.domain.CheckVO;
import com.jdp.domain.ExamVO;
import com.jdp.domain.MemberListVO;
import com.jdp.domain.ScoreVO;
/**
 * Service interface about Score
 * @author YJH
 * 2016.11.06.Sun
 */
public interface ScoreService {

	public void register(ScoreVO score) throws Exception;
	public List<CheckVO> answer(int subjectCode, String examName) throws Exception;

	public List<MemberListVO> listMember(String uid, int subjectCode) throws Exception;
	public List<MemberListVO> listMember2(MemberListVO memberListVO) throws Exception;
	public List<ExamVO> listExam(int subjectCode) throws Exception;
	public List<ScoreVO> myScore(int subjectCode, String uid) throws Exception;
	public List<ScoreVO> readScore(int subjectCode, String uid) throws Exception;
	public ScoreVO check(int subjectCode, String examName, String uid) throws Exception;
	/**
	 * student took a exam whether or not
	 * @param subjectCode
	 * @param examName
	 * @param uid
	 * @return if already took a exam, return uid. if not, null
	 * @throws Exception
	 */
	public ScoreVO checkIsTry(int subjectCode, String examName, String uid) throws Exception;
}
