package com.jdp.exception;

/**
 * subject code is not exist or null
 * @author YJH
 * 2016.26.Sat
 */
public class SubjectNameNotExistException extends NotExistException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.SUBJECT_NAME_NOT_EXIST;
	}
}