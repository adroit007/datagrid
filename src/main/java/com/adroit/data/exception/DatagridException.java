package com.adroit.data.exception;

/**
 * The parent exception class used across this framework
 * 
 * @author Adroit
 *
 */
public class DatagridException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;

	public DatagridException(String message, Throwable cause) {
		this.message = message;
	}

	public DatagridException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
