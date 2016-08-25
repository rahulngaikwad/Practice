package com.parking.system.interfaces.exception;

public class CreateServiceException extends ServiceException {

	private static final long serialVersionUID = -3410987050367306627L;

	public CreateServiceException(String message) {
		super(message);
	}

	public CreateServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
