package com.min.edu.aop;


import org.aspectj.lang.JoinPoint;

import lombok.extern.slf4j.Slf4j;

/*
 * TODO 10801 AOP가 동작되는 Advice 정의
 */
@Slf4j
public class DaoLogExecute {

	public void before(JoinPoint j) {
		String methodName = j.getSignature().getName();
		log.info("메소드 시작 : {} ", methodName);
		
		Object[] args = j.getArgs();
		if(args != null) {
			log.info("method \t {}", methodName);
			for(int i=0; i<args.length; i++) {
				log.info(i+"번째 {}",args[i].toString());
			}
			log.info("method \t {}" , methodName);
		}
	}
	
	public void afterReturning(JoinPoint j,Object result) {
		String methodName = j.getSignature().getName();
		log.info(methodName + ":메소드 종료");
		log.info("반환값 : {}", result);
	}
	
	public void error(JoinPoint j, Exception exception) {
		String methodName = j.getSignature().getName();
		log.info(methodName + ": 메소드 예외발생");
		log.info("예외 메세지 : {}", exception.toString());
	}
	
	
}
