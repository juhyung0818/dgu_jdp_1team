package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdp.domain.MemberVO;
import com.jdp.domain.SubjectVO;
import com.jdp.exception.NotExistSubjectException;
import com.jdp.exception.NotExistSubjectNameException;
import com.jdp.persistence.ExamDAO;
import com.jdp.persistence.QuestionDAO;
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
	@Inject
	private ExamDAO examDao;
	@Inject
	private QuestionDAO questionDao;
	
	@Override
	public void register(String subjectName, String uid) throws Exception {
		if(subjectName.length() == 0){
			throw new NotExistSubjectNameException();
		}
		subjectDao.register(subjectName, uid);
	}

	@Override
	public void modify(int subjectCode, String subjectName) throws Exception {
		if(subjectName.length() == 0){
			throw new NotExistSubjectNameException();
		}
		subjectDao.modify(subjectCode, subjectName);
	}

	@Transactional
	@Override
	public void joinSubject(MemberVO member) throws Exception {
		if(subjectDao.checkSubject(member.getSubjectCode()) > 0){
			subjectDao.joinSubject(member);
		} else {
			throw new NotExistSubjectException();
		}
	}

	@Override
	public List<SubjectVO> listStudent(String uid) throws Exception {
		return subjectDao.listStudent(uid);
	}

	@Override
	public List<SubjectVO> listTeacher(String uid) throws Exception {
		return subjectDao.listTeacher(uid);
	}

	/**
	 * delete subject to use subjectCode
	 */
	@Transactional
	@Override
	public void delete(int subjectCode) throws Exception {
		List<Integer> list = examDao.examCodeList(subjectCode);
		for(int e : list){
			questionDao.delete(e);
		}
		examDao.deleteAll(subjectCode);
		subjectDao.delete(subjectCode);
	}

	/**
	 * find subjectCode to use usbjectCode
	 */
	@Override
	public String getSubjectName(int subjectCode) throws Exception {
		return subjectDao.getSubjectName(subjectCode);
	}

	/**
	 * student leave subject
	 * uid : user id, subjectCode : subject code
	 */
	@Override
	public void leaveSubject(String uid, int subjectCode) throws Exception {
		subjectDao.leaveSubject(uid, subjectCode);
	}
}
