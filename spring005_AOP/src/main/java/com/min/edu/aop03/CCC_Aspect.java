package com.min.edu.aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CCC_Aspect {
	
	@Before("execution(public void com.min.edu.aop03.*.*(..))")
	public void beforeMethod() { // advice 
		System.out.println("메소드를 실행한다."); // Before
	}
	
	@AfterThrowing(pointcut = "execution(public void com.min.edu.aop03.*.*(..))", throwing = "e")
	public void exceptionMethod(Exception e) { // advice
		System.out.println("오류 발생 했다." + e.getMessage()); // afterThrowing
	}
	
	@After("execution(public void com.min.edu.aop03.CEO.*(..))")
	public void afterMethod() { // advice
		System.out.println("메소드 종료 되었다."); // after
	}
}
