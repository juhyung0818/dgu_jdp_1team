package com.jdp.persistence;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
=======
import java.util.List;
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD

=======
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
import com.jdp.domain.ExamVO;

@Repository
public class ExamDAOImpl implements ExamDAO{
<<<<<<< HEAD

	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.ExamMapper";
	
	@Override
	public void register(ExamVO exam) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
	
//		SimpleDateFormat simple=new SimpleDateFormat(exam.getStartTime());
//		paramMap.put("startTime", board.getBno());
//		
=======
	
	@Inject
	private SqlSession session; //session for sql connetion
	private String namespace = "com.jdp.mapper.ExamMapper";

	@Override
	public void register(ExamVO exam) throws Exception {
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
		session.insert(namespace+".register", exam);
	}

	@Override
	public void delete(ExamVO exam) throws Exception {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
=======
		session.delete(namespace+".delete", exam);
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
	}

	@Override
	public void readExam(ExamVO exam) throws Exception {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		
=======
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
	}

	@Override
	public void update(ExamVO exam) throws Exception {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
=======
		session.update(namespace+".update", exam);
	}

	@Override
	public List<ExamVO> listExam(int subjectCode) throws Exception {
		return session.selectList(namespace+".listExam", subjectCode);
	}

	@Override
	public void incrementCnt(ExamVO exam) throws Exception {
		session.update(namespace+".incrementCnt", exam);
>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
	}

}
