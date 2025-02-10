package com.min.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping("/index.do")
	public String index() {
		return "index";
	}
	
	// TODO 002 servletContext에 값을 저장하여 값을 공유하는 소스 작성
	@PostMapping("/login.do")
	public String home(String name, HttpServletRequest request) {
		log.info("[POST-root] HomeController - /login.do , name : {}", name);
		request.getSession().getServletContext().setAttribute("loginInfo", name);
		return "home";
	}
	
	// TODO 003 로그아웃
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		log.info("[GET-root] HomeController - /logout.do ");
		log.info("servletContext에서 로그인 정보인 loginInfo를 삭제");
		session.getServletContext().removeAttribute("loginInfo");
		return "home";
	}
}
