package com.example.demo.restfulapi.exception;

public class ExceptionCustom extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Exception that can return message
     */
    public ExceptionCustom(String message) {
        super(message);
    }
}
