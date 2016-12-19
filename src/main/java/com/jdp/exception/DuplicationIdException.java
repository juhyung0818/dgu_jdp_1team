package com.jdp.exception;
/**
 * When insert MySQL, exam already exists
 * @author YJH
 * 2016.11.29.Tue
 */
public class DuplicationIdException extends PrimaryKeyDuplicatedException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.DUPLICATE_ID;
	}
}