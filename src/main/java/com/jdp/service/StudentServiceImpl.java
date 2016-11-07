package com.jdp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jdp.domain.StudentVO;
import com.jdp.persistence.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService{

	@Inject StudentDAO studentDAO;
	

}
