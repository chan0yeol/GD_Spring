package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.min.edu.service.IUserService;
import com.min.edu.vo.UserVo;
import com.util.spring.SpringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
	
	private final IUserService userService;
	
	@GetMapping("/loginForm.do")
	public String loginForm() {
		log.info("UserController loginForm.do 로그인 화면 이동");
		return "loginForm";
	}
	
	// TODO 005 fetch Ajax 요청을 처리하는 Controller
	@PostMapping(value="/loginCheckText.do", produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> loginCheckText(@RequestBody Map<String, Object> map ,
											HttpSession session){
		
		log.info("UserController 로그인 정보 조회 비동기 처리 loginCheckText.do : {}",map);
		UserVo userVo = userService.login(map);
//		UserVo userVo = null;
		if(userVo != null) {
			session.setAttribute("loginVo", userVo);
			log.info("리턴 값"+"{\"isc\":\"성공\"}");
			return ResponseEntity.ok("{\"isc\":\"성공\"}");
		} else {
//			return new ResponseEntity<String>("등록 오류입니다", HttpStatus.BAD_REQUEST); // text로 전달
			// TODO 008 예외처리 Controller
			throw new IllegalArgumentException("등록 오류입니다");
		}
//		return null; 
	}
	
	@GetMapping(value = "/login.do")
	public String login(HttpSession session, HttpServletResponse response) throws IOException {
		if(session.getAttribute("loginVo") == null) {
			SpringUtils.responseAlert(response, "잘못된 접근입니다. ","loginForm.do");
			return "";
		} else {
			return "redirect:/boardList.do";
		}
	}
	
	@GetMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
	}
}
