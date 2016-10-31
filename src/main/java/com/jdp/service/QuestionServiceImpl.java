package com.jdp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.QuestionVO;
import com.jdp.persistence.QuestionDAOImpl;

/**
 * Service class
 * @author YJH
 * 2016.10.19.Wed
 */

@Service
public class QuestionServiceImpl {

	@Inject
	private QuestionDAOImpl examDAO;
	
	/**
	 * add question in exam
	 * @param questionList
	 * @throws Exception
	 */
	public void register(QuestionVO questionList) throws Exception {
//		for(int i=0; i<questionList.size(); i++){
//			examDAO.register(questionList.get(i));
//		}
		examDAO.register(questionList);
	}
}
