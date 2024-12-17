package com.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(RuntimeException.class)
	public void handleRuntimeException(RuntimeException e) {
		log.error("RuntimeException: {}", e.getMessage(), e);
	}

}
