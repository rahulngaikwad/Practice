package com.parking.system.repository.exception;

public abstract class DomainException extends Exception {
	
	private static final long serialVersionUID = 4465829432751473301L;

	public DomainException(String message, Throwable cause) {
		super(message, cause);
	}

	public DomainException(String message) {
		super(message);
	}
}
