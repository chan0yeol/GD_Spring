package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

// TODO 02201 @SessionAttributes 를 통한 세션처리
@Controller
@Slf4j
@SessionAttributes(names = { "sessionTest" })
public class Session_1_Controller {
	@GetMapping("/sessionInit.do")
	public String sessionInit(Model model, HttpSession httpSession) {

		log.info("[GET] - /sessionInit.do : HttpSession 및 @SessionAttributes 테스트 값 입력");
		log.info("HttpSesssion은 httpSessionTest / @SessionAttributes는 sessionTest");
		httpSession.setAttribute("httpSessionTest", "sessionInit.do 에서 입력된 HttpSession의 값");
		model.addAttribute("sessionTest", "sessionInit.do에서 입력된 @SessionAttributes 값");
		return "sessionCheck";
	}

	// TODO 02204 @SessionAttributes 삭제 Controller 작성
	@GetMapping("/test01.do")
	public String test01(SessionStatus sessionStatus) {
		log.info("[GET] - /test01.do");
		log.info("@SessionAttributes는 SessionStatus의 setComplte() 를 통해 제거");
		sessionStatus.setComplete();
		return "sessionCheck";
	}

	@GetMapping("/result01.do")
	public String result01(HttpSession session,
			@SessionAttribute(value = "sessionTest", required = false) String sessionTest) {
		log.info("[GET] - /result01.do");
		System.out.println("\n\n @SessionAttributes : " + sessionTest);
		System.out.println("\n\n HttpSession :" + session.getAttribute("httpSessionTest"));
		return "sessionCheck";
	}
	
	// TODO 02302 HttpSesssion 삭제 Controller 작성 
	@GetMapping("/test02.do")
	public String test02(HttpSession session,
			@SessionAttribute(value = "sessionTest", required = false) String sessionTest) {
		log.info("[GET] - /test02.do");
		
		// TODO 026023 @SessionAttributes를 session.removerAttribute()를 통해서 삭제
			// 자기 자신의 Controller에서 @SessionAttributes를 생성했기 때문에 HttpSession을 통해 핸들링이 불가능하다.
		session.removeAttribute("sessionTest");
		
		// TODO 02303 invalidate(),removeAttribute()의 차이
		session.invalidate(); // invalidate() 해도 @SessionAttributes로 설정한 session은 안사라짐
//		session.removeAttribute("httpSessionTest"); 
//		System.out.println("session 무효화 테스트 : " + session.getAttribute("httpSessionTest")); 
		// invalidate()를 하고 사라진 session을 호출하면 세션무효화 Exception이 걸리고
		// removeAttribute()를 하면 null로 된다.
		System.out.println(sessionTest);
		return "sessionCheck";
	}
	
	@GetMapping("/result02.do")
	public String result02() {
		return "sessionCheck";
	}
		
	
}
