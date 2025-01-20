package com.util.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * Spring Framework의 SPA(Single Page Application)개발을 위한 라이브러리
 * Controller 에서 javascript를 통한 Alert 이동 흐름 제어  
 * @author 오찬열
 * @since 2025.01.20
 * @version 1.0
 * 
 */
public class SpringUtils {
	
	/**
	 * HttpServletResponse에 이동하는 URL과 msg를 입력받아 javascript alert을 동작
	 * @param response javax.servlet.HttpServletResponse 브라우저에 응답해주는 객체
	 * @param msg Alert의 메세지
	 * @param url 이동흐름 요청 경로
	 * @throws IOException
	 */
	public static void responseAlert(HttpServletResponse response,
										String msg,
										String url) throws IOException {
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script> alert('"+msg+"'); location.href='./"+url+"';</script>");
		out.flush();
	}
}
