package com.jdp.test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

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
import com.jdp.service.ExamService;

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
		int subjectCode = 12312;
		String examName = "aa";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectCode", subjectCode);
		paramMap.put("examName", examName);
		dao.delete(subjectCode, examName);
	}
	
	@Test
	public void testUpdateExam() throws Exception{
		ExamVO vo = new ExamVO();
		vo = dao.getExam(12313, "a");
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
		int subjectCode= 1300;
		String examName = "soooo";
		logger.info(score.answers(subjectCode, examName).toString());
	}
	
	@Test
	public void testGetExam() throws Exception{
		ExamVO exam = new ExamVO();
		exam = dao.getExam(12312, "a");
		System.out.println(exam.toString());
	}
}
