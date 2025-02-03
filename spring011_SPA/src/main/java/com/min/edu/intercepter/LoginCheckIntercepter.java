package com.min.edu.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckIntercepter implements AsyncHandlerInterceptor {
	// TODO 012 Interceptor를 통한 filter
	// preHandle : 비동기 요청이 처리되기 전에 호출, 반환 boolean값을 반환 false를 반환하면 해당 요청은 처리하지 않음
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("[Intercepter] 인터셉터 시작 로그인 session 확인 존재/true 없으면/false logout.do 호출");
		if (request.getSession().getAttribute("loginVo") == null) {
			log.info("[Intercepter] loginVo이 null");
			response.sendRedirect("./logout.do");
			return false;
		}
		return true;
	}

	// postHandle : 요청처리가 되고 뷰가 렌더링 되기 전에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("[Intercepter] 인터셉터 종료");
		AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	// afterCompletion 요청 처리가 완료 되고 view가 렌더링 된 후에 호출 예외가 발생하면 afterCompletion 메소드에서
	// 예외를 처리하고 다시 이벤트를 발생시킬 수 있다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("[Intercepter] 인터셉터 view가 렌더링 된 직후 실행");
		AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("[Intercepter] 비동기(ResponseBody)식 호출이 되었을때 호출");
		AsyncHandlerInterceptor.super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
