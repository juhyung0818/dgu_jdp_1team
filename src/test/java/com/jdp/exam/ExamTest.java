package com.jdp.exam;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
/**
 * Test code of exam for database access
 * @author YJH
 * 2016.10.29.Sat
 * pass all test
 */
public class ExamTest {

	@Inject
	private ExamDAO dao;
	//log
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	@Test
	public void testRegistExam() throws Exception{
		ExamVO vo = new ExamVO();
		vo.setSubjectCode(12312);
		vo.setExamName("test");
		vo.setStudentCnt(0);
		vo.setStartTime(Timestamp.valueOf("2016-10-30 11:11:00"));
		vo.setEndTime(Timestamp.valueOf("2016-10-30 11:11:00"));
		dao.register(vo);
	}
	
	@Test
	public void testDeleteExam() throws Exception{
		ExamVO vo = new ExamVO();
		vo.setSubjectCode(12312);
		vo.setExamName("test");
		dao.delete(vo);
	}
	
	@Test
	public void testUpdateExam() throws Exception{
		ExamVO vo = new ExamVO();
		vo.setSubjectCode(12312);
		vo.setExamName("test");
		vo.setStartTime(Timestamp.valueOf("2016-10-30 11:00:00"));
		vo.setEndTime(Timestamp.valueOf("2016-10-30 12:00:00"));
		dao.update(vo);
	}
	
	@Test
	public void testListExam() throws Exception{
		String subjectCode = "12312";
		logger.info(dao.listExam(subjectCode).toString());
	}

	@Test
	public void testIncrementCnt() throws Exception{
		ExamVO vo = new ExamVO();
		vo.setSubjectCode(12312);
		vo.setExamName("test");
		dao.incrementCnt(vo);
	}
	
}
