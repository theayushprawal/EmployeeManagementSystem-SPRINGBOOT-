package com.ems.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ems.dto.ErrorDetails;


@ControllerAdvice
public class GlobalExceptionHandler {
	//Exception Handler Method acts like catch block
	
		@ExceptionHandler(ResourceNotFound.class)
		public ResponseEntity<ErrorDetails> ResourceNotFoundExceptions(
				ResourceNotFound ex,
				WebRequest request
				){
			
			ErrorDetails details = new ErrorDetails();
			details.setDate(new Date());
			details.setMessage(ex.getMessage());
			details.setDescription(request.getDescription(true));
			
			return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
