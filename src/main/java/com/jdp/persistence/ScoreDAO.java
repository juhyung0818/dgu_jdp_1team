package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.CheckVO;
import com.jdp.domain.MemberListVO;
import com.jdp.domain.ScoreVO;

/**
 * Database Access Object
 * interface to access score table in database
 * @author YJH
 * 2016.11.06.Sun
 */
public interface ScoreDAO {
	
	public void register(ScoreVO score) throws Exception;
	public List<CheckVO> answers(int subjectCode, String examName) throws Exception;
	public int myScore(String uid) throws Exception;
	//manage student
	public List<MemberListVO> listMember(String uid, int subjectCode) throws Exception;
	//manage student2
	public List<MemberListVO> listMember2(MemberListVO memberListVO) throws Exception;
	public String check(String uid) throws Exception;
	public List<ScoreVO> myScore(int subjectCode, String uid) throws Exception;
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
