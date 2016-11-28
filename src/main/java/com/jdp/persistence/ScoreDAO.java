package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.CheckVO;
import com.jdp.domain.ExamVO;
import com.jdp.domain.MemberListVO;
import com.jdp.domain.ScoreVO;

/**
 * Database Access Object
 * interface to access score table in database
 * @author LYJ
 * 2016.11.06.Sun
 */
public interface ScoreDAO {
	
	public void register(ScoreVO score) throws Exception;
	public List<CheckVO> answer(int examCode) throws Exception;
//	public int myScore(String uid) throws Exception;
	//manage student
	public List<MemberListVO> listMember(String uid, int subjectCode) throws Exception;
	//manage student2
	public List<MemberListVO> listMember2(MemberListVO memberListVO) throws Exception;
	public ScoreVO check(int subjectCode, String examName, String uid) throws Exception;
	/**
	 * get score {examCode, uid}
	 * @param examCode
	 * @param uid
	 * @author YJH
	 */
	public ScoreVO myScore(int examCode, String uid) throws Exception;
	/**
	 * get score list {subjectCode, uid} 
	 * @param subjectCode
	 * @param uid
	 * @author YJH
	 */
	public List<ScoreVO> scoreList(int subjectCode, String uid) throws Exception;
	/**
	 * check authority about exam
	 * @param examCode
	 * @param uid
	 * @author YJH
	 */
	public int takeExam(int examCode, String uid) throws Exception;
	public List<ExamVO> listExam(int subjectCode) throws Exception;
	public List<ScoreVO> readScore(int subjectCode, String uid) throws Exception;
	/**
	 * student took a exam whether or not
	 * @param subjectCode
	 * @param examName
	 * @param uid
	 * @return if already took a exam, return uid. if not, null
	 * @throws Exception
	 */
	public ScoreVO checkIsTry(int examCode, String uid) throws Exception;
}
