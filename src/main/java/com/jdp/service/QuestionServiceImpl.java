package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.QuestionListVO;
import com.jdp.domain.QuestionVO;
import com.jdp.persistence.QuestionDAOImpl;

/**
 * Service class
 * @author YJH
 * 2016.10.19.Wed
 */

@Service
public class QuestionServiceImpl{

	@Inject
	private QuestionDAOImpl examDAO;
	
	/**
	 * add question in exam
	 * @param questionList
	 * @throws Exception
	 */
	public void register(QuestionListVO questions) throws Exception {
		List<QuestionVO> list = questions.getqList();

		for(int i=0; i<questions.getqList().size(); i++){
			examDAO.register(list.get(i));
		}
		
	}
}
