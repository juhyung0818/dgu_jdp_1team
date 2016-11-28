package com.jdp.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.jdp.controller.ExamController;
import com.jdp.domain.ScoreVO;
import com.jdp.persistence.ScoreDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
/**
 * Test code of score
 * @author YJH
 * 2016.11.27.Sun
 */
public class ScoreTest {

	@Inject
	private ScoreDAO scoreDao;
	//log
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	//register score
	@Test
	public void testRegisterScore() throws Exception{
		ScoreVO score = new ScoreVO();
		score.setExamCode(40);
		score.setScore(100);
		score.setUid("jh");
		scoreDao.register(score);
	}
	
	//MyScore test
	@Test
	public void testMyScore() throws Exception{
		Assert.isNull(scoreDao.myScore(26, "s"));
	}
	
	//score list in the subject
	@Test
	public void testScoreList() throws Exception{
		logger.info(scoreDao.scoreList(22, "s").toString());
	}
}
