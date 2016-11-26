package com.jdp.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jdp.controller.ExamController;
import com.jdp.domain.QuestionVO;
import com.jdp.persistence.QuestionDAO;

/**
 * Test code of question for database access
 * @author YJH
 * 2016.10.29.Sat
 * pass all test
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class QuestionTest {
	@Inject
	private QuestionDAO dao;
	// log
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@Test
	public void testRegisterQuestion() throws Exception {
		QuestionVO vo = new QuestionVO();
		for (int i = 0; i < 10; i++) {
			vo.setExamCode(30);
			vo.setqNumber(i);
			vo.setqInfo("problem");
			vo.setEx1("1");
			vo.setEx2("2");
			vo.setEx3("3");
			vo.setEx4("4");
			vo.setAnswer(1);
			vo.setqPoint(3);
			dao.register(vo);
		}
	}
	
	@Test
	public void testUpdateQuestion() throws Exception{
		QuestionVO vo = new QuestionVO();
		vo.setExamCode(100);
		vo.setqNumber(2);
		vo.setqInfo("problem");
		vo.setEx1("100");
		vo.setEx2("200");
		vo.setEx3("300");
		vo.setEx4("400");
		vo.setAnswer(1);
		vo.setqPoint(3);
		dao.update(vo);
	}

//	@Test
//	public void testListQuestion() throws Exception{
//		logger.info("test:ostQuestion....");
//		QuestionVO vo = new QuestionVO();
//		vo.setSubjectCode(12312);
//		vo.setExamName("test");
//		logger.info(dao.listQuestion(vo).toString());
//	}
}
