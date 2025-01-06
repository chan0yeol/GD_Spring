package com.min.edu.framework;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.handle.Handler;

public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = -2176793230201521125L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}
	
	/**
	 * TODO 004 주소로 요청을 처리하여 invoke하여 처리해 주는 Front-Controller 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletFramework 요청 작동 ");
		
		// TODO 005-01 요청된 주소에서 해당 class를 invoke 하기 위해 이름 추출
		/*
		 * http://localhost:8080/DispatcherServlet/app/Hello.do?name=coffee
		 * 위의 주소에서 Hello 단어를 추출하고
		 * Hello => com.min.edu.service.HelloHandler
		 * 처리가 되면 Invoke 실행하여 Reflection 으로 해당 객체를 만들어 준다. 
		 */
		
		try {
			Handler handler = handleMapping(req);
			System.out.println("Invoke와 Reflection을 통해 생성된 클래스 : " + handler.getClass());
			
			// TODO 005-02 생성된 객체를 통햇서 기능(handle())을 실행한다.
			// 입력받은 handler 클래스에 있는 기능메소드인 handle을 실행한다.
			String viewName = handleAdapter(handler, req, resp);
			System.out.println("실행된 클래스의 결과를 String으로 가져옴 : " + viewName);
			
			// TODO 005-03 반환된 결과인 String을 사용하여 구성할 JSP의 경로를 작성하고 이동 (HelperView)
			helperView(viewName,req,resp);
			System.out.println("화면 이동 끝");
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	private void helperView(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		String uri = prefix+viewName+suffix;
		req.getRequestDispatcher(uri).forward(req, resp);
	}

	private String handleAdapter(Handler handler, HttpServletRequest req, HttpServletResponse resp) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method handleMethod =  handler.getClass().getMethod("handle", HttpServletRequest.class,HttpServletResponse.class);
		return (String) handleMethod.invoke(handler, req, resp);
	}

	private Handler handleMapping(HttpServletRequest req) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String uri = req.getRequestURI(); // 요청된 주소를 가져옴
		System.out.println("요청된 주소 " + uri);
		String handleName = "com.min.edu.service."+uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."))+"Handler";
		System.out.println("실행될 class의 path 를 String으로 가져옴 : "+handleName);
		
		Class handlerClass =  Class.forName(handleName);
		Constructor<?> constructor = handlerClass.getConstructor(null);
		return (Handler) constructor.newInstance();
	}
}
















