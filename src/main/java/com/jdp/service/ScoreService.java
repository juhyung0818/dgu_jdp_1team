package com.jdp.service;

import java.util.List;

import com.jdp.domain.CheckVO;
import com.jdp.domain.ScoreVO;
/**
 * Service interface about Score
 * @author YJH
 * 2016.11.06.Sun
 */
public interface ScoreService {

	public void register(ScoreVO score) throws Exception;
	public List<CheckVO> answer(int subjectCode, String examName) throws Exception;
}