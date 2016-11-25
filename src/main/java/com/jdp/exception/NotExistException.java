package com.jdp.exception;

/**
 * Result is not exist
 * @author YJH
 * 2016.11.20.Sun
 */
public class NotExistException extends ExamException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_EXIST;
	}

}
