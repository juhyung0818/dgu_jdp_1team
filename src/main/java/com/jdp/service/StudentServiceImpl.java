package com.jdp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.StudentVO;
import com.jdp.persistence.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService{

	@Inject StudentDAO studentDAO;
	@Override
	public boolean login(StudentVO student) throws Exception {
		List<StudentVO> list=studentDAO.login(student);
		if(list.size()!=0)
		{
			return true;
		}
		return false;
	}

}
