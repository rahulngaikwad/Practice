package com.parking.system.repository.exception;

public class CreateDomainException extends DomainException {

	private static final long serialVersionUID = 4901129688383680713L;

	public CreateDomainException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateDomainException(String message) {
		super(message);
	}

}
