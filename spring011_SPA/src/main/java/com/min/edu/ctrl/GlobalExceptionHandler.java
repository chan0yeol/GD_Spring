package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.util.spring.SpringUtils;
// TODO 006 @RestControllerAdvice 를 통한 REST의 예외처리  
/*
 * RESTfull 서버에서 오류가 발생하면 서버는 HTML로 오류를 반환하게 된다. 
 *   하지만 REST에서는 HTML이 아닌 상태에 따른 JSON 값을 반환해줘야 한다.
 *   
 */
// @ControllerAdvice + @ResponseBody의 결합이다.

@RestControllerAdvice
public class GlobalExceptionHandler {
	// TODO 007 @ExceptionHandler 400 BAD Request 예외 처리
	// 400 BAD Request 예외 처리
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, Object>> handleBadRequest(IllegalArgumentException ex){
		Map<String, Object> errorResponse = new HashMap<String, Object>();
		errorResponse.put("isc", "실패");
		errorResponse.put("message", ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
}












