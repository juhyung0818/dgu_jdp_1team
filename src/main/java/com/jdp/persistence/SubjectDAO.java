package com.jdp.persistence;

import java.util.List;

import com.jdp.domain.MemberListVO;
import com.jdp.domain.MemberVO;
import com.jdp.domain.SubjectVO;

/**
 * Database Access Object
 * interface to access Subject table in database
 * @author YJH
 * 2016.11.01.Thu
 */

public interface SubjectDAO {

	//add subject in database 
	public int register(String subjectName, String uid) throws Exception;
	//update subject in database
	public void modify(int subjectCode, String subjectName) throws Exception;
	//select subjectName in database for student
	public List<SubjectVO> listStudent(String uid) throws Exception;
	//select subjectName in database for teacher
	public List<SubjectVO> listTeacher(String uid) throws Exception;
	//student join subject
	public void joinSubject(MemberVO member) throws Exception;
	//manage student
	public List<MemberListVO> listMember(String uid, int subjectCode) throws Exception;
	//manage student2
	public List<MemberListVO> listMember2(MemberListVO memberListVO) throws Exception;
}
