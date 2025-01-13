package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.EmpDto;
import com.min.edu.repository.IEmpDao;
import com.min.edu.service.IEmpService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private IEmpDao dao;
	
	@GetMapping("/login.do")
	public String loginGet() {
		return "login";
	}
	
	@PostMapping("/login.do")
	public String login(String name, int empno, Model model , HttpSession session) {
		log.info("login POST ");
		EmpDto loginDto = dao.login(EmpDto.builder().ename(name).empno(empno).build());
		if(loginDto != null) {
			session.setAttribute("emp", loginDto);
			if(loginDto.getDeptno() == 50 ) {
				return "/productAllInfo.do";
			} else if(loginDto.getDeptno() == 60) {
				return "/stockAllInfo.do";
			} else if(loginDto.getDeptno() == 70) {
				return "/stockOutAllInfo.do";
			}
		} else {
			String fail = "로그인 실패";
			model.addAttribute("fail",fail);
		}
		return "/login.do";
	}
}
