package com.jdp.service;

import java.util.List;

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
	//student join subject
	public void joinSubject(MemberVO member) throws Exception;
	//teacher delete subject
	public void delete(int subjectCode) throws Exception;
	//get subject name
	public String getSubjectName(int subjectCode) throws Exception;
	//student leave subject
	public void leaveSubject(String uid, int subjectCode) throws Exception;
	//check user access authority
	public int checkAuthority(String uid, int subjectCode) throws Exception;
}
