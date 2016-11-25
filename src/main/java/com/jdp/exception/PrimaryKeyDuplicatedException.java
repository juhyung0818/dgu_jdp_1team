package com.jdp.exception;

/**
 * When insert MySQL, primary key already exists
 * @author YJH
 * 2016.11.20.Sun
 */
public class PrimaryKeyDuplicatedException extends ExamException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.PRIMARY_KEY_DUPLICATE;
	}
	
}
