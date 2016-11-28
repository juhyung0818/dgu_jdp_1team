package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdp.domain.QuestionVO;
import com.jdp.exception.TookExamException;
import com.jdp.persistence.ExamDAO;
import com.jdp.persistence.QuestionDAO;
import com.jdp.persistence.ScoreDAO;

/**
 * Service interface
 * @author YJH
 * 2016.11.01.Wed
 */

@Service
public class QuestionServiceImpl implements QuestionService{

	@Inject
	private QuestionDAO questionDAO;
	@Inject
	private ScoreDAO scoreDAO;

	@Override
	public void register(QuestionVO question) throws Exception {
		questionDAO.register(question);
	}
	
	@Override
	public void registerList(List<QuestionVO> question) throws Exception {

		for(int i=0; i<question.size(); i++){
			questionDAO.register(question.get(i));
		}
	}

	@Override
	public void update(List<QuestionVO> question) throws Exception {
		for(int i=0; i<question.size(); i++){
			questionDAO.update(question.get(i));
		}
	}

	@Override
	public List<QuestionVO> listQuestion(int examCode) throws Exception {
		return questionDAO.tryQuestion(examCode);
	}
	
	@Override
	public List<QuestionVO> tryQuestion(int examCode, String uid) throws Exception {
		if(scoreDAO.takeExam(examCode, uid) > 0){
			throw new TookExamException();
		}
		return questionDAO.listQuestion(examCode);
	}

	@Transactional
	@Override
	public void delete(int examCode) throws Exception {
		questionDAO.delete(examCode);
	}

}
