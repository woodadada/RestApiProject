package com.jw.configuration;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jw.configuration.exception.BadRequestException;
import com.jw.configuration.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * 
 * @author wjddn
 * 
 * @RestController라는 어노테이션이 붙어있는 클래스에서 발생한 에러를 모두 처리하는 로직입니다. 
 * Service 클래스에서 예외를 던지면 Controller에서 받도록 설계한 이유가 
 * @RestControllerAdvice라는 어노테이션을 이용하여 한번에 예외를 모아 처리해주기 위해서입니다.
 */
@RestControllerAdvice
public class RestExceptionHandler {
	
	/**
	 * @ResponseStatus 어노테이션은 해당 Response가 내려질 때, API 호출자가 받을 HttpStatus를 정해주는 어노테이션입니다.
	 * BadRequestException 발생 시 ErrorResponse 객체 생성 후 리턴
	 * @param e
	 * @param req
	 * @return
	 */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handlerRuntimeException(Exception e, 
    		HttpServletRequest req) {
    	log.error("===================== Handler RuntimeException =====================");
    	e.printStackTrace();
    	return new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
    }
}
