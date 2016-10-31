package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.ExamVO;
import com.jdp.persistence.ExamDAO;

@Service
public class ExamServiceImpl implements ExamService{

	
	@Inject
	private ExamDAO examDao;
	
	@Override
	public void register(ExamVO exam) throws Exception {
		examDao.register(exam);
	}

	@Override
	public void delete(int subjectCode, String examName) throws Exception {
		examDao.delete(subjectCode, examName);
	}

	@Override
	public void update(ExamVO exam) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public List<ExamVO> examList(int subjectCode) throws Exception {
		return examDao.listExam(subjectCode);
	}


}
