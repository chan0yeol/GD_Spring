package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

// TODO 02501 다른 Controller에서의 session사용
@Controller
@Slf4j
public class Session_2_Controller {
	
	@GetMapping("/test03.do")
	public String test03(@SessionAttribute(value = "sessionTest", required = false) String sessionTest,
							SessionStatus sessionStatus) {
		log.info("[GET] - /test03.do");
		log.info("다른 Controller에서의 @SessionAttributes로 생성한 Session 을 사용 할 수 있다. : {}",sessionTest);
		// TODO 02502 생성하지 않은 다른 Controller에서의 SessionStatus를 통한 @SessionAttributes의 삭제는 불가능
		sessionStatus.setComplete();
		return "sessionCheck";
	}
	
	// TODO 02503 다른Controller에서의 SessionStatus
	@GetMapping("/result03.do")
	public String result03(@SessionAttribute(value = "sessionTest", required = false) String sessionTest,
							SessionStatus sessionStatus,
							HttpSession session) {
		log.info("[GET] - /result03.do");
		log.info("다른 Controller에서는 @SessionAttributes를 삭제하기 위한 SessionStatus가 동작하지 않는다.");
		System.out.println(session.getAttribute("httpSessionTest"));
		System.out.println(sessionTest);
		return "sessionCheck";
	}
	// TODO 02601 다른 Controller에서의 HttpSession의 삭제
	@GetMapping("/test04.do")
	public String test04(HttpSession session) {
		log.info("[GET] - /test04.do");
		// TODO 02504 다른 Controller에서 @SessionAttributes의 삭제
		// 다른 Controller에서 HttpSession의 remove를 통해 @SessionAttributes를 삭제할 수 있다.
		session.removeAttribute("sessionTest");
		session.removeAttribute("httpSessionTest");
		return "sessionCheck";
	}
	
	// TODO 02602 세션삭제후 확인
	@GetMapping("/result04.do")
	public String result04(@SessionAttribute(value = "sessionTest", required = false) String sessionTest,
			HttpSession session) {
		System.out.println("httpSessionTest : " + session.getAttribute("httpSessionTest"));
		System.out.println("sessionTest : " + sessionTest);
		return "sessionCheck";
	}
}
