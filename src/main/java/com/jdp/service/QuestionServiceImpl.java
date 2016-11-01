package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.QuestionListVO;
import com.jdp.domain.QuestionVO;
import com.jdp.persistence.QuestionDAO;

/**
 * Service interface
 * @author YJH
 * 2016.11.01.Wed
 */

@Service
public class QuestionServiceImpl implements QuestionService{

	@Inject
	private QuestionDAO questionDAO;
	
	/**
	 * add question in exam
	 * @param questionList
	 * @throws Exception
	 */
	public void register(QuestionListVO questions) throws Exception {
		List<QuestionVO> list = questions.getqList();

		for(int i=0; i<questions.getqList().size(); i++){
			questionDAO.register(list.get(i));
		}
		
	}

	@Override
	public void register(QuestionVO question) throws Exception {
		questionDAO.register(question);
	}

	@Override
	public void update(QuestionVO question) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<QuestionVO> questionList(int subjectCode, String examName) throws Exception {
		return questionDAO.listQuestion(subjectCode, examName);
	}

	@Override
	public void delete(int subjectCode, String examName) throws Exception {
		questionDAO.delete(subjectCode, examName);
	}
}
