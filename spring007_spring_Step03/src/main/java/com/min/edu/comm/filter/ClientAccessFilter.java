package com.min.edu.comm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;

import lombok.extern.slf4j.Slf4j;

// TODO 105 Filter 
/*
 * javax.servlet.Filter를 사용하여 가로채기를 통해서 필요한 정보를 수집하거나 이동 흐름을 만들어 낸다.
 * javax.* : tomcat 9, web module 4.0
 * jakarta.* : tomcat 10.1, web module 6.0, Spring Boot 3
 */
@Slf4j
public class ClientAccessFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 요청 정보를 출력 
		HttpServletRequest request = (HttpServletRequest) req;
		
		// request의 객체 정보 : 요청주소 (remoteAddr), 요청param(QueryString)
		// request의 Header 정보 
//			1) User-Agent : 요청된 사용자의 애플리케이션 타입, 운영체제, 브라우저 정보 등 식별
//			2) referrer : 이전 페이지의 주소 A -> B, A를 통해서 B를 진입할때 사이트의 주소 애널리틱스 분석
//			3) 이전 cache 정보 삭제 : Expires, Cache_Control, Pragma 
		
//		0. URI / URL 요청 주소 
		String uri = request.getRequestURI();
		String url = request.getRequestURL().toString();
		log.info("요청 uri : {} ", uri);
		log.info("요청 url : {}",url);
//		1. 접근을 시도하는 주소를 출력 
		String remoteAddr = request.getRemoteAddr();
		log.info("RemoteAddr : {}", remoteAddr);
		
//		2. 쿼리 스트링 GET에서 주소를 통해서 전달하는 키 = 값
		String queryString = request.getQueryString();
		queryString = StringUtils.defaultIfEmpty(queryString, "");
		log.info("QueryString : {} ", queryString);

//		3. 이전 페이지 
		String referrer = StringUtils.defaultIfEmpty(request.getHeader("Referer"), "-");
		log.info("referrer = {} ", referrer);
		
//		4. 요청된 Client의 정보 
		String userAgent = request.getHeader("User-Agent");
		userAgent = Strings.nullToEmpty(userAgent);
		log.info("user-Agent {}",userAgent);
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(url)
			.append("?").append(queryString).append(":")
			.append(referrer).append(":").append(userAgent);
		log.info("[Client Access Logger],  {}",sb.toString());
		
		
		chain.doFilter(req, resp);
		
//		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Access Filter init()");
	}

	@Override
	public void destroy() {
		log.info("Access Filter destory()");
	}
}
