package com.parking.system.interfaces.exception;

public abstract class ServiceException extends Exception {
	private static final long serialVersionUID = 5309745256228735404L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}
}
