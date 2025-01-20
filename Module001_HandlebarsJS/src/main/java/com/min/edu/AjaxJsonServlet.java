package com.min.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/AjaxJsonServlet")
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8;");
		
		JSONObject jsonObj01 = new JSONObject();
		jsonObj01.put("comment", "굿모닝");
		jsonObj01.put("name", "외국인");
		JSONObject jsonObj02 = new JSONObject();
		jsonObj02.put("comment", "맥주");
		jsonObj02.put("name", "독일");
		JSONObject jsonObj03 = new JSONObject();
		jsonObj03.put("comment", "안녕하세요");
		jsonObj03.put("name", "한국인");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObj01);
		jsonArray.add(jsonObj02);
		jsonArray.add(jsonObj03);
		
		JSONObject obj = new JSONObject();
		obj.put("commonts", jsonArray);
		System.out.println("전달되는 jSON Arr 문자열 : \n\n" + obj.toJSONString());
		response.getWriter().print(obj.toJSONString());
	}

}
