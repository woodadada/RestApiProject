package com.jw.configuration.exception;

/**
 * 일반 예외(Checked Exceptino)나 실행 예외(RuntimeException, UnChecked Exception) 중 하나로 만들 수 있습니다.
 *  전자는 Exception을 상속하면 되고,
 *  후자는 RuntimeException을 상속하면 됩니다.
 * @author wjddn
 *
 */
public class BadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BadRequestException(String message) {
		super(message);
	}
	
}
