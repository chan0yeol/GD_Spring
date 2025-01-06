package com.min.edu.handle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO 001 request, response를 처리 할 수 있도록 해주는 interface
/**
 *	Service class가 implements 하여 handle의 기능을 request/response 하여 처리 할 수 있도록 해주는 class
 *
 *  Servlet의 경우 요청의 페이지를 작성하기 위해서 HttpServlet class를 개별로 extends 하여 사용 했었다.
 *  
 *
 */
public interface Handler {
	/**
	 * implements한 class에서 request/response를 구현할 수 있도록 강제 구현
	 * @param request Controller로 부터 전달 받은 HttpServletRequest 
	 * @param response Controller로 부터 전달 받은 HttpServletResponse
	 * @return 화면의 구성이 될 요청 jsp 의 이름 => ViewResolver가 처리해서 해당 이름의 페이지를 요청해줌
	 */
	String handle(HttpServletRequest request, HttpServletResponse response);
}
