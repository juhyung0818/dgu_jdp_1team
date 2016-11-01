package com.jdp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.SubjectVO;
import com.jdp.persistence.SubjectDAO;

/**
 * Service class about Subject
 * @author YJH
 * 2016.11.01.Thu
 */
@Service
public class SubjectServiceImpl implements SubjectService{

	@Inject
	private SubjectDAO subjectDao;
	
	@Override
	public void register(SubjectVO subject) throws Exception {
		subjectDao.register(subject);
	}

	@Override
	public void modify(int subjectCode, String subjectName) throws Exception {
		subjectDao.modify(subjectCode, subjectName);
	}

}
