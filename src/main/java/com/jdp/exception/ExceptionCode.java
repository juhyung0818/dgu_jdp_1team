package com.jdp.exception;

/**
 * exception define enum class
 * @author kown
 * 2016.11.20.Sun
 */
public enum ExceptionCode {

	//exception enums
	NONE(200, "success"),
	PRIMARY_KEY_DUPLICATE(100, "primary key duplicated"),DUPLICATE_SUBJECT(101, "duplicated subject"),DUPLICATE_EXAM(102, "duplicated exam"),
	INVALID_TYPE(300, "invalid type"),
	NOT_EXIST(400, "not exist"), SUBJECT_NAME_NOT_EXIST(401, "subject name not exist"),
	ACCESS_DENIED(500, "you don't have permission."), NOT_SUBJECT(501, "not authority subject"), NOT_EXAM(502, "not authority exam");
	
	//fields
	private int code;
	private String message;
	
	//constructor
	ExceptionCode(int code, String message){
		this.code = code;
		this.message = message;
	}

	/* getter, setter methods */
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
