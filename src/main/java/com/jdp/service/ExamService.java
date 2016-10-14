package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.QuestionVO;
import com.jdp.persistence.ExamDAO;

/**
 * 
 * @author YJH
 *
 */

@Service
public class ExamService {

	@Inject
	private ExamDAO examDAO;
	
	/**
	 * question list split
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
