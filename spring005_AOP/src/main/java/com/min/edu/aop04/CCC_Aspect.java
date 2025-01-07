package com.min.edu.aop04;

public class CCC_Aspect {

	public void beforeMethod() { // advice
		System.out.println("메소드를 실행한다."); // Before
	}

	public void exceptionMethod(Exception e) { // advice
		System.out.println("오류 발생 했다." + e.getMessage()); // afterThrowing
	}

	public void afterMethod() { // advice
		System.out.println("메소드 종료 되었다."); // after
	}
}
