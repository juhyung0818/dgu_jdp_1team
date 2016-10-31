package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.ExamVO;
import com.jdp.persistence.ExamDAOImpl;

@Service
public class ExamServiceImpl implements ExamService{

	
	@Inject
	private ExamDAOImpl examDao;
	
	@Override
	public void register(ExamVO exam) throws Exception {
		examDao.register(exam);
	}

	@Override
	public void delete(ExamVO exam) throws Exception {
		examDao.delete(exam);
	}

	@Override
	public void update(ExamVO exam) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public List<ExamVO> examList(int subjectCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<QuestionVO> read(ExamVO exam) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//		examDao.update(exam);
//	}
//
//	@Override
//	public List<ExamVO> examList(int subjectCode) throws Exception {
//		return examDao.listExam(subjectCode);
//	}
//
//	@Override
//	public void delete(ExamVO exam) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void update(ExamVO exam) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
}
