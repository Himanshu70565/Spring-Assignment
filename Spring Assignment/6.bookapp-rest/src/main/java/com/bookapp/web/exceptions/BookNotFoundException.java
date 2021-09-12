package com.bookapp.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String message) {
		super(message);
	}

	public BookNotFoundException(Throwable cause) {
		super(cause);
	}
}
