package com.parking.system.repository.exception;

public class FinderDomainException extends DomainException {

	private static final long serialVersionUID = 4901129688383680713L;

	public FinderDomainException(String message, Throwable cause) {
		super(message, cause);
	}

	public FinderDomainException(String message) {
		super(message);
	}

}
