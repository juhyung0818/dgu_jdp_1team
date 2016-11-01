package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.SubjectVO;
import com.jdp.persistence.SubjectDAO;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Inject
	SubjectDAO subjectDAO;

	@Override
	public void register(SubjectVO subject) throws Exception {
		subjectDAO.register(subject);
	}

	@Override
	public void delete(SubjectVO subject) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectVO> subjectList() throws Exception {
		return subjectDAO.listExam();
	}

}
