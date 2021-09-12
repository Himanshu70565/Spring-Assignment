package com.bookapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.web.exceptions.BookNotFoundException;
import com.bookapp.web.exceptions.ErrorDetail;

@RestController
@ControllerAdvice
public class BookExceptionalController {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDetail> handle404(Exception ex) {
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setEmail("jhimanshu9922@gmail.com");
		errorDetail.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetail);
	}
}
