package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

// TODO 02801 ModelAttributeController 작성
@Controller
@Slf4j
public class ModelAttributeController {
	// TODO 02802 @ModelAttribute 작성
	@ModelAttribute("userId")
	public String getUserId(HttpSession session) {
		UserVo loginVo = (UserVo) session.getAttribute("loginVo");
		log.info("로그인 된 Session에서 ID만 추출 : {}",loginVo.getId());
		return loginVo.getId();
	}
	
	@GetMapping("/modelAttribute.do") // TODO 02803 @ModelAttribute 사용
	public String modelAttributeUse(@ModelAttribute("userId") String id , Model model) {
		log.info("[GET] - /modelAttribute.do : @ModelAttribute는 Controller가 호출되기 전에 먼저 호출된다.");
		// 게시판에서 삭제, 글을 수정할 때 session의 정보를 판단하여 처리 한다면
		log.info("@ModelAttribute(userId) : {} ", id);
		model.addAttribute("id",id);
		return "modelAttributeUse";
	}
}
