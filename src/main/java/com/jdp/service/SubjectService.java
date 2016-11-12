package com.jdp.service;

import java.util.List;

import com.jdp.domain.MemberListVO;
import com.jdp.domain.MemberVO;
import com.jdp.domain.SubjectVO;
/**
 * Service interface about Subject
 * @author YJH
 * 2016.10.19.Wed
 */
public interface SubjectService {
	
	public int register(String subjectName, String uid) throws Exception;
	public void modify(int subjectCode, String subjectName) throws Exception; 
	public List<SubjectVO> listStudent(String uid) throws Exception;
	public List<SubjectVO> listTeacher(String uid) throws Exception;
	public void joinSubject(MemberVO member) throws Exception;
}
