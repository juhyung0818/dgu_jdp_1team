package com.jdp.test;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jdp.controller.ExamController;
import com.jdp.domain.ExamVO;
import com.jdp.persistence.ExamDAO;
import com.jdp.persistence.ScoreDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
/**
 * Test code of exam for database access
 * @author YJH
 * 2016.10.29.Sat
 */
public class ExamTest {

	@Inject
	private ExamDAO dao;
	@Inject
	private ScoreDAO score;
	//log
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@Test
	public void testRegistExam() throws Exception{
		ExamVO vo = new ExamVO();
		vo.setSubjectCode(12);
		vo.setExamName("test");
		vo.setStudentCnt(0);
		vo.setStartTime(Timestamp.valueOf("2016-11-11 11:11:00"));
		vo.setEndTime(Timestamp.valueOf("2016-11-11 11:11:00"));
		dao.register(vo);
	}
	
	@Test
	public void testDeleteExam() throws Exception{
		int examCode = 12312;
		dao.delete(examCode);
	}
	
	@Test
	public void testUpdateExam() throws Exception{
		ExamVO vo = new ExamVO();
		System.out.println(vo.toString());
		dao.update(vo);
	}
	
	@Test
	public void testListExam() throws Exception{
		int subjectCode = 12312;
		logger.info(dao.listExam(subjectCode).toString());
	}

//	@Test
//	public void testIncrementCnt() throws Exception{
//		ExamVO vo = new ExamVO();
//		vo.setSubjectCode(12312);
//		vo.setExamName("test");
//		dao.incrementCnt(vo);
//	}
	
	@Test
	public void testQuestionAnswer() throws Exception{
		int examCode= 1300;
		logger.info(score.answer(examCode).toString());
	}
	
	@Test
	public void testGetExam() throws Exception{
		ExamVO exam = new ExamVO();
		System.out.println(exam.toString());
	}
	
	@Test
	public void testModifyExam() throws Exception{
		ExamVO exam = dao.getExam(31);
		exam.setExamName("mmmkd");
		dao.update(exam);
	}
}
