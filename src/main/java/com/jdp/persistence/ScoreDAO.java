package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.CheckVO;
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
}
