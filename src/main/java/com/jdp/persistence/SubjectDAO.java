package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.SubjectVO;

public interface SubjectDAO {
	public void register(SubjectVO subject) throws Exception;
	public void delete(int subjectCode) throws Exception;
	//modify about exam
	public List<SubjectVO> listExam() throws Exception;
}
