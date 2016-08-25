package com.parking.system.repository.exception;

public class NoSuchEntityDomainException extends FinderDomainException {

	private static final long serialVersionUID = -8364199994661538762L;

	public NoSuchEntityDomainException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchEntityDomainException(String message) {
		super(message);
	}

}
