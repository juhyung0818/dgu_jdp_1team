
package com.jdp.exception;
/**
 * When insert MySQL, exam already exists
 * @author YJH
 * 2016.11.25.Fri
 */
public class DuplicationExamException extends PrimaryKeyDuplicatedException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.DUPLICATE_EXAM;
	}
}
