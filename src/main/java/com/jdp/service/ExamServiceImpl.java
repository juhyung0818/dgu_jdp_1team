package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.ExamVO;
<<<<<<< HEAD
import com.jdp.domain.QuestionVO;
import com.jdp.persistence.ExamDAOImpl;
=======
import com.jdp.persistence.ExamDAO;
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09

@Service
public class ExamServiceImpl implements ExamService{

<<<<<<< HEAD
	
	@Inject
	private ExamDAOImpl examDAO;
	
	@Override
	public void register(ExamVO exam) throws Exception {
		examDAO.register(exam);
=======
	@Inject
	private ExamDAO examDao;
	
	@Override
	public void register(ExamVO exam) throws Exception {
		examDao.register(exam);
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
	}

	@Override
	public void delete(ExamVO exam) throws Exception {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
=======
		examDao.delete(exam);
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
	}

	@Override
	public void update(ExamVO exam) throws Exception {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ExamVO> examList(ExamVO exam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionVO> read(ExamVO exam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

=======
		examDao.update(exam);
	}

	@Override
	public List<ExamVO> examList(int subjectCode) throws Exception {
		return examDao.listExam(subjectCode);
	}
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
}
