package com.jdp.test;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jdp.controller.ExamController;
import com.jdp.domain.UserVO;
import com.jdp.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
/**
 * Test code of exam for database access
 * @author YJH
 * 2016.11.15.Tue
 */
public class UserTest {

	@Inject
	private UserDAO userDao;
	// log
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	//uid duplicate check
	@Test
	public void testUidCheck() throws Exception{
		
		String uid = "s";
		assertNotNull(userDao.checkUid(uid)); //result is not null
		logger.info(Integer.toString(userDao.checkUid(uid))); //uid is number of row
	}
	
	//user register
	@Test
	public void testUserRegister() throws Exception{
		UserVO user = new UserVO();
		user.setUid("uu");
		user.setUpw("0");
		user.setUname("uu");
		user.setFlag(0);
		userDao.register(user);
	}
}
