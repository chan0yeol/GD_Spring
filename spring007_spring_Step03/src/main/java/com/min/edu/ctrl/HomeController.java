package com.min.edu.ctrl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.InfoDto;

import lombok.extern.slf4j.Slf4j;
// TODO 005 Step2 Controller 작성
@Controller
@Slf4j
public class HomeController {
	// TODO 10602 Properties 파일을 읽어서 사용하는 Annotation
	@Value("${driver}")
	private String driverClassName;
	
	/*
	 * home.do의 주소 요청이 들어왔을때 처리되는 RequestMapping
	 * 1) @GetMapping은 GET 요청만 처리 
	 * 2) Spring의 Model객체는 HttpServletRequest 객체를 구현한 Spring 객체이다.
	 */
	@GetMapping("/home.do")
	public String home(String name, HttpServletRequest request, Model model) {
		
		log.info("Properties 파일을 읽어서 사용하는 Annotation은 @Value : {} ", driverClassName);
		
		log.info("HomeController @GetMapping 요청 home.do");
		log.info("요청받은 parameter name 값 : {}",name);
		log.info("HttpServletRequest 으로 parameter 값 : {} ", request.getParameter(name));
		model.addAttribute("rtnValue", name+"님 반갑습니다.");
		
		// 만약 return의 값이 없다면 메소드의 이름으로 화면을 요청함.
		// 반환 타입이 void 이거나 return이 null 일때 => 메소드명으로 화면의 이름 요청(DispatcherServlet) 한다.
		return "home";
	}
	
	/* TODO 102 화면에서 넘겨 받은 값을 처리하는 방법 
	 *  1) Spring에서는 요청 처리되는 method에 객체를 선언하면 자동으로 setter를 호출하여 객체를 생성하고 값을 입력해준다.
	 *  2) Spring에서 Map으로 값을 처리하게 되면 반드시 @RequestParam을 작성해주어야 하고, 화면에서 name이 key 가 되고 value가 값이된다. <name : value>
	 *  3) request.getParameterValues("")는 String[] 타입으로 만 처리 된다.
	 *  	하지만 Spring에서는 @RequestParam List<String> name 으로 선언하면 자동으로 화면의 name이 ch인 여러개의 값이 List로 Binding 된다.
	 *  
	 */
	@PostMapping("/home.do")
	public String home(InfoDto infoDto,
						HttpServletRequest request,
						@RequestParam Map<String,Object> infoMap) {
		log.info("HomeController @PostMapping 요청 /home.do");
		// 1) servlet 에서는 HttpServletRequest에서 parameter로 받ㄴ은 후에 각 타입에 맞는 형변환 하여 DTO/Map로 객체로 변환
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		String address = request.getParameter("address");
//		InfoDto reqDto = InfoDto.builder()
//						.name(name)
//						.age(Integer.parseInt(age))
//						.address(address)
//						.build();
//		System.err.println("request로 처리된 Dto : "+ reqDto);
		// 2) Spring에서는 Binding문법을 사용하기 때문에 사용되는 객체에 setter가 있다면 자동으로 해당 객체를 만들고 값을 입력해 준다.
		log.info("spring의 Binding : {}", infoDto);
		
		// 3) Spring에서 Map을 통해 Parameter를 처리할 경우 @RequestParam을 작성하고 Map을 작성하면 자동으로 name은 key 값은 value로 매핑된다.
		log.info("Spring의 Map Binding : {}", infoMap);
		return "home";
	}
	
	/* TODO 101 RequestMapping의 method 다중 처리
	 * info.do의 요청 GET, POST, PUT, TRACE와 같이 여러개의 요청처리를 해야한다면 
	 * @RequestMapping의 method의 입력을 {} 안에 여러개를 선언하여 요청의 동작이 될 수 있다.
	 */
//	@RequestMapping(value = "/info.do", method = {RequestMethod.GET, RequestMethod.POST})
//	@GetMapping("/info.do")
	@PostMapping("/info.do")
	public String info() {
		log.info("HomeController /init.do 요청");
		
		
		return "info";
	}
	
	/* TODO 103 redirect의 parameter 범위
	 * redirect는 Spring의 Controller Mapping을 재요청하고 화면요청은 아님.
	 * parameter의 범위는 redirect로 요청된 Controller는 안된다.
	 * 값을 전송하기 위해서는 Model 객체에 담아줘야 한다.
	 * 받는 곳에서 parameter의 변수명만 맞다면 parameter, Scope를 모두 처리 해준다.
	 */
	@GetMapping("/redircet.do")
	public String redircet(String name, Model model, HttpServletRequest request) {
		log.info("HomeController /redirct.do 요청 : {}", name);
		// 1) Model을 통한 Controller의 값 공유
//		model.addAttribute("name", name+ "redirect에서 전송"); // Controller 에서만 공유
//		return "redirect:/home.do"; // GET요청

//		2)redirect 요청시 parameter 의 전송 
//		return "redirect:/home.do?name=parameterValue"; // GET요청
		
		request.setAttribute("name", "HttpServletRequest 값");
		return "redirect:/home.do"; 
	}
}
