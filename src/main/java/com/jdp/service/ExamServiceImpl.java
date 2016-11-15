package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdp.domain.ExamVO;
import com.jdp.persistence.ExamDAO;
import com.jdp.persistence.QuestionDAO;

/**
 * Service class about Exam
 * @author YJH
 * 2016.10.24.Wed
 */
@Service
public class ExamServiceImpl implements ExamService{

	@Inject
	private ExamDAO examDao;
	@Inject
	private QuestionDAO questionDao;
	
	@Override
	public void register(ExamVO exam) throws Exception {
		examDao.register(exam);
	}
	
	@Transactional
	@Override
	public void delete(int subjectCode, String examName) throws Exception {
		questionDao.delete(subjectCode, examName);
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

	@Override
	public ExamVO getExam(int subjectCode, String examName) throws Exception {
		return examDao.getExam(subjectCode, examName);
	}
	
	@Override
	public void update(ExamVO exam) throws Exception {
		examDao.update(exam);
	}

}
