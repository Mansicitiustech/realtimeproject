package com.phone.contacts.exception;

public class ContactNotFoundException extends Exception {
private String message;

public ContactNotFoundException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
