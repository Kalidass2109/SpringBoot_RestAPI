package com.kali.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<ExInfo> handleException(Exception e){
		ExInfo info=new ExInfo();
		info.setExCode("SB120923");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDate.now());
		
		return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value=productNotFoundException.class)
	public ResponseEntity<ExInfo> handlePNFE(productNotFoundException pe){
		ExInfo info=new ExInfo();
		info.setExCode("SB120922");
		info.setExMsg(pe.getMessage());
		info.setExDate(LocalDate.now());
		
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

}
