package com.jdp.persistence;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.jdp.domain.QuestionVO;
/**
 * 
 * @author YJH
 *
 */
@Repository
public class ExamDAO {
	
	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.ExamMapper";

	public void register(QuestionVO question) throws Exception {
		session.insert(namespace + ".register", question);
	}
}
