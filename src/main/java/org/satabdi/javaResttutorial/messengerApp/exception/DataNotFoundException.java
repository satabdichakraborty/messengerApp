package org.satabdi.javaResttutorial.messengerApp.exception;

public class DataNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}

}
