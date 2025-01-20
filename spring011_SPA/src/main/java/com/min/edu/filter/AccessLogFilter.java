package com.min.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessLogFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("Client의 로그 : WebFilter를 통한 WAS에 접속한 정보를 확인");
		HttpServletRequest req = (HttpServletRequest) request;
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String queryString = req.getQueryString()==null?"":req.getQueryString();
		
		String refer = StringUtils.defaultIfEmpty(req.getHeader("Refer"), "-");
		String agent = StringUtils.defaultIfEmpty(req.getHeader("User-Agent"), "-");
		log.info("요청된 주소 : {}", remoteAddr.concat(".").concat(uri).concat("?").concat(queryString));
		log.info("유입 경로 : {} ", refer);
		log.info("유입 software 정보 : {}", agent);
		chain.doFilter(request, response);
	}

}
