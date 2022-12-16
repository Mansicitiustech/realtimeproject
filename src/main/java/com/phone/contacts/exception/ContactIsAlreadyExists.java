package com.phone.contacts.exception;

public class ContactIsAlreadyExists extends Exception {
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public ContactIsAlreadyExists(String message) {
	super();
	this.message = message;
}

}
