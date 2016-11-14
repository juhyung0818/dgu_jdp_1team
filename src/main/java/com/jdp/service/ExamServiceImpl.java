package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.ExamVO;
import com.jdp.persistence.ExamDAO;

/**
 * Service class about Exam
 * @author YJH
 * 2016.10.24.Wed
 */
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
	public void update(ExamVO exam, String newName) throws Exception {
		examDao.update(exam, newName);
	}

	@Override
	public List<ExamVO> examList(int subjectCode) throws Exception {
		return examDao.listExam(subjectCode);
	}

	@Override
	public String getSubjectName(int subjectCode) throws Exception {
		return examDao.getSubjectName(subjectCode);
	}
}
