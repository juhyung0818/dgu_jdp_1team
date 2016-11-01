package com.jdp.service;

import com.jdp.domain.SubjectVO;
/**
 * Service interface about Subject
 * @author YJH
 * 2016.10.19.Wed
 */
public interface SubjectService {
	
	public void register(SubjectVO subject) throws Exception;
	public void modify(int subjectCode, String subjectName) throws Exception; 
}
