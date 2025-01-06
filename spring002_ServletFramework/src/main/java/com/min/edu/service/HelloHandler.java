package com.min.edu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.handle.Handler;

// TODO 002 요청받은 주소에서 invoke를 통해서 결과를 reflection 하는 로직처리르 가지고 있는 클래스
/**
 * JDBC를 처리하거나 요청 받은 parameter를 처리하여 실행되는 class
 */
public class HelloHandler implements Handler {

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("invoke Pattern에 의해 실행되는 Service ");
		// 1) parameter 처리 
		String name = request.getParameter("name");
		
		// 2) 처리된 결과를 jsp에 전달하기 위해 scope에 담아준다.
		request.setAttribute("result", name+"님 반갑습니다.");
		return "hello";
	}
	
}
