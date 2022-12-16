package com.phone.contacts.exception;

public class ErrorResponse {
	private int code;
private String message;

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Integer getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public ErrorResponse(int code, String message) {
	super();
	this.code = code;
	this.message = message;
}


}
