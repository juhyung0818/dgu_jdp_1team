package com.jdp.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jdp.domain.SubjectVO;
import com.jdp.persistence.SubjectDAO;

/**
 * Test code of subject for database access
 * @author YJH
 * 2016.11.01.Sat
 * pass all test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SubjectTest {

	@Inject
	private SubjectDAO subjectDao;
	
	/* subject register test */
	@Test
	public void testSubjectRegister() throws Exception{
		SubjectVO vo = new SubjectVO();
		vo.setSubjectCode(123);
		vo.setSubjectName("jh class");
		subjectDao.register(vo);
	}
}
