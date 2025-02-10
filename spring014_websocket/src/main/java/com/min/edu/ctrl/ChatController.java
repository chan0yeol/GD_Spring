package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletConfigAware;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController implements ServletConfigAware {
	private ServletContext servletContext;

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		servletContext = servletConfig.getServletContext();
		System.out.println("setServletConfig 생성 값 :" + servletContext);
	}
	
	@GetMapping("/chatOneToMany.do")
	public String chatOneToMany() {
		log.info("[GET] 1:N 화면이동 요청 ");
		return "chatOneToMany";
	}
	
	// TODO 010 그룹채팅 이동화면
	@GetMapping("/chatGroup.do")
	public String chatGroup(){
		log.info("[GET] 그룹채팅 화면이동 요청 ");
		return "chatGroup";
	}
	
	// TODO 012 사용의 아이디와 그룹을 session에 담고, 채팅참여자의 전체 목록을 ServletContext에 담아준다.
	@GetMapping("/socketOpen.do")
	public String socketOpen(String gr_id, String mem_id, HttpSession session) {
		
		// Parameter의 정보를 HttpSession에 담는 작업으로 자동으로 Bean의 HandShakeHandler에 의해서 WebSocketSession에 담아준다.
		// 참여자를 HttpSession에 담는다.
		
		session.setAttribute("gr_id", gr_id);
		session.setAttribute("mem_id", mem_id);
		
		//서버 전체에 계속해서 참여자의 정보를 담기 위해서 ServletContext를 사용한다.
		
		Map<String, String> chatList = (Map<String, String>)servletContext.getAttribute("chatList");
		if(chatList == null) {
			chatList = new HashMap<String, String>();
			chatList.put(mem_id, gr_id);
			servletContext.setAttribute("chatList", chatList);
		} else {
			chatList.put(mem_id, gr_id);
			servletContext.setAttribute("chatList", chatList);
		}
		log.info("웹소켓 목록 : {}", servletContext.getAttribute("chatList"));
		
		return "chatGroupView";
	}
	
	// TODO 019 채팅을 닫은 후에 자동으로 참여 목록을 삭제해주는 REST
	@PostMapping("/socketOut.do")
	@ResponseBody
	public void socketOut(HttpSession session) {
		log.info("socket 종료");
		String mem_id = (String)session.getAttribute("mem_id");
		Map<String, Object> chatList = (Map<String, Object>)servletContext.getAttribute("chatList");
		
		log.info("기존 접속 회원 리스트 : {}", chatList);
		if(chatList != null) {
			chatList.remove(mem_id);
		}
		log.info("갱신 접속 회원 리스트 : {}",chatList);
		servletContext.setAttribute("chatList", chatList);
	}
	
	//TODO 020 입장/퇴장시 호출되어 servletcontext에 있는리스트를 조회하여 JSON으로 변환
	@PostMapping("/viewChatList.do")
	@ResponseBody
	public Map<String, Map<String, String>> viewChatList(){
		Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();
		Map<String, String> chatList = (Map<String, String>)servletContext.getAttribute("chatList");
		map.put("list", chatList);
		log.info("접속회원 전체 조회 리스트 : {}",map);
		return map;
	}
}
