package com.jdp.persistence;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.jdp.domain.QuestionVO;
/**
 * Database Access Object
 * class to access question table in database
 * @author YJH
 * 2016.10.19.Wed
 */
@Repository
public class QuestionDAOImpl {
	
	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.ExamMapper";

	
	public void register(QuestionVO question) throws Exception {
		session.insert(namespace + ".register", question);
	}
}
