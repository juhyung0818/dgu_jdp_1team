package com.jdp.exception;

/**
 * subject code is not exist or null
 * @author YJH
 * 2016.26.Sat
 */
public class NotExistSubjectNameException extends ExamException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_EXIST_SUBJECT_NAME;
	}
}