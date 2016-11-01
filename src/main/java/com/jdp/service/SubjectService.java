package com.jdp.service;

import java.util.List;

import com.jdp.domain.SubjectVO;

public interface SubjectService {
		//insert a subject
		public void register(SubjectVO subject) throws Exception; 
		//remove a subject
		public void delete(SubjectVO subject) throws Exception; 
		
		//display subject list
		public List<SubjectVO> subjectList() throws Exception;
}
