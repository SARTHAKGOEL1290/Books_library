package com.books_library.Exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandle {
	
	
		@ExceptionHandler(NullPointerException.class)
		public ResponseEntity<String>handleNoSuchExcp(NullPointerException Null_pnt)
		{
			System.out.println("-----------------------------");
			return new ResponseEntity<String>("the value does not exist in DB",HttpStatus.NOT_FOUND);
		}
		 


}
