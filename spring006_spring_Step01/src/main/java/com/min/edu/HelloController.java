package com.min.edu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {
	
	/* TODO 003 요청에 따른 요청 처리 RequestMapping 
	 * 요청 받은 처리를 @Controller가 처리 해준다.
	 * 주소에 맞는 요청 @RequestMapping으로 처리해준다.
	 * 처리되는 프로토콜은 method = RequestMethod.GET 해당 RequestMapping이 Get요청을 처리함을 선언함.
	 * Spring에서 Parameter의 처리는 메소드의 Parameter 선언으로 처리 한다
	 *  ㄴ QueryString의 key와 같은 이름의 parameter변수에 자동으로 값이 담긴다.
	 *    선언되어 있는 타입으로 자동으로 형변환된다. 
	 */
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String hello(@RequestParam String name, Model model) {
		log.info("hello 전달 받은 요청 값");
		model.addAttribute("result", name);
		return "/WEB-INF/views/hello.jsp";
	}
	@GetMapping("/param")
	public String param(@RequestParam String name, 
						@RequestParam int month,
						HttpServletRequest request,
						Model model ) {
		log.info("param 전달 받은 값 : {} {}", name,month);
		// 기존 방법 HttpServleRequest 에서 getParameter를 통해 호출 -> 필요하면 Casting
		String reqName = request.getParameter("name");
		int reqMonth = Integer.parseInt(request.getParameter("month"));
		System.out.printf("request 처리 방식 : name : %s, month : %d \n", reqName, reqMonth);
		log.info("Spring에서 자동으로 Binding을 지원 : {},{}", name, month);
		model.addAttribute("name",name);
		model.addAttribute("month",month);
		return "/WEB-INF/views/param.jsp";
	}
}
