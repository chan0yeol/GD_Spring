package com.min.edu.ctrl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
// TODO 02001 로그인Controller 작성
@Controller
@Slf4j
@RequiredArgsConstructor
//@SessionAttributes("loginVo")
public class LoginController {
	private final IUserService userService;
	
	/*
	 * parameter 받는 방식 
	 * UserVo vo => vo의 setter 요청
	 * @RequestParam Map => {name:key} 로 매핑하여 받아온다
	 * String id, String password // name과 같은 parameter에 형변환을 통해서 
	 */
	@PostMapping("/login.do")
	public String login(@RequestParam Map<String, Object> map, // {name:key} 로 매핑하여 받아온다 
						UserVo vo, // vo의 setter 요청
						String id, String password, // name과 같은 parameter에 형변환을 통해서 
						HttpSession session, // Scope
						Model model, //Spring Scope => HttpServletRequest이다. 하지만 redirect를 통해서 값 전달이 가능하다.
						HttpServletRequest request) {
		log.info("[POST] - /login.do {} , {}", map, vo);
		UserVo loginVo = userService.login(map);
		
		// 일반 요청 처리에서 
		// 반환타입이 문자열(String)일 경우는 DispatcherServlet에 의해 viewResolver가 호출 된다.
		// 반환타입이 redirect:문자열 인경우 DispatcherServlet에 의해 Spring Container의 RequestMapping을 찾는다.
		//    -> redircet를 통한 Scope의 전달은 param / HttpServletRequest 는 전달 X 
		//	   Model 객체는 전달 가능 
		if(loginVo == null) {
			return "redirect:/main.do"; // "redirect:/main.do?seq=1" param을 전달하고 싶다면 
		} else {
			// TODO 02002 Spring의 Session 처리 
			// org.springframework.ui.Model 은 Spring Container의 Request 객체이기 때문에. @RequestMapping과 값을 공유함
			// 1) org.springframework.ui.Model => model.addAttribute("loginVo",loginVo); => requestScope처리가 된다.
			// 2) javax.servlet.HttpSession session => session.setAttribute("loginVo",loginVo); => sessionScope 에 저장 
			// 3) @SessionAttribute("loginVo") => model.addAttribute("loginVo",loginVo); => session + Spring Container Session Scope
			model.addAttribute("loginVo", loginVo);
			loginVo.setPassword("9999");
			request.setAttribute("loginVo", loginVo);
			
			session.setAttribute("loginVo", loginVo);
			// HttpServletRequest 보다 Model이 우선이다
			model.addAttribute("containValue","model");
			request.setAttribute("containValue","request");
			return "afterLogin";
		}
	}
	
	// TODO 02102 logoutController 작성 session 설명
	@GetMapping("/logout.do") 
	public String logout(HttpSession session, Model model) {
		log.info("[GET] - /logout.do 요청");
		// session의 삭제, session.invalidate(), session.removeAttribute("이름");
		UserVo modelVo = (UserVo) model.getAttribute("loginVo");
		if(modelVo == null) {
			log.info("model scope는 HttpServletRequest Scope를 가지기 때문에 값을 유지 할 수 없다. : {}", modelVo);
		}
		UserVo sessionVo = (UserVo) session.getAttribute("loginVo");
		if(sessionVo != null) {
			log.info("HttpSession은 삭제되기 전 까지 유지된다. : {} ", sessionVo);
		}
		
		// TODO 02103 session의 삭제
		// 세션의 삭제 session.invalidate() - 세션을 무효화 
		// 		    session.removeAttribute("해당 name")
		
		try {
//			session.invalidate(); // HttpSession에 담긴 모든 객체를 사용 할 수 없도록 한다.
			UserVo vo = (UserVo) session.getAttribute("loginVo");
		} catch (Exception e) {
			log.info("invalidate는 객체 자체를 사용할 수 없도록 무효화 하기 때문에 : getAttribute를 호출하면 세션이 무효화 되었습니다.");
			e.printStackTrace();
		}
		
		session.removeAttribute("loginVo");
		UserVo removeVo = (UserVo) session.getAttribute("loginVo");
		
		log.info("HttpSession의 scope 공통 메소드를 통해서 remove하면 해당 객체만 삭제된다 : {}",removeVo );
		return "redirect:/main.do";
	}
}




















