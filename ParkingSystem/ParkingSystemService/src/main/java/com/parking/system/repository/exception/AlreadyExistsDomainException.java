package com.parking.system.repository.exception;

public class AlreadyExistsDomainException extends CreateDomainException {

	private static final long serialVersionUID = -7329964283383537362L;

	public AlreadyExistsDomainException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlreadyExistsDomainException(String message) {
		super(message);
	}

}
