package com.parking.system.interfaces.exception;

public class ReadServiceException extends ServiceException {

	private static final long serialVersionUID = -3410987050367306627L;

	public ReadServiceException(String message) {
		super(message);
	}

	public ReadServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
